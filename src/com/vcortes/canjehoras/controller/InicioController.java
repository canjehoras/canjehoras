package com.vcortes.canjehoras.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.utils.Constantes;


public class InicioController extends BaseController{
	
	private TruequeBL truequeBL;

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView model = new ModelAndView(Constantes.INICIO); 
		try {
			List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
			getListadoTrueques(listado);
			model.addObject("trueques", listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	public ModelAndView inicio(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		return new ModelAndView(Constantes.INICIO);
	}
	
	
	
	
	public TruequeBL getTruequeBL() {
		return truequeBL;
	}
	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
}
