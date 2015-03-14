package com.vcortes.canjehoras.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.CategoriaBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.Pantallas;


public class LoginController extends BaseController{
	
	public static final Log log = LogFactory.getLog(LoginController.class);
	
	private UsuarioBL usuarioBL;
	private CategoriaBL categoriaBL;

	
	/**
	 * Método que comprueba si el login y la password son correctos
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(); 
		try {
			
			String email = request.getParameter("correo_electronico");
			String pass = request.getParameter("pass");
			Usuario usuario = (Usuario) usuarioBL.findUsuarioByLogin(email);
			if(usuario != null && comprobarPass(usuario, pass)){
				//ponemos usuario en sesión
				request.getSession().setAttribute(Constantes.USUARIO, usuario);
				model = new ModelAndView(Pantallas.INICIO); 
			}
		} catch (Exception e) {
			log.error("Error obteniendo usuario",e);
		}
		model = new ModelAndView(Pantallas.INICIO); 
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
		ModelAndView model = new ModelAndView(Pantallas.LOGIN);
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
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			String correo_electronico = (String) request.getParameter("correo_electronico");
			String pass = (String) request.getParameter("pass");
			String nombre = (String) request.getParameter("nombre");
			String apellido1 = (String) request.getParameter("apellido1");
			String apellido2 = (String) request.getParameter("apellido2");
			String movil = (String) request.getParameter("movil");
			String telefono = (String) request.getParameter("telefono");
			String wassap = (String) request.getParameter("wassap");
			
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
			usuario.setIdioma("es");
			usuario.setPerfil("A");
		
			usuarioBL.saveOrUpdate(usuario);
			
			// una vez registrado el usuario lo logueamos
			login(request, response);
		} catch (Exception e) {
			logger.error("Error registrando usuario", e);
		}
		
		return new ModelAndView(Pantallas.INICIO);
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
		model = new ModelAndView(Pantallas.INICIO); 
		return model;
	}
	
	
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public CategoriaBL getCategoriaBL() {
		return categoriaBL;
	}

	public void setCategoriaBL(CategoriaBL categoriaBL) {
		this.categoriaBL = categoriaBL;
	}

}
