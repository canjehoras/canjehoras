package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;


public abstract class BaseController extends MultiActionController {
	
	
	public static final Log log = LogFactory.getLog(BaseController.class);
	
	/**
	 * Comprueba si en la sesión hay un usuario logueado
	 * @param request
	 * @return
	 */
	public Usuario comprobarUsuario(HttpServletRequest request){
		Usuario usuario = (Usuario) request.getSession().getAttribute(Constantes.USUARIO);
		return usuario;
	}
	
}