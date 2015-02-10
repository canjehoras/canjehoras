package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public abstract class BaseController implements Controller{
	
	public static final Log log = LogFactory.getLog(BaseController.class);

	@Override
	public abstract ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception;
	
}