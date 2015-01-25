package com.vcortes.canjehoras.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public abstract class BaseController implements Controller{

	@Override
	public abstract ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception;
	
}