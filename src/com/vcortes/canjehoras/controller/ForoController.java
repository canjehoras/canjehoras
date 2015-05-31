package com.vcortes.canjehoras.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.ForoBL;
import com.vcortes.canjehoras.bl.PublicacionBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Foro;
import com.vcortes.canjehoras.model.Publicacion;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;

public class ForoController extends BaseController{
	
	public static final Log log = LogFactory.getLog(ForoController.class);
	private UsuarioBL usuarioBL;
	private TruequeBL truequeBL;
	private ForoBL foroBL;
	private PublicacionBL publicacionBL;

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}
	
	public void setForoBL(ForoBL foroBL) {
		this.foroBL = foroBL;
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
	
	public ModelAndView verForos(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		ModelAndView model = new ModelAndView(Constantes.FOROS); 
		
		String idTrueque = request.getParameter("idTrueque");
		String i = request.getParameter("idTrueque");
		// Recuperamos los foros si los tubiese
		Foro foro = foroBL.findForoPorTrueque(new Long(idTrueque));
		List publicaciones = new ArrayList();
		if(foro!=null){
			model.addObject("idForo", foro.getId());
			publicaciones = publicacionBL.findPublicacionPorForo(foro.getId());
		}
		
		model.addObject("idTrueque", idTrueque);
		model.addObject("publicaciones", publicaciones);
		
		return model;
	}
	
	public ModelAndView nuevoComentario(HttpServletRequest request, HttpServletResponse response){
		ModelAndView model = new ModelAndView(Constantes.OPCIONES_CANJEO_TRUEQUE); 
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
		String idTrueque = request.getParameter("idTrueque");
		String idForoString = request.getParameter("idForo");
		Long idForo = null;
		Foro foro = new Foro();
		try{
			if(idForoString==null || "".equals(idForoString)){
				foro.setHora_creacion(sdf.format(Calendar.getInstance().getTime()));

				sdf = new SimpleDateFormat("dd/MM/yyy");
				foro.setFecha_creacion(sdf.parse(sdf.format(Calendar.getInstance().getTime())));
				
				Trueque trueque = truequeBL.detalle(Long.valueOf(idTrueque));
				foro.setTrueque(trueque);
				
				foro = (Foro) foroBL.saveOrUpdate(foro);
				idForo = foro.getId();
			} else {
				idForo = Long.valueOf(idForoString);
				foro = (Foro) truequeBL.findById(new Foro(), idForo);
			}
			
			Publicacion publicacion = new Publicacion();
			publicacion.setComentario(request.getParameter("comentario"));
			publicacion.setForo(foro);
			publicacion.setUsuario((Usuario) request.getSession().getAttribute("usuario"));
			sdf = new SimpleDateFormat("hh:mm");
			publicacion.setHora(sdf.format(Calendar.getInstance().getTime()));
			sdf = new SimpleDateFormat("dd/MM/yyy");
			publicacion.setFecha(sdf.parse(sdf.format(Calendar.getInstance().getTime())));
			foroBL.saveOrUpdate(publicacion);
			
			Trueque trueque = truequeBL.detalle(Long.valueOf(idTrueque));
			model.addObject(Constantes.TRUEQUE, trueque);
		}catch(Exception e){
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}

	public void setPublicacionBL(PublicacionBL publicacionBL) {
		this.publicacionBL = publicacionBL;
	}

	

}
