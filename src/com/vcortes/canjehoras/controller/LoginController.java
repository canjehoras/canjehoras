package com.vcortes.canjehoras.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.BuscadorBL;
import com.vcortes.canjehoras.bl.PrefCategoriaBL;
import com.vcortes.canjehoras.bl.PrefProvinciaBL;
import com.vcortes.canjehoras.bl.ProvinciaBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.PrefCategoria;
import com.vcortes.canjehoras.model.PrefProvincia;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.JSONObject;

/**
 * Lógica de negocio de la clase Login
 * 
 * @author Vanesa Cortés
 *
 */
public class LoginController extends BaseController{
	
	public static final Log log = LogFactory.getLog(LoginController.class);
	
	/** Declaración de los BL necesarios */
	private UsuarioBL usuarioBL;
	private BuscadorBL buscadorBL;
	private ProvinciaBL provinciaBL;
	private TruequeBL truequeBL;
	private PrefProvinciaBL prefProvinciaBL;
	private PrefCategoriaBL prefCategoriaBL;
	
	/** Getter y setter de los BL necesarios */
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}
	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}
	public BuscadorBL getBuscadorBL() {
		return buscadorBL;
	}
	public void setProvinciaBL(ProvinciaBL provinciaBL) {
		this.provinciaBL = provinciaBL;
	}
	public void setBuscadorBL(BuscadorBL buscadorBL) {
		this.buscadorBL = buscadorBL;
	}
	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
	public void setPrefProvinciaBL(PrefProvinciaBL prefProvinciaBL) {
		this.prefProvinciaBL = prefProvinciaBL;
	}
	public void setPrefCategoriaBL(PrefCategoriaBL prefCategoriaBL) {
		this.prefCategoriaBL = prefCategoriaBL;
	}
	
	/**
	 * Método que comprueba si el login y el password son correctos
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		
		// Se retorna al listado de trueques
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE);  
		
		try {
			// Parametros que se recuperan de la pantalla login
			String email = request.getParameter(Constantes.CORREO_ELECTRONICO);
			String pass = request.getParameter(Constantes.PASS);
			
			// Recupera datos del usuario registrado
			Usuario usuario = (Usuario) usuarioBL.findUsuarioByLogin(email);
			
			// Comprobar que el usuario existe en bbdd
			if(usuario != null){
				
				// Comprobar que el password corresponde con el usuario registrado
				if(comprobarPass(usuario, pass)){
					//ponemos usuario en sesión
					request.getSession().setAttribute(Constantes.USUARIO, usuario);
					request.getSession().setAttribute(Constantes.PERFIL, usuario.getPerfil());
					
					// Recuperar las preferencias
					ArrayList<Long> listadoProvincia = new ArrayList<Long>();
					List<PrefProvincia> listPrefProvincia = prefProvinciaBL.findByUsuario(usuario.getId());
					for(PrefProvincia provincia: listPrefProvincia){
						listadoProvincia.add(provincia.getProvincia().getId());
					}
					request.getSession().setAttribute("listadoProvincia", listadoProvincia);
					ArrayList<Long> listadoCategoria = new ArrayList<Long>();
					List<PrefCategoria> listPrefCategoria = prefCategoriaBL.findByUsuario(usuario.getId());
					for(PrefCategoria categoria: listPrefCategoria){
						listadoCategoria.add(categoria.getCategoria().getId());
					}
					request.getSession().setAttribute("listadoCategoria", listadoCategoria);
					
					// Suma el contador de numero de accesos
					int num_acceso = usuario.getNum_acceso();
					if(num_acceso > 0){
						num_acceso = num_acceso + new Integer(1);
						usuario.setNum_acceso(num_acceso);
						usuarioBL.saveOrUpdate(usuario);
					}
					
					try{
						List<Trueque> listado = truequeBL.findTruequePreferencias(listadoProvincia, listadoCategoria, Constantes.TRUEQUE_ESTADO_NUEVO);
						getListadoTrueques(listado);
						request.getSession().setAttribute(Constantes.MENSAJE_ERROR, null);
						model.addObject(Constantes.TRUEQUES, listado);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}else{
					// Cuando el password no corresponde con el usuario registrado
		            List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
		            getListadoTrueques(listado);
		            model.addObject(Constantes.TRUEQUES, listado);
		            request.getSession().setAttribute(Constantes.MENSAJE_ERROR, Constantes.ERROR_PASS);
					model = new ModelAndView(Constantes.INICIO); 
				}
			}else{
				// El usuario no tiene datos
	            List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
	            getListadoTrueques(listado);
	            model.addObject(Constantes.TRUEQUES, listado);
	            request.getSession().setAttribute(Constantes.MENSAJE_ERROR, Constantes.ERROR_USUARIO);
				model = new ModelAndView(Constantes.INICIO); 
			}
			
		} catch (Exception e) {
			log.error("Error al recuperar usuario",e);
		} catch (Throwable e) {
			log.error("Error al recuperar usuario",e);
		}
		return model;
	}
	
	
	/**
	 * Método que hace las comprobaciones necesarias para verificar que el password introducido es el del usuario
	 * 
	 * @param usuario
	 * @param pass
	 * @return boolean
	 */
	private boolean comprobarPass(Usuario usuario, String pass){
		if(usuario.getPass().equals(pass)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView registro(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio registro");
		ModelAndView model = new ModelAndView(Constantes.REGISTRO);
		try{
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), "descripcion");
			model.addObject("categorias", categorias);
			
			List<Categoria> provincias = buscadorBL.findAll(new Provincia(),  "descripcion");
			model.addObject("provincias", provincias);
		
			List<String> listadoIdiomas = new ArrayList<String>();  
			listadoIdiomas.add("Castellano"); 
			listadoIdiomas.add("Ingles"); 
			model.addObject("listadoIdiomas", listadoIdiomas);
			
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		}
		return model;
	}
	
	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView editar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Editar registro");
		ModelAndView model = new ModelAndView(Constantes.EDITAR_REGISTRO);
		try{
			
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			model.addObject("usuario", usuario);
			
			ArrayList<Long> listadoProvincia = new ArrayList<Long>();
			List<PrefProvincia> listPrefProvincia = prefProvinciaBL.findByUsuario(usuario.getId());
			for(PrefProvincia provincia: listPrefProvincia){
				listadoProvincia.add(provincia.getProvincia().getId());
			}
			
			ArrayList<Long> listadoCategoria = new ArrayList<Long>();
			List<PrefCategoria> listPrefCategoria = prefCategoriaBL.findByUsuario(usuario.getId());
			for(PrefCategoria categoria: listPrefCategoria){
				listadoCategoria.add(categoria.getCategoria().getId());
			}

			
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), "descripcion");
			for (Iterator iterator = categorias.iterator(); iterator.hasNext();) {
				Categoria categoria = (Categoria) iterator.next();
				if(listadoCategoria.contains(categoria.getId())){
					categoria.setSeleccionado(Boolean.TRUE);
				}
			}
			
			model.addObject("categorias", categorias);
			
			List<Provincia> provincias = buscadorBL.findAll(new Provincia(),  "descripcion");
			for (Iterator iterator = provincias.iterator(); iterator.hasNext();) {
				Provincia provincia = (Provincia) iterator.next();
				if(listadoProvincia.contains(provincia.getId())){
					provincia.setSeleccionado(Boolean.TRUE);
				}
			}
			model.addObject("provincias", provincias);
			
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView recordarContrasenya(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio recordar contrasenya");
		ModelAndView model = new ModelAndView(Constantes.RECORDAR_PASS);
		return model;
	}
	
	public ModelAndView recordar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio recordar");
		ModelAndView model = new ModelAndView(Constantes.RECORDAR_PASS_OK);
		return model;
	}
	
	/**
	 * 
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView envioRegistro(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio registro");
		
		try {
			
			// Recuperación de los atributos
			request.setCharacterEncoding(Constantes.ENCODING);
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
			String correo_electronico = (String) request.getParameter(Constantes.BBDD_USUARIO_CORREO);
			String pass = (String) request.getParameter(Constantes.BBDD_USUARIO_PASS);
			String nombre = (String) request.getParameter(Constantes.BBDD_USUARIO_NOMBRE);
			String apellido1 = (String) request.getParameter(Constantes.BBDD_USUARIO_APELLIDO1);
			String apellido2 = (String) request.getParameter(Constantes.BBDD_USUARIO_APELLIDO2);
			String movil = (String) request.getParameter(Constantes.BBDD_USUARIO_MOVIL);
			String provincia[]= request.getParameterValues(Constantes.BBDD_USUARIO_PROVINCIA);
			String categoria[]= request.getParameterValues(Constantes.BBDD_USUARIO_CATEGORIA);
			String provincias = request.getParameter(Constantes.BBDD_USUARIO_PROVINCIAS);
			String fechaNacimiento = request.getParameter(Constantes.BBDD_FECHA_NACIMIENTO);
			String idioma = (String) request.getParameter(Constantes.BBDD_IDIOMA);
			if(idioma.equals(Constantes.IDIOMA_ESPANOL)){
				idioma = Constantes.IDIOMA_ES;
			}
			if(idioma.equals(Constantes.IDIOMA_INGLES)){
				idioma = Constantes.IDIOMA_EN;
			}
			
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(usuario == null){
				usuario = new Usuario();
				usuario.setFecha_alta(sdf.parse(sdf.format(new Date())));
				usuario.setNum_acceso(new Integer(1));				
			}
			
			usuario.setCorreo_electronico(correo_electronico);
			usuario.setPass(pass);
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setMovil(movil);
			usuario.setFecha_nacimiento(sdf.parse(fechaNacimiento));
			usuario.setFecha_ultimo_acceso(sdf.parse(sdf.format(new Date())));
			usuario.setIdioma(idioma);
			usuario.setPerfil(Constantes.TIPO_USUARIO);
			
			Provincia pr = (Provincia) provinciaBL.findById(new Provincia(), new Long(provincias));
			usuario.setProvincia(pr);
		
			usuario = (Usuario) usuarioBL.saveOrUpdate(usuario);
			
			/* Eliminamos las preferencias para incluirle las nuevas */
			Collection<PrefProvincia> listPrefProvincia = prefProvinciaBL.findByUsuario(usuario.getId());
			for (Iterator iterator = listPrefProvincia.iterator(); iterator.hasNext();) {
				PrefProvincia prefProvincia = (PrefProvincia) iterator.next();
				prefProvinciaBL.delete(prefProvincia);
			}
			for (int i = 0; i < provincia.length; i++) {
				Provincia p = (Provincia) provinciaBL.findById(new Provincia(), new Long(provincia[i]));
				PrefProvincia prefProvincia = new PrefProvincia();
				prefProvincia.setUsuario(usuario);
				prefProvincia.setProvincia(p);
				prefProvinciaBL.saveOrUpdate(prefProvincia);
			}
			
			Collection<PrefCategoria> listPrefCategoria = prefCategoriaBL.findByUsuario(usuario.getId());
			for (Iterator iterator = listPrefCategoria.iterator(); iterator.hasNext();) {
				PrefCategoria prefCategoria = (PrefCategoria) iterator.next();
				prefProvinciaBL.delete(prefCategoria);
			}
			for (int i = 0; i < categoria.length; i++) {
				Categoria c = (Categoria) buscadorBL.findById(new Categoria(), new Long(categoria[i]));
				PrefCategoria prefCategoria = new PrefCategoria();
				prefCategoria.setUsuario(usuario);
				prefCategoria.setCategoria(c);
				prefCategoriaBL.saveOrUpdate(prefCategoria);
			}
			
		} catch (Exception e) {
			logger.error("Error registrando usuario", e);
		} catch (Throwable e) {
			logger.error("Error registrando usuario", e);
			e.printStackTrace();
		}
