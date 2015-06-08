package com.vcortes.canjehoras.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.utils.Constantes;

/**
 * Lógica de negocio de la clase Inicio
 * 
 * @author Vanesa Cortés
 *
 */
public class InicioController extends BaseController{
	
	/** Declaración de los BL necesarios */
	private TruequeBL truequeBL;
	
	/** Getter y setter de los BL necesarios */
	public TruequeBL getTruequeBL() {
		return truequeBL;
	}
	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

	/**
	 * Carga la página de inicio
	 * @param request
	 * @param response
	 * @return ModelAndView
	 * @throws Exception
	 */
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 return new ModelAndView(Constantes.INICIO);
	}
	
	/**
	 * Busca los últimos trueques para mostrar en el inicio
	 */
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView model = new ModelAndView(Constantes.INICIO);
        try {
            List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
            getListadoTrueques(listado);
            request.getSession().setAttribute(Constantes.MENSAJE_ERROR, null);
            model.addObject(Constantes.TRUEQUES, listado);
        } catch (Throwable e) {
        	e.printStackTrace();
        }
        return model;
    }
}
