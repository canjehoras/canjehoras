package com.vcortes.canjehoras.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.CategoriaBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.utils.Constantes;

public class CategoriaController extends BaseController {

	public static final Log log = LogFactory.getLog(CategoriaController.class);
	private CategoriaBL categoriaBL;
	private TruequeBL truequeBL;

	public void setCategoriaBL(CategoriaBL categoriaBL) {
		this.categoriaBL = categoriaBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

	/**
	 * @throws Throwable
	 */
	public ModelAndView inicio(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		ModelAndView model = new ModelAndView(Constantes.LISTA_CATEGORIA);
		try {
			List<Categoria> categorias = categoriaBL.findAll(new Categoria(),
					Constantes.DESCRIPCION);
			model.addObject(Constantes.CATEGORIAS, categorias);
			

			List<Trueque> listado = truequeBL.findAll(new Trueque());
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Exception e) {
			logger.error("Error al obtener el listado de las categorias", e);
		}
		return model;
	}
}
