package com.vcortes.canjehoras.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;


public abstract class BaseController extends MultiActionController {
	
	
	public static final Log log = LogFactory.getLog(BaseController.class);
	
	/**
	 * Comprueba si en la sesión hay un usuario logueado
	 * @param request
	 * @return
	 */
	public Usuario comprobarUsuario(HttpServletRequest request){
		Usuario usuario = (Usuario) request.getSession().getAttribute(Constantes.USUARIO);
		return usuario;
	}
	
	/**
	 * 
	 * @param trueque
	 */
	public void getImagen(Trueque trueque){
		if(trueque.getImagen()!=null){
			trueque.setImagen64(Base64Utils.encodeToString(trueque.getImagen()));
		}
	}
	
	
	/**
	 * 
	 * @param listado
	 * @return
	 */
	public List<Trueque> getListadoTrueques (List<Trueque> listado){
		String descripcion = "";
		for (int i = 0; i<listado.size(); i++){
			Trueque trueque = listado.get(i);
			if(trueque.getDescripcion().length() > new Integer(Constantes.MAX_DESCRIPCION)){
				descripcion = trueque.getDescripcion().substring(0,new Integer(Constantes.MAX_DESCRIPCION)) + "...";
				trueque.setDescripcion(descripcion);
			}
			getImagen(trueque);
		}
		
		return listado;
	}
	
}