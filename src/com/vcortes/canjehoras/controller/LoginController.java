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
import com.vcortes.canjehoras.utils.Mail;

/**
 * Lógica de negocio de la Clase Login
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
	 * Método inicio de sesión de un usuario registrado
	 * 
	 * Comprueba si el login y el password son correctos
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView listado de trueques
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		
		// Se retorna al listado de trueques
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE);  
		
		try {
			// Parametros que se recuperan de la pantalla login
			String email = request.getParameter(Constantes.CORREO_ELECTRONICO);
			String pass = request.getParameter(Constantes.PASS);
			String correo = (String) request.getSession().getAttribute(Constantes.CORREO_ELECTRONICO);
			// Si el usuario a marcado la opción de recordatorio de contraseña
			if(correo!= null && correo.equals(Constantes.RECORDATORIO)){
	            List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
	            getListadoTrueques(listado);
	            model.addObject(Constantes.TRUEQUES, listado);
	            request.getSession().setAttribute(Constantes.MENSAJE_ERROR, Constantes.EMAIL_RECORDATORIO);
	            request.getSession().setAttribute(Constantes.CORREO_ELECTRONICO, "");
				model = new ModelAndView(Constantes.INICIO); 
				return model;
			}
			
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
						model.addObject(Constantes.COMBO_FILTRO_TRUEQUE, Constantes.PREFERENCIAS);
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
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView verTrueques(HttpServletRequest request, HttpServletResponse response){
		// Se retorna al listado de trueques
		// Recuperar las preferencias
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE);  
		ArrayList<Long> listadoProvincia = new ArrayList<Long>();
		ArrayList<Long> listadoCategoria = new ArrayList<Long>();
		List<Trueque> listado = new ArrayList<Trueque>();
		try{
			String filtroTrueque = request.getParameter("filtroTrueque");
			model.addObject("filtroTrueque", filtroTrueque);
			
			if(filtroTrueque!=null && !filtroTrueque.equals("")){
				if(filtroTrueque.equalsIgnoreCase("todos")){
					listado = truequeBL.findTruequePreferencias(listadoProvincia, listadoCategoria, Constantes.TRUEQUE_ESTADO_NUEVO);	
				} else if(filtroTrueque.equalsIgnoreCase("preferencias")){
					Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
					
					List<PrefProvincia> listPrefProvincia = prefProvinciaBL.findByUsuario(usuario.getId());
					for(PrefProvincia provincia: listPrefProvincia){
						listadoProvincia.add(provincia.getProvincia().getId());
					}
					
					List<PrefCategoria> listPrefCategoria = prefCategoriaBL.findByUsuario(usuario.getId());
					for(PrefCategoria categoria: listPrefCategoria){
						listadoCategoria.add(categoria.getCategoria().getId());
					}
					listado = truequeBL.findTruequePreferencias(listadoProvincia, listadoCategoria, Constantes.TRUEQUE_ESTADO_NUEVO);
				}
			}
			
			getListadoTrueques(listado);
			
		}catch(Exception e){
			logger.error("Error filtrando trueques", e);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addObject(Constantes.TRUEQUES, listado);
		
		return model;
	}
	
	
	/**
	 * Método que comprueba si el password introducido por el usuario es correcto
	 * 
	 * @param usuario
	 * @param pass
	 * @return true si el pass es correcto, false si el pass no es correcto
	 */
	private boolean comprobarPass(Usuario usuario, String pass){
		if(usuario.getPass().equals(pass)){
			return true;
		}
		return false;
	}
	
	/**
	 * Método que carga el formulario de registro
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView formulario registro
	 */
	public ModelAndView registro(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio registro");
		ModelAndView model = new ModelAndView(Constantes.REGISTRO);
		
		try{
			// Obtiene listado de categorias
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			model.addObject(Constantes.CATEGORIAS, categorias);
			
			// Obtiene listado de provincias
			List<Categoria> provincias = buscadorBL.findAll(new Provincia(), Constantes.DESCRIPCION);
			model.addObject(Constantes.PROVINCIAS, provincias);
		
			// Obtiene listado de idiomas
			List<String> listadoIdiomas = new ArrayList<String>();  
			listadoIdiomas.add(Constantes.IDIOMA_ESPANOL); 
			listadoIdiomas.add(Constantes.IDIOMA_INGLES); 
			model.addObject(Constantes.IDIOMAS, listadoIdiomas);
			
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		}
		return model;
	}
	

	/**
	 * Método para registrar un usuario o modificar datos personales
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView inicio
	 */
	public ModelAndView envioRegistro(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio registro");
		
		try {
			// Codificación UTF-8
			request.setCharacterEncoding(Constantes.ENCODING);
			
			// Recuperación de los atributos
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
			
			// Se comprueba si hay un usuario registrado
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
			if(idioma.equals(Constantes.IDIOMA_ESPANOL)){
				idioma = Constantes.IDIOMA_ES;
			}
			if(idioma.equals(Constantes.IDIOMA_INGLES)){
				idioma = Constantes.IDIOMA_EN;
			}
			usuario.setIdioma(idioma);
			usuario.setPerfil(Constantes.TIPO_USUARIO);
			
			Provincia pr = (Provincia) provinciaBL.findById(new Provincia(), new Long(provincias));
			usuario.setProvincia(pr);
		
			// Guarda o modifica los datos del usuario
			usuario = (Usuario) usuarioBL.saveOrUpdate(usuario);
			
			//Eliminamos las preferencias de provincia para incluirle las nuevas
			Collection<PrefProvincia> listPrefProvincia = prefProvinciaBL.findByUsuario(usuario.getId());
			for (Iterator iterator = listPrefProvincia.iterator(); iterator.hasNext();) {
				PrefProvincia prefProvincia = (PrefProvincia) iterator.next();
				prefProvinciaBL.delete(prefProvincia);
			}
			// Recupera preferencias de provincia
			for (int i = 0; i < provincia.length; i++) {
				Provincia p = (Provincia) provinciaBL.findById(new Provincia(), new Long(provincia[i]));
				PrefProvincia prefProvincia = new PrefProvincia();
				prefProvincia.setUsuario(usuario);
				prefProvincia.setProvincia(p);
				prefProvinciaBL.saveOrUpdate(prefProvincia);
			}
			
			//Eliminamos las preferencias de categoria para incluirle las nuevas
			Collection<PrefCategoria> listPrefCategoria = prefCategoriaBL.findByUsuario(usuario.getId());
			for (Iterator iterator = listPrefCategoria.iterator(); iterator.hasNext();) {
				PrefCategoria prefCategoria = (PrefCategoria) iterator.next();
				prefProvinciaBL.delete(prefCategoria);
			}
			// Recupera preferencias de categoria
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
		// Inicia la sesión
		return login(request, response);
	}	
	
	/**
	 * Método que recupera los datos para mostrar el formulario de datos personales
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView formulario de registro para la edición
	 */
	public ModelAndView editar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Editar registro");
		String fecha = Constantes.ESPACIO_BLANCO;
		ModelAndView model = new ModelAndView(Constantes.EDITAR_REGISTRO);
		try{
			
			// Recupera el datos del usuario de sesión
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			String idioma = Constantes.IDIOMA_ESPANOL;
			if(usuario.getIdioma().equals(Constantes.IDIOMA_EN)){
				idioma = Constantes.IDIOMA_INGLES;
			}
			usuario.setIdioma(idioma);
			model.addObject(Constantes.USUARIO, usuario);
			
			// Recupera el listado de Preferencias por Provincias 
			ArrayList<Long> listadoProvincia = new ArrayList<Long>();
			List<PrefProvincia> listPrefProvincia = prefProvinciaBL.findByUsuario(usuario.getId());
			for(PrefProvincia provincia: listPrefProvincia){
				listadoProvincia.add(provincia.getProvincia().getId());
			}
			
			// Recupera el listado de Preferencias porCategorias 
			ArrayList<Long> listadoCategoria = new ArrayList<Long>();
			List<PrefCategoria> listPrefCategoria = prefCategoriaBL.findByUsuario(usuario.getId());
			for(PrefCategoria categoria: listPrefCategoria){
				listadoCategoria.add(categoria.getCategoria().getId());
			}

			// Recupera el listado de todas las Categorias y marca las preferencias
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			for (Iterator iterator = categorias.iterator(); iterator.hasNext();) {
				Categoria categoria = (Categoria) iterator.next();
				if(listadoCategoria.contains(categoria.getId())){
					categoria.setSeleccionado(Boolean.TRUE);
				}
			}
			model.addObject(Constantes.CATEGORIAS, categorias);
			
			// Recupera el listado de todas las Provincias y marca las preferencias
			List<Provincia> provincias = buscadorBL.findAll(new Provincia(), Constantes.DESCRIPCION);
			for (Iterator iterator = provincias.iterator(); iterator.hasNext();) {
				Provincia provincia = (Provincia) iterator.next();
				if(listadoProvincia.contains(provincia.getId())){
					provincia.setSeleccionado(Boolean.TRUE);
				}
			}
			model.addObject(Constantes.PROVINCIAS, provincias);
			
			// Recupera listado de idiomas y marca el correcto
			List<String> listadoIdiomas = new ArrayList<String>();  
			listadoIdiomas.add(Constantes.IDIOMA_ESPANOL); 
			listadoIdiomas.add(Constantes.IDIOMA_INGLES); 
			model.addObject(Constantes.IDIOMAS, listadoIdiomas);
			
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * Método que muestra el formulario para recordar contraseña
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView formulario de recordatorio
	 */
	public ModelAndView recordarContrasenya(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio recordar contrasenya");
		ModelAndView model = new ModelAndView(Constantes.RECORDAR_PASS);
		return model;
	}
	
	/**
	 * Método que envia email de recordatorio de contraseña
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView informacion
	 * @throws Exception 
	 */
	public ModelAndView recordar(HttpServletRequest request, HttpServletResponse response) throws Exception{
		log.debug("Inicio recordar");
		
		// Recuperamos el email y los datos del usuario
		String email = (String) request.getParameter(Constantes.BBDD_EMAIL);
		Usuario usuario = usuarioBL.findUsuarioByLogin(email);
		if(null != usuario){
			request.getSession().setAttribute(Constantes.CORREO_ELECTRONICO, Constantes.RECORDATORIO);
			// Envio un email al interesado
			Mail mail = new Mail();
			String cuerpo = Constantes.EMAIL_CABECERA_USUARIO + Constantes.BR + Constantes.BR +
					Constantes.EMAIL_APERTURA_H3 + Constantes.EMAIL_RECORDATORIO_PASS + usuario.getPass() + Constantes.EMAIL_CIERRE_H3 + 
					Constantes.EMAIL_SALUDO;
			mail.enviarMail(email, Constantes.EMAIL_ADMINISTRADOR, null, Constantes.EMAIL_ASUNTO_RECORDATORIO_PASS, cuerpo, null, null);
			log.debug("Envio email a " + email);
		}else{
			request.getSession().setAttribute(Constantes.CORREO_ELECTRONICO, Constantes.ERROR_USUARIO);
		}
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

	/**
	 * Método que cambia el idioma de la página
	 * 
	 * @param request
	 * @param response
	 * @throws Throwable 
	 */
	public ModelAndView cambiarIdioma(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		logger.debug("Cambio de idioma");
		JSONObject o = new JSONObject();
		String idioma = request.getParameter(Constantes.BBDD_IDIOMA);
		
		// Se comprueba el idioma
		if(idioma!=null && !"".equals(idioma)){
			request.getSession().setAttribute(Constantes.BBDD_IDIOMA, idioma);
			Locale.setDefault(new Locale(idioma));
		}
		// Retorna a la página filtrado por idioma
		return enviarRespuestaAJAX(response, o.toString());
	}
}
