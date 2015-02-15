package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;


public abstract class BaseController extends MultiActionController {
	
	public static final Log log = LogFactory.getLog(BaseController.class);
	
	/**
	 * Instancia del método que ejecuta el bean actionResolver (Controller.java) y devuelve el método al que tiene que entrar de
	 * la clase destino.
	 */
//	public BaseController() {
//		super();
//		this.setMethodNameResolver((MethodNameResolver) BeanGetter.getBean("actionResolver"));
//	}

	@Override
	public abstract ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception;
	
}