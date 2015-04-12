package com.vcortes.canjehoras.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.BuscadorBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;

public class TruequeController extends BaseController{
	
	public static final Log log = LogFactory.getLog(TruequeController.class);
	private UsuarioBL usuarioBL;
	private BuscadorBL buscadorBL;
	private TruequeBL truequeBL;

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public void setBuscadorBL(BuscadorBL buscadorBL) {
		this.buscadorBL = buscadorBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

	/**
	
	 */
	public ModelAndView nuevo(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(Constantes.NUEVO_TRUEQUE); 
		try{
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			model.addObject( Constantes.CATEGORIAS, categorias);

			List<Categoria> provincias = buscadorBL.findAll(new Provincia(), Constantes.DESCRIPCION);
			model.addObject(Constantes.PROVINCIAS, provincias);
		} catch(Exception e){
			logger.error("Error al obtener los listados de la pantalla de login",e);
		}
		return model;
	}
	
	public ModelAndView publicar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Publicar nuevo trueque");
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE); 
		
		try {
			
			request.setCharacterEncoding("UTF-8");
			
			SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			String titulo = "";
			String descripcion = "";
			String categoria = "";
			String tipo = "";
			String id = "";
			String provincia = "";
			Trueque trueque = new Trueque();
			InputStream fileContent = null;
		    for (FileItem item : items) {
		    	if (item.isFormField()) {
		    		String fieldName = item.getFieldName();
		            String fieldValue = item.getString();
		            
		            if(Constantes.TITULO.equals(fieldName)){
		            	titulo = fieldValue;
		            } else if(Constantes.ID.equals(fieldName)){
		            	id = fieldValue;
		            } else if(Constantes.DESCRIPCION.equals(fieldName)){
		            	descripcion = fieldValue;
		            } else if(Constantes.TIPO.equals(fieldName)){
		            	tipo = fieldValue;
		            } else if(Constantes.CATEGORIAS.equals(fieldName)){
		            	categoria = fieldValue;
		            } else if(Constantes.PROVINCIAS.equals(fieldName)){
		            	provincia = fieldValue;
		            }
		                
		    	} else {
		    		String fieldName = item.getFieldName();
		            String fileName = item.getName();
		            fileContent = item.getInputStream();
		    	}
		    }
			
		    if(id!=null && !("").equals(id)){
		    	trueque = (Trueque) truequeBL.findById(new Trueque(), Long.valueOf(id));
		    }
		    
		    trueque.setTitulo(titulo);
		    trueque.setDescripcion(descripcion);
		    trueque.setTipo(tipo);
		    trueque.setCategoria((Categoria) buscadorBL.findById(new Categoria(), Long.valueOf(categoria)));
		    trueque.setProvincia((Provincia) buscadorBL.findById(new Provincia(), Long.valueOf(provincia)));
			trueque.setFecha_alta(sdf.parse(sdf.format(new Date())));
			trueque.setEstado(Constantes.TRUEQUE_ESTADO_NUEVO);
			trueque.setImagen(IOUtils.toByteArray(fileContent));
			trueque.setUsuario(usuario);
			
			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
		} catch (Exception e) {
			logger.error("Error registrando trueque", e);
		} catch (Throwable e) {
			logger.error("Error registrando trueque", e);
		}
		
		return listado(request, response);
	}
	
	public ModelAndView listado(HttpServletRequest request, HttpServletResponse response){
		log.debug("Listado de trueque");	
		Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE); 
		try{
			List<Trueque> listado = truequeBL.findTrueque(null, null,null);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	public ModelAndView detalle(HttpServletRequest request, HttpServletResponse response){
		log.debug("Detalle de trueque");	
		ModelAndView model = new ModelAndView(Constantes.DETALLE_TRUEQUE); 
		try{
			String id = (String) request.getParameter(Constantes.ID);
			Trueque trueque = truequeBL.detalle(Long.valueOf(id));
			getImagen(trueque);
			model.addObject( Constantes.TRUEQUE, trueque);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	
	public ModelAndView editar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Editar trueque");
		ModelAndView model = new ModelAndView(Constantes.NUEVO_TRUEQUE);
		
		try {
			String id = request.getParameter("id");			
			Trueque trueque = (Trueque) truequeBL.findById(new Trueque(), Long.valueOf(id));
			model.addObject("trueque", trueque);
			
			List<Categoria> categorias = buscadorBL.findAll(new Categoria(), Constantes.DESCRIPCION);
			model.addObject( Constantes.CATEGORIAS, categorias);
			
			List<Categoria> provincias = buscadorBL.findAll(new Provincia(), Constantes.DESCRIPCION);
			model.addObject(Constantes.PROVINCIAS, provincias);
			
		} catch (Exception e) {
			logger.error("Error editando trueque", e);
		}
		return model;
	}
	
	
}
