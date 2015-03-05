package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.Pantallas;


public class LoginController extends BaseController{
	
	public static final Log log = LogFactory.getLog(LoginController.class);
	private UsuarioBL usuarioBL;

	
	/**
	 * Método que comprueba si el login y la password son correctos
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView login (HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(); 
		try {
			
			String email = request.getParameter("correoElectronico");
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
	public ModelAndView registro(HttpServletRequest arg0, HttpServletResponse arg1){
		log.debug("Inicio registro");
		return new ModelAndView(Pantallas.LOGIN);
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

}
