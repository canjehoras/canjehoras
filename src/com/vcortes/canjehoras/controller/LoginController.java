package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Pantallas;


public class LoginController extends MultiActionController{
	
	public static final Log log = LogFactory.getLog(LoginController.class);
	private UsuarioBL usuarioBL;

	
	/**
	 * Método que comprueba si el login y la password son correctos
	 * @param arg0
	 * @param arg1
	 * @param form
	 * @return
	 */
	public ModelAndView login (HttpServletRequest arg0, HttpServletResponse arg1){
		ModelAndView model = new ModelAndView(); 
		try {
			/*Usuario usuario = (Usuario) usuarioBL.findUsuarioByLogin(form.getCorreoElectronico());
			if(usuario != null && comprobarPass(usuario, form.getPass())){
				model = new ModelAndView(Pantallas.INICIO); 
			}*/
		} catch (Exception e) {
			log.error("Error obteniendo usuario",e);
		}
		model = new ModelAndView(Pantallas.LOGIN); 
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
		
		arg0.getParameter("pass");
		
		
		
		
		
		
		return null;
	}
	
	
	
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

}
