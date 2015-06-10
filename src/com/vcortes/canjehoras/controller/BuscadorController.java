package com.vcortes.canjehoras.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.BuscadorBL;
import com.vcortes.canjehoras.bl.ProvinciaBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.utils.Constantes;

/**
 * Lógica de negocio de la Clase Buscador
 * 
 * @author Vanesa Cortés
 *
 */
public class BuscadorController extends BaseController {

	public static final Log log = LogFactory.getLog(BuscadorController.class);
	
	/** Declaración de los BL necesarios */
	private BuscadorBL buscadorBL;
	private TruequeBL truequeBL;
	private ProvinciaBL provinciaBL;
	
	/** Getter y setter de los BL necesarios */
	public void setBuscadorBL(BuscadorBL buscadorBL) {
		this.buscadorBL = buscadorBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

	public void setProvinciaBL(ProvinciaBL provinciaBL) {
		this.provinciaBL = provinciaBL;
	}

	/**
	 * Método que devuelve los datos para mostrar el formulario de búsqueda
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView formulario de búsqueda
	 * @throws Throwable
	 */
	public ModelAndView inicio(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		ModelAndView model = new ModelAndView(Constantes.BUSCADOR);
		try {
			// Recupera el listado de categorias
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			model.addObject(Constantes.CATEGORIAS, categorias);			
		} catch (Exception e) {
			logger.error("Error al entrar en la pantalla del buscador", e);
		}
		return model;
	}
	
	/**
	 * Método que realiza la búsqueda marcada
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView listado con resultados
	 */
	public ModelAndView buscar(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(Constantes.BUSCADOR_RESULTADOS);
		try {

			String descripcion = request.getParameter("descripcion");
			String codProvincias = request.getParameter("provincias");
			String idCategoria = request.getParameter("categoria");
			
			// Busca las categorias
			Categoria categoria = null;
			if(idCategoria!=null){
				categoria = (Categoria) truequeBL.findById(new Categoria(), Long.valueOf(idCategoria));
			}
			
			// Busca por provincia
			String[] p = codProvincias.split(",");
			ArrayList<Provincia> provincias = new ArrayList();
			Provincia prov = null;
			for (int i = 0; i < p.length; i++) {
				String codigo = p[i];
				prov = provinciaBL.findProvinciaByCodigo(codigo);
				if(prov!=null){
					provincias.add(prov);
				}
			}
			
			// Realiza la búsqueda de todos trueques por los filtros
			List<Trueque> listado = truequeBL.buscarTrueques(descripcion, provincias, categoria);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		
		} catch (Exception e) {
			logger.error("Error realizar la búsqueda introducida", e);
		}
		return model;
	}
}
