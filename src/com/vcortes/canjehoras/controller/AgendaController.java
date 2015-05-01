package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;

public class AgendaController extends BaseController {
	
	private UsuarioBL usuarioBL;
	private TruequeBL truequeBL;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView agenda(HttpServletRequest request, HttpServletResponse response){
		log.debug("Entramos en la agenda del usuario");	
		Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}
		ModelAndView model = new ModelAndView(Constantes.AGENDA); 

		
		
		
		return model;
	}


	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}


	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}


	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

}
