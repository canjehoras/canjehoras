package com.vcortes.canjehoras.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.CategoriaBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;


public class TruequeController extends BaseController{
	
	public static final Log log = LogFactory.getLog(TruequeController.class);
	private UsuarioBL usuarioBL;
	private CategoriaBL categoriaBL;
	private TruequeBL truequeBL;

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public void setCategoriaBL(CategoriaBL categoriaBL) {
		this.categoriaBL = categoriaBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

	/**
	
	 */
	public ModelAndView nuevo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(Constantes.NUEVO_TRUEQUE); 
		try{
			List<Categoria> categorias = categoriaBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			model.addObject( Constantes.CATEGORIAS, categorias);
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		}
		return model;
	}
	
	public ModelAndView publicar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Publicar nuevo trueque");
		
		try {
			
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
			String titulo = (String) request.getParameter(Constantes.TITULO);
			String descripcion = (String) request.getParameter(Constantes.DESCRIPCION);
			String tipo = (String) request.getParameter(Constantes.TIPO);
			String categoria = (String) request.getParameter(Constantes.CATEGORIA);
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			//Blob imagen = (Blob) request.getParameter(Constantes.IMAGEN);
			
			Trueque trueque = new Trueque();
			trueque.setTitulo(titulo);
			trueque.setFecha_alta(sdf.parse(sdf.format(new Date())));
			trueque.setEstado(Constantes.TRUEQUE_ESTADO_NUEVO);
			trueque.setDescripcion(descripcion);
			trueque.setTipo(tipo);
			trueque.setCategoria((Categoria) categoriaBL.findById(new Categoria(), categoria));
			//trueque.setImagen(imagen);
			trueque.setUsuario(usuario);
			
			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
		} catch (Exception e) {
			logger.error("Error registrando trueque", e);
		}
		return new ModelAndView(Constantes.LISTA_TRUEQUE);
	}
	
	public ModelAndView listado(HttpServletRequest request, HttpServletResponse response){
		log.debug("Listado de trueque");	
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE); 
		try{
			List<Trueque> listado = truequeBL.findAll(new Trueque());
			model.addObject( Constantes.TRUEQUES, listado);
			
			
		} catch (Exception e) {
			logger.error("Error registrando trueque", e);
		}
		return model;
	}
	
	public ModelAndView editar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Editar trueque");
		
		try {
			String id = request.getParameter("id");
			
//			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
//			String titulo = (String) request.getParameter(Constantes.TITULO);
//			String descripcion = (String) request.getParameter(Constantes.DESCRIPCION);
//			String tipo = (String) request.getParameter(Constantes.TIPO);
//			String categoria = (String) request.getParameter(Constantes.CATEGORIA);
//			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
//			//Blob imagen = (Blob) request.getParameter(Constantes.IMAGEN);
//			
//			Trueque trueque = new Trueque();
//			trueque.setTitulo(titulo);
//			trueque.setFecha_alta(sdf.parse(sdf.format(new Date())));
//			trueque.setEstado(Constantes.TRUEQUE_ESTADO_NUEVO);
//			trueque.setDescripcion(descripcion);
//			trueque.setTipo(tipo);
//			trueque.setCategoria((Categoria) categoriaBL.findById(new Categoria(), categoria));
//			//trueque.setImagen(imagen);
//			trueque.setUsuario(usuario);
//			
//			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
		} catch (Exception e) {
			logger.error("Error editando trueque", e);
		}
		return new ModelAndView(Constantes.EDITAR_TRUEQUE);
	}
}
