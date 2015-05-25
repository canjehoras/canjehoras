package com.vcortes.canjehoras.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.AgendaBL;
import com.vcortes.canjehoras.bl.CanjeBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Agenda;
import com.vcortes.canjehoras.model.Canje;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.Mail;

public class AgendaController extends BaseController {
	
	private UsuarioBL usuarioBL;
	private TruequeBL truequeBL;
	private CanjeBL canjeBL;
	private AgendaBL agendaBL;
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView agenda(HttpServletRequest request, HttpServletResponse response){
		log.debug("Entramos en la agenda del usuario");	
		ModelAndView model = new ModelAndView(Constantes.AGENDA); 
		Long idUsuario = null;
		Long idAgenda = null;
		try {
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(null !=usuario){
				idUsuario = usuario.getId();
			}
			Agenda agenda = agendaBL.findAgendaPorUsuario(idUsuario);
			if(null !=agenda){
				idAgenda = agenda.getId();
			}
			
			List<Canje> canjeLibres = canjeBL.listadoCanjes(idAgenda, Constantes.ESTADO_CANJE_LIBRE);
			List<Canje> canjeReservado = canjeBL.listadoCanjes(idAgenda, Constantes.ESTADO_CANJE_RESERVADO);
			model.addObject("listadoCanjesLibres", canjeLibres);
			model.addObject("listadoCanjesReservado", canjeReservado);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
	}
	
	public ModelAndView agendaTrueque(HttpServletRequest request, HttpServletResponse response){
		log.debug("Entramos en la agenda del usuario");	
		ModelAndView model = new ModelAndView("agendaTrueque"); 
		Long idUsuario = null;
		try {
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(null !=usuario){
				idUsuario = usuario.getId();
			}
			String idTrueque = request.getParameter("id");
			List<Canje> listadoFechasTrueques = canjeBL.findCanjesPorTrueque(new Long(idTrueque));
			model.addObject("listadoFechasTrueques", listadoFechasTrueques);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	public ModelAndView agendaDetalle(HttpServletRequest request, HttpServletResponse response){
		log.debug("Entramos en el detalle de la agenda del usuario");	
		ModelAndView model = new ModelAndView(Constantes.AGENDA_DETALLE); 
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
		try {
			String fecha = request.getParameter("fecha");
			List<Canje> canje = canjeBL.listadoCanjesFecha(sdf.parse(fecha));
			getListadoCanje(canje);
			model.addObject("canjes", canje);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return model;
	}

	/**
	 * ACEPTAR: Se cambia estado a CANJEADO y se manda un email al interesado
	 * CANCELAR: Se cambia el estado a LIBRE y se manda un email al interesado
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView resolucionCanje (HttpServletRequest request, HttpServletResponse response){
		log.debug("resolucionCanje");
		ModelAndView model = new ModelAndView(Constantes.AGENDA_DETALLE); 
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
		try {
			// Usuario que ha publicado el trueque
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			
			// Comprobar canje
			String id = request.getParameter("id");
			Canje canje = canjeBL.detalle(Long.valueOf(id));
			
			// Comprobar resolución
			String resolucion = request.getParameter("resolucion");
			String resolucionLabel = "";
			if(Constantes.RESOLUCION_OK.equals(resolucion)){
				resolucionLabel = Constantes.RESOLUCION_OK_LABEL;
				canje.setEstado(Constantes.ESTADO_CANJE_CANJEADO);
			}else if(Constantes.RESOLUCION_NOK.equals(resolucion)){
				resolucionLabel = Constantes.RESOLUCION_NOK_LABEL;
				canje.setEstado(Constantes.ESTADO_CANJE_LIBRE);
			}else if(Constantes.RESOLUCION_LIBRE_RESERVADO.equals(resolucion)){
				resolucionLabel = Constantes.RESOLUCION_LIBRE_RESERVADO_LABEL;
				canje.setEstado(Constantes.ESTADO_CANJE_RESERVADO);
			}
			
			// Almacenar información
			canjeBL.saveOrUpdate(canje);
			
			// Envio de email al usuario que ha reservado el trueque
			Mail mail = new Mail();
			String cuerpo = "<h2>Hola, " + canje.getUsuario().getNombre() + "</h2>" + 
					"<h2>Le informamos que " + usuario.getNombre() + " ha " + resolucionLabel  + " el canjeo del trueque " +
					canje.getTrueque().getTitulo() + ".</br></br></h2>" + 
					"<h2>El canjeo se realizara el día " + sdf.format(canje.getFecha()) + " de " + canje.getHora_inicio() +
					" a " + canje.getHora_fin() + ".</h2></br></br><h2>Un saludo.</h2>"; 
			mail.enviarMail(canje.getUsuario().getCorreo_electronico(), null, null, Constantes.EMAIL_ASUNTO_RESOLUCION, cuerpo, null, null);
			log.debug("Envio email a " + canje.getUsuario().getCorreo_electronico());			

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}

	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}


	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}


	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}


	public void setCanjeBL(CanjeBL canjeBL) {
		this.canjeBL = canjeBL;
	}


	public void setAgendaBL(AgendaBL agendaBL) {
		this.agendaBL = agendaBL;
	}

}
