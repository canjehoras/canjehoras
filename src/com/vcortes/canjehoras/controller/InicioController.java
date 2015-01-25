package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.vcortes.canjehoras.utils.Constantes;

public class InicioController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView inicio = new ModelAndView(Constantes.INICIO);
		
		return inicio;
	}

}