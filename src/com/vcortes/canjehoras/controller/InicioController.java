package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.utils.Constantes;


public class InicioController extends BaseController{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		return new ModelAndView(Constantes.INICIO);
		
	}

}
