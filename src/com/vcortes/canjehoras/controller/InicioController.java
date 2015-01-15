package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.utils.Constantes;


public class InicioController extends BaseController{
	
	
	
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response){
		
		return new ModelAndView(Constantes.INICIO);
	}

}
