package com.vcortes.canjehoras.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.BuscadorBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.utils.Constantes;

public class BuscadorController extends BaseController {

	public static final Log log = LogFactory.getLog(BuscadorController.class);
	private BuscadorBL buscadorBL;
	private TruequeBL truequeBL;


	/**
	 * @throws Throwable
	 */
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ModelAndView model = new ModelAndView(Constantes.BUSCADOR);
		try {
			
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			model.addObject(Constantes.CATEGORIAS, categorias);			

			List<Trueque> listado = truequeBL.findAll(new Trueque());
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Exception e) {
			logger.error("Error al obtener el listado de las categorias", e);
		}
		return model;
	}

	public void setBuscadorBL(BuscadorBL buscadorBL) {
		this.buscadorBL = buscadorBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
}
