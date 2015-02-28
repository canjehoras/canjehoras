package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.utils.Constantes;


public class InicioController extends BaseController{
	
	private UsuarioBL usuarioBL;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//usuarioBL.findUsuarioByLogin("ALAVA");
		return new ModelAndView(Constantes.INICIO);
		
	}
	public ModelAndView inicio(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//usuarioBL.findUsuarioByLogin("ALAVA");
		return new ModelAndView(Constantes.INICIO);
		
	}

	
	
	
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

}
