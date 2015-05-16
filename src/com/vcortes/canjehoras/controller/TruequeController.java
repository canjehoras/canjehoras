package com.vcortes.canjehoras.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.vcortes.canjehoras.bl.AgendaBL;
import com.vcortes.canjehoras.bl.BuscadorBL;
import com.vcortes.canjehoras.bl.CanjeBL;
import com.vcortes.canjehoras.bl.PrefCategoriaBL;
import com.vcortes.canjehoras.bl.PrefProvinciaBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Agenda;
import com.vcortes.canjehoras.model.Canje;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.PrefCategoria;
import com.vcortes.canjehoras.model.PrefProvincia;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.Mail;

public class TruequeController extends BaseController{
	
	public static final Log log = LogFactory.getLog(TruequeController.class);
	private UsuarioBL usuarioBL;
	private BuscadorBL buscadorBL;
	private TruequeBL truequeBL;
	private PrefCategoriaBL prefCategoriaBL;
	private PrefProvinciaBL prefProvinciaBL;
	private AgendaBL agendaBL;
	private CanjeBL canjeBL;

	public void setCanjeBL(CanjeBL canjeBL) {
		this.canjeBL = canjeBL;
	}

	public void setAgendaBL(AgendaBL agendaBL) {
		this.agendaBL = agendaBL;
	}

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public void setBuscadorBL(BuscadorBL buscadorBL) {
		this.buscadorBL = buscadorBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
	
	public void setPrefCategoriaBL(PrefCategoriaBL prefCategoriaBL) {
		this.prefCategoriaBL = prefCategoriaBL;
	}

	public void setPrefProvinciaBL(PrefProvinciaBL prefProvinciaBL) {
		this.prefProvinciaBL = prefProvinciaBL;
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
			
			List<String> listadoHoras = new ArrayList<String>();
			for (int i= 0; i <24; i++){     
				listadoHoras.add("" + i +":00"); 
			}
			model.addObject("listadoHoras", listadoHoras);
			
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
			String descripcionOferta = "";
			String descripcionDemanda = "";
			String categoria = "";
			//String tipo = "";
			String id = "";
			String provincia = "";
			String modalidad = "";
			String fecha = "";
			String hora_inicio = "";
			String hora_fin = "";
			Trueque trueque = new Trueque();
			InputStream fileContent = null;
		    for (FileItem item : items) {
		    	if (item.isFormField()) {
		    		String fieldName = item.getFieldName();
		            String fieldValue = item.getString();
		            
		            if(Constantes.ID.equals(fieldName)){
		            	id = fieldValue;
		            } else if(Constantes.TITULO.equals(fieldName)){
		            	titulo = fieldValue;
		            } else if(Constantes.CATEGORIAS.equals(fieldName)){
		            	categoria = fieldValue;
		            } else if(Constantes.PROVINCIAS.equals(fieldName)){
		            	provincia = fieldValue;
		            } else if(Constantes.MODALIDAD.equals(fieldName)){
		            	modalidad = fieldValue;
		            } else if(Constantes.DESCRIPCION_OFERTA.equals(fieldName)){
		            	descripcionOferta = fieldValue;
		            } else if(Constantes.DESCRIPCION_DEMANDA.equals(fieldName)){
		            	descripcionDemanda = fieldValue;
		            } else if(Constantes.FECHA.equals(fieldName)){
		            	fecha = fieldValue;
		            } else if(Constantes.HORA_INICIO.equals(fieldName)){
		            	hora_inicio = fieldValue;
		            } else if(Constantes.HORA_FIN.equals(fieldName)){
		            	hora_fin = fieldValue;
		            }
		    	} else {
		    		String fieldName = item.getFieldName();
		            String fileName = item.getName();
		            fileContent = item.getInputStream();
		    	}
		    }
			
		    // Si ya existe en bbdd - Edición
		    if(id!=null && !("").equals(id)){
		    	trueque = (Trueque) truequeBL.findById(new Trueque(), Long.valueOf(id));
		    }

		    // Guardar los datos del trueque
		    trueque.setTitulo(titulo);
		    trueque.setCategoria((Categoria) buscadorBL.findById(new Categoria(), Long.valueOf(categoria)));
		    trueque.setProvincia((Provincia) buscadorBL.findById(new Provincia(), Long.valueOf(provincia)));
		    //trueque.setTipo(tipo);
		    trueque.setModalidad(modalidad);
		    trueque.setDescripcionOferta(descripcionOferta);
		    trueque.setDescripcionDemanda(descripcionDemanda);
		    trueque.setImagen(IOUtils.toByteArray(fileContent));		    
			trueque.setFecha_alta(sdf.parse(sdf.format(new Date())));
			trueque.setEstado(Constantes.TRUEQUE_ESTADO_NUEVO);
			trueque.setUsuario(usuario);
			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
			// Guardar los datos de la agenda
			Agenda agenda = agendaBL.findAgendaPorUsuario(usuario.getId());
		    if(agenda==null){
		    	agenda = new Agenda();
		    	agenda.setUsuario(usuario);
		    	agenda = (Agenda) agendaBL.saveOrUpdate(agenda);
		    }
			Canje canje = new Canje();
			if(!"".equals(fecha)){
				canje.setFecha(sdf.parse(fecha));
				canje.setHora_fin(hora_fin);
				canje.setHora_inicio(hora_inicio);
				canje.setEstado(Constantes.ESTADO_CANJE_LIBRE);
				canje.setAgenda(agenda);
				canje.setTrueque(trueque);
				canjeBL.saveOrUpdate(canje);
			}
			
			// Se buscan los usuarios que corresponden con las preferencias
			List <String> listadoEmail = new ArrayList<String>();
			List <PrefCategoria> listadoCategoria = prefCategoriaBL.findPreferenciaCategoria(trueque.getCategoria().getId());
			for(PrefCategoria listado: listadoCategoria){
				listadoEmail.add(listado.getUsuario().getCorreo_electronico());
			}
			List <PrefProvincia> listadoProvincia = prefProvinciaBL.findPreferenciaProvincia(trueque.getProvincia().getId());
			for(PrefProvincia listado: listadoProvincia){
				listadoEmail.add(listado.getUsuario().getCorreo_electronico());
			}
			
			// Envio de email por cada uno de los usuarios
			for(String email: listadoEmail){
				Mail mail = new Mail();
				String cuerpo = "<img src=\"https://ci5.googleusercontent.com/proxy/z7RMBizZYcW1ApMmTWW8xagRvYg2Pn4xeo17wINvNSD6wKgZ_MF20qcxm-PUsF9XlDJkZMUGLR_LA2WdoUpzsF0jhlIQA6hFU3tygljGZv_7bIsV1A=s0-d-e1-ft#http://img407.imageshack.us/img407/1795/headerbtburgosemail.png\" class=\"CToWUd\">" + 
						"<h2>Hola, " + usuario.getNombre() + "</h2>" + 
						"<h2>Te enviamos información de un nuevo Trueque publicado en la web conforme tus preferencias." + 
						"Desde el equipo de canjehoras te animamos a que publiques tus ofertas y demandas." + 
						"Puedes hacerlo desde la propia Web, iniciando sesión con tu E-mail y tu contraseña.</h2></br></br>" + 
						"<h3>" + trueque.getTitulo() + "</h3>" +
						"<h3>" + trueque.getCategoria().getDescripcion() + "</h3>" + 
						"<h3>" + trueque.getProvincia().getDescripcion() + "</h3>" + 
						"<h3>" + "OFERTA: " + descripcionOferta + "</h3>" +
						"<h3>" + "DEMANDA: " + descripcionDemanda + "</h3>" +
						"<h4>Publicado por: " + trueque.getUsuario().getCorreo_electronico() + "</h4>"; 
				mail.enviarMail(email, null, null, Constantes.EMAIL_ASUNTO, cuerpo, null, null);
				log.debug("Envio email a " + email);
			}
			
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
			List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView preferencias(HttpServletRequest request, HttpServletResponse response){
		log.debug("Listado de trueque por preferencias");	
		/**Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}*/
		
		ArrayList<Long> listadoProvincia = (ArrayList<Long>)request.getSession().getAttribute("listadoProvincia");
		ArrayList<Long> listadoCategoria = (ArrayList<Long>)request.getSession().getAttribute("listadoCategoria");
		
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE); 
		try{
			List<Trueque> listado = truequeBL.findTruequePreferencias(listadoProvincia, listadoCategoria, Constantes.TRUEQUE_ESTADO_NUEVO);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView mistrueques(HttpServletRequest request, HttpServletResponse response){
		log.debug("Listado de mis trueque");	
		Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}
		ModelAndView model = new ModelAndView(Constantes.MI_LISTA_TRUEQUE); 
		try{
			List<Trueque> listado = truequeBL.findTrueque(null, null, idUsuario, null);
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
			if(null != trueque){				
				/**if(trueque.getTipo().equals(Constantes.TIPO_OFERTA)){
					trueque.setTipo(Constantes.TIPO_OFERTA_DESC);
				}
				if(trueque.getTipo().equals(Constantes.TIPO_DEMANDA)){
					trueque.setTipo(Constantes.TIPO_DEMANDA_DESC);
				}*/
				if(trueque.getModalidad().equals(Constantes.TIPO_COMPARTIR_HORAS)){
					trueque.setModalidad(Constantes.TIPO_COMPARTIR_HORAS_DESC);
				}
				if(trueque.getModalidad().equals(Constantes.TIPO_INTERCAMBIAR_HORAS)){
					trueque.setModalidad(Constantes.TIPO_INTERCAMBIAR_HORAS_DESC);
				}
				getImagen(trueque);
			}
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
	
	public ModelAndView denunciado(HttpServletRequest request, HttpServletResponse response){
		log.debug("Denunciar trueque");	
		ModelAndView model = new ModelAndView(Constantes.DETALLE_TRUEQUE); 
		Long idUsuario = null;
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		if(null !=usuario){
			idUsuario = usuario.getId();
		}
		try{
			String id = (String) request.getParameter(Constantes.ID);
			Trueque trueque = truequeBL.detalle(Long.valueOf(id));
			// Modificar el estado
			trueque.setEstado(Constantes.TRUEQUE_ESTADO_DENUNCIADO);
			trueque.setDenunciante(usuario);
			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
			if(null != trueque){				
				if(trueque.getModalidad().equals(Constantes.TIPO_COMPARTIR_HORAS)){
					trueque.setModalidad(Constantes.TIPO_COMPARTIR_HORAS_DESC);
				}
				if(trueque.getModalidad().equals(Constantes.TIPO_INTERCAMBIAR_HORAS)){
					trueque.setModalidad(Constantes.TIPO_INTERCAMBIAR_HORAS_DESC);
				}
				getImagen(trueque);			
			}
			model.addObject( Constantes.TRUEQUE, trueque);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView borrar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Borrar trueque");	
		ModelAndView model = new ModelAndView(Constantes.MI_LISTA_TRUEQUE); 
		try{
			String id = (String) request.getParameter(Constantes.ID);
			Trueque trueque = truequeBL.detalle(Long.valueOf(id));
			// Modificar el estado
			trueque.setEstado(Constantes.TRUEQUE_ESTADO_BORRADO);
			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
			Long idUsuario = null;
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(null !=usuario){
				idUsuario = usuario.getId();
			}
			List<Trueque> listado = truequeBL.findTrueque(null, null, idUsuario, null);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;			
	}
	
	public ModelAndView reactivar(HttpServletRequest request, HttpServletResponse response){
		log.debug("Borrar trueque");	
		ModelAndView model = new ModelAndView(Constantes.MI_LISTA_TRUEQUE); 
		try{
			String id = (String) request.getParameter(Constantes.ID);
			Trueque trueque = truequeBL.detalle(Long.valueOf(id));
			// Modificar el estado
			trueque.setEstado(Constantes.TRUEQUE_ESTADO_NUEVO);
			trueque = (Trueque) truequeBL.saveOrUpdate(trueque);
			
			Long idUsuario = null;
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(null !=usuario){
				idUsuario = usuario.getId();
			}
			List<Trueque> listado = truequeBL.findTrueque(null, null, idUsuario, null);
			getListadoTrueques(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;			
	}
	
	/**
	 * Se muestra la pantalla con las opciones que tiene el usuario de poder canjear el trueque
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView opcionesCanjeo(HttpServletRequest request, HttpServletResponse response){
		log.debug("Opciones canjeo de trueque");	
		ModelAndView model = new ModelAndView(Constantes.OPCIONES_CANJEO_TRUEQUE); 
		try{
			String id = (String) request.getParameter(Constantes.ID);
			Trueque trueque = truequeBL.detalle(Long.valueOf(id));
			model.addObject( Constantes.TRUEQUE, trueque);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView gestionDenunciados(HttpServletRequest request, HttpServletResponse response){
		log.debug("Gestión de trueque");	
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE_DENUNCIADOS); 
		try{
			List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_DENUNCIADO);
			getListadoTruequesTotal(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	public ModelAndView gestionActivos(HttpServletRequest request, HttpServletResponse response){
		log.debug("Gestión de trueque");	
		ModelAndView model = new ModelAndView(Constantes.LISTA_TRUEQUE_ACTIVOS); 
		try{
			List<Trueque> listado = truequeBL.findTrueque(null, null, null, Constantes.TRUEQUE_ESTADO_NUEVO);
			getListadoTruequesTotal(listado);
			model.addObject(Constantes.TRUEQUES, listado);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
}
