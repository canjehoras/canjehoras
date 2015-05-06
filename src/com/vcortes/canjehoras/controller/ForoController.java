package com.vcortes.canjehoras.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;

public class ForoController extends BaseController{
	
	public static final Log log = LogFactory.getLog(ForoController.class);
	private UsuarioBL usuarioBL;
	private TruequeBL truequeBL;

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
	
	public ModelAndView listado(HttpServletRequest request, HttpServletResponse response){
		log.debug("Listado de comentarios");	
		Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE); 
		try{
			List<Trueque> listado = truequeBL.findTrueque(null, null,null,null);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}

}