//		try {
//			response.sendRedirect("../trueque/listado.html");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return login(request, response);
	}
	
	/**
	 * Cierre de sesión
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(Constantes.INICIO); 
		try {
			List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
			getListadoTrueques(listado);
			model.addObject("trueques", listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		request.getSession().setAttribute(Constantes.USUARIO, null);
		return model;
	}
	
	public ModelAndView contacto(HttpServletRequest request, HttpServletResponse response){
		log.debug("Contacto Usuario");
		ModelAndView model = new ModelAndView(Constantes.CONTACTO); 
		try {
			request.setCharacterEncoding(Constantes.ENCODING);
			String id_usuario = request.getParameter("id_usuario");
			Long id = new Long(id_usuario);
			Usuario usuario = usuarioBL.findUsuarioById(id);
			model.addObject("usuario", usuario);
		} catch (Throwable e) {
			logger.error("Error registrando usuario", e);
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView contactoEmail(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		ModelAndView model = new ModelAndView(Constantes.ENVIAR_EMAIL); 
		return model;
	}
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @throws Throwable 
	 */
	public ModelAndView cambiarIdioma(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		logger.debug(" :: Cambio de idioma ::");
		JSONObject o = new JSONObject();
		String idioma = request.getParameter("idioma");
		
		if(idioma!=null && !"".equals(idioma)){
			request.getSession().setAttribute("idioma", idioma);
			Locale.setDefault(new Locale(idioma));
			
/*			if("es".equals(idioma)){
			}else if("en".equals(idioma)){
				Locale.setDefault(new Locale("EN","en"));
			}
*/			
			
			
		}
		return enviarRespuestaAJAX(response, o.toString());
		
		
	}
}
