package com.vcortes.canjehoras.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Base64Utils;
import org.springframework.web.servlet.ModelAndView;
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
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
		try{
			for (int i = 0; i<listado.size(); i++){
				Trueque trueque = listado.get(i);
				if(trueque.getDescripcion().length() > new Integer(Constantes.MAX_DESCRIPCION)){
					descripcion = trueque.getDescripcion().substring(0,new Integer(Constantes.MAX_DESCRIPCION)) + "...";
					trueque.setDescripcion(descripcion);
				}
				if(trueque.getTipo().equals(Constantes.TIPO_OFERTA)){
					trueque.setTipo(Constantes.TIPO_OFERTA_DESC);
				}
				if(trueque.getTipo().equals(Constantes.TIPO_DEMANDA)){
					trueque.setTipo(Constantes.TIPO_DEMANDA_DESC);
				}
				if(trueque.getModalidad().equals(Constantes.TIPO_COMPARTIR_HORAS)){
					trueque.setModalidad(Constantes.TIPO_COMPARTIR_HORAS_DESC);
				}
				if(trueque.getModalidad().equals(Constantes.TIPO_INTERCAMBIAR_HORAS)){
					trueque.setModalidad(Constantes.TIPO_INTERCAMBIAR_HORAS_DESC);
				}
				if(null != trueque.getFecha_alta()){
					trueque.setFecha(sdf.format(trueque.getFecha_alta()));
				}
				getImagen(trueque);
			}
		} catch (Exception e) {
			
		}
		return listado;
	}
	
	
	public ModelAndView enviarRespuestaAJAX(HttpServletResponse response, String respuesta) throws Throwable {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter screenWriter = response.getWriter();
			screenWriter.write(respuesta);
		} catch (Exception e) {
			
		}
		return null;

	}

	
}