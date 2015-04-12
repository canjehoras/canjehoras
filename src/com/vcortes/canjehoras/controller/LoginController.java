package com.vcortes.canjehoras.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.CategoriaBL;
import com.vcortes.canjehoras.bl.PrefCategoriaBL;
import com.vcortes.canjehoras.bl.PrefProvinciaBL;
import com.vcortes.canjehoras.bl.ProvinciaBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.PrefCategoria;
import com.vcortes.canjehoras.model.PrefProvincia;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;


public class LoginController extends BaseController{
	
	public static final Log log = LogFactory.getLog(LoginController.class);
	
	private UsuarioBL usuarioBL;
	private CategoriaBL categoriaBL;
	private ProvinciaBL provinciaBL;
	private TruequeBL truequeBL;
	private PrefProvinciaBL prefProvinciaBL;
	private PrefCategoriaBL prefCategoriaBL;
	
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}
	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}
	public CategoriaBL getCategoriaBL() {
		return categoriaBL;
	}
	public void setProvinciaBL(ProvinciaBL provinciaBL) {
		this.provinciaBL = provinciaBL;
	}
	public void setCategoriaBL(CategoriaBL categoriaBL) {
		this.categoriaBL = categoriaBL;
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
	 * Método que comprueba si el login y la password son correctos
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(Constantes.LOGIN);  
		try {
			String descripcion = "";
			String email = request.getParameter("correo_electronico");
			String pass = request.getParameter("pass");
			Usuario usuario = (Usuario) usuarioBL.findUsuarioByLogin(email);
			if(usuario != null && comprobarPass(usuario, pass)){
				//ponemos usuario en sesión
				request.getSession().setAttribute(Constantes.USUARIO, usuario);
				request.getSession().setAttribute(Constantes.PERFIL, usuario.getPerfil());
				
//				List<Trueque> listado = truequeBL.findTrueque(null, null);
//				for (int i = 0; i<listado.size(); i++){
//					if(((Trueque)listado.get(i)).getDescripcion().length() > new Integer(25)){
//						descripcion = ((Trueque)listado.get(i)).getDescripcion().substring(0,25) + "...";
//						((Trueque)listado.get(i)).setDescripcion(descripcion);
//					}
////					if(null != ((Trueque)listado.get(i)).getUsuario()){
////						if(null != ((Trueque)listado.get(i)).getUsuario().getProvincia()){
////							((Trueque)listado.get(i)).setProvincia(((Trueque)listado.get(i)).getUsuario().getProvincia().getDescripcion());
////						}
////					}
//				}
//				model.addObject( Constantes.TRUEQUES, listado);

				model = new ModelAndView(Constantes.LISTA_TRUEQUE);  
			}
		} catch (Exception e) {
			log.error("Error obteniendo usuario",e);
		} catch (Throwable e) {
			log.error("Error obteniendo usuario",e);
		}
		return model;
	}
	
	/**
	 * Método que hace las comprobaciones necesarias para verificar que el password introducido es el del usuario
	 * @param usuario
	 * @param pass
	 * @return
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
			List<Categoria> categorias = categoriaBL.findAll(new Categoria(), "descripcion");
			model.addObject("categorias", categorias);
			
			List<Categoria> provincias = categoriaBL.findAll(new Provincia(),  "descripcion");
			model.addObject("provincias", provincias);
		
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		}
		return model;
	}
	
	public ModelAndView recordarContrasenya(HttpServletRequest request, HttpServletResponse response){
		log.debug("Inicio recordar contrasenya");
		ModelAndView model = new ModelAndView(Constantes.RECORDAR_PASS);
//		try{
//			List<Categoria> categorias = categoriaBL.findAll(new Categoria(), "descripcion");
//			model.addObject("categorias", categorias);
//			
//			List<Categoria> provincias = categoriaBL.findAll(new Provincia(),  "descripcion");
//			model.addObject("provincias", provincias);
//		
//		} catch(Exception e){
//			logger.error("Error al obtener los listados de la pantalla de login",e);
//		}
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
			String telefono = (String) request.getParameter(Constantes.BBDD_USUARIO_TELEFONO);
			String wassap = (String) request.getParameter(Constantes.BBDD_USUARIO_WASSAP);
			String provincia[]= request.getParameterValues(Constantes.BBDD_USUARIO_PROVINCIA);
			String categoria[]= request.getParameterValues(Constantes.BBDD_USUARIO_CATEGORIA);
			
			
			Usuario usuario = new Usuario();
			usuario.setCorreo_electronico(correo_electronico);
			usuario.setPass(pass);
			usuario.setNombre(nombre);
			usuario.setApellido1(apellido1);
			usuario.setApellido2(apellido2);
			usuario.setMovil(movil);
			usuario.setTelefono(telefono);
			usuario.setWassap(new Boolean(wassap));
			usuario.setFecha_alta(sdf.parse(sdf.format(new Date())));
			usuario.setFecha_ultimo_acceso(sdf.parse(sdf.format(new Date())));
			usuario.setIdioma(Constantes.IDIOMA_ES);
			usuario.setPerfil(Constantes.TIPO_USUARIO);
		
			usuario = (Usuario) usuarioBL.saveOrUpdate(usuario);
			
			for (int i = 0; i < provincia.length; i++) {
				Provincia p = (Provincia) provinciaBL.findById(new Provincia(), new Long(provincia[i]));
				PrefProvincia prefProvincia = new PrefProvincia();
				prefProvincia.setUsuario(usuario);
				prefProvincia.setProvincia(p);
				prefProvinciaBL.saveOrUpdate(prefProvincia);
			}
				
			for (int i = 0; i < categoria.length; i++) {
				Categoria c = (Categoria) categoriaBL.findById(new Categoria(), new Long(categoria[i]));
				PrefCategoria prefCategoria = new PrefCategoria();
				prefCategoria.setUsuario(usuario);
				prefCategoria.setCategoria(c);
				prefCategoriaBL.saveOrUpdate(prefCategoria);
			}
			

			
			// una vez registrado el usuario lo logueamos
			login(request, response);
		} catch (Exception e) {
			logger.error("Error registrando usuario", e);
		}
		try {
			response.sendRedirect("../trueque/listado.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView(Constantes.LISTA_TRUEQUE);
	}
	
	/**
	 * Cierre de sesión
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(); 
		request.getSession().setAttribute(Constantes.USUARIO, null);
		model = new ModelAndView(Constantes.INICIO); 
		return model;
	}

}
