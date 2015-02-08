package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.utils.Constantes;


public class LoginController extends BaseController{
	
	private UsuarioBL usuarioBL;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView(Constantes.LOGIN);
	}

	
	
	
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

}
