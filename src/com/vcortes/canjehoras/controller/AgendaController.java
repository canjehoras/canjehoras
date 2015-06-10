package com.vcortes.canjehoras.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import com.vcortes.canjehoras.bl.AgendaBL;
import com.vcortes.canjehoras.bl.CanjeBL;
import com.vcortes.canjehoras.bl.TruequeBL;
import com.vcortes.canjehoras.bl.UsuarioBL;
import com.vcortes.canjehoras.model.Agenda;
import com.vcortes.canjehoras.model.Canje;
import com.vcortes.canjehoras.model.Trueque;
import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;
import com.vcortes.canjehoras.utils.Mail;

/**
 * Lógica de negocio de la Clase Agenda
 * 
 * @author Vanesa Cortés
 *
 */
public class AgendaController extends BaseController {
	
	public static final Log log = LogFactory.getLog(AgendaController.class);
	
	/** Declaración de los BL necesarios */
	private UsuarioBL usuarioBL;
	private TruequeBL truequeBL;
	private CanjeBL canjeBL;
	private AgendaBL agendaBL;
	
	
	/** Getter y setter de los BL necesarios */
	public UsuarioBL getUsuarioBL() {
		return usuarioBL;
	}

	public void setUsuarioBL(UsuarioBL usuarioBL) {
		this.usuarioBL = usuarioBL;
	}

	public TruequeBL getTruequeBL() {
		return truequeBL;
	}

	public void setTruequeBL(TruequeBL truequeBL) {
		this.truequeBL = truequeBL;
	}

	public CanjeBL getCanjeBL() {
		return canjeBL;
	}

	public void setCanjeBL(CanjeBL canjeBL) {
		this.canjeBL = canjeBL;
	}

	public AgendaBL getAgendaBL() {
		return agendaBL;
	}

	public void setAgendaBL(AgendaBL agendaBL) {
		this.agendaBL = agendaBL;
	}

	
	/**
	 * Método que recupera la agenda completa del usuario registrado
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView muestra la agenda
	 */
	public ModelAndView agenda(HttpServletRequest request, HttpServletResponse response){
		log.debug("Recupera la agenda del usuario registrado");	
		ModelAndView model = new ModelAndView(Constantes.AGENDA); 
		Long idUsuario = null;
		Long idAgenda = null;
		List<Canje> todos = null;
		try {
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			if(null !=usuario){
				idUsuario = usuario.getId();
			}
			
			Agenda agenda = agendaBL.findAgendaPorUsuario(idUsuario);
			if(null !=agenda){
				idAgenda = agenda.getId();
			}
			todos = canjeBL.listadoCanjesPorAgenda(idAgenda, null, idUsuario);
			
			model.addObject("todos", todos);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * Buscar las fechas para el trueque
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView agendaTrueque(HttpServletRequest request, HttpServletResponse response){
		log.debug("agendaTrueque");	
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
	
	
	
	public ModelAndView detalleMiAgenda(HttpServletRequest request, HttpServletResponse response){
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
	
	public ModelAndView detalleAgendaCanjeo(HttpServletRequest request, HttpServletResponse response){
		log.debug("Entramos en el detalle de la agenda del usuario");	
		ModelAndView model = new ModelAndView(Constantes.AGENDA_DETALLE_RESERVA); 
		try {
			String idTrueque = request.getParameter("id");
			List<Canje> listadoFechasTrueques = canjeBL.findCanjesPorTrueque(new Long(idTrueque));
			model.addObject("listadoFechasTrueques", listadoFechasTrueques);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		return model;
	}
	

	/**
	 * Método que modifica el estado del trueque
	 * 
	 * LIBRE_RESERVADO: El trueque pasa del estado LIBRE a RESERVADO
	 * RESERVADO_CANJEADO: El trueque pasa del estado RESERVADO a CANJEADO
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView agenda
	 */
	public ModelAndView resolucionCanje (HttpServletRequest request, HttpServletResponse response){
		log.debug("resolucionCanje");
		SimpleDateFormat sdf = new SimpleDateFormat(Constantes.FORMATO_FECHA);
		try {
			// Usuario en sesion
			Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
			
			// Comprobar canje
			String id = request.getParameter("id");
			Canje canje = canjeBL.detalle(Long.valueOf(id));
			Trueque trueque = truequeBL.detalle(Long.valueOf(id));
			
			// Comprobar resolución
			String resolucion = request.getParameter("resolucion");
			String resolucionLabel = "";
			String asunto = "";

			// El trueque ha sido reservado por un usuario
			if(Constantes.RESOLUCION_LIBRE_RESERVADO.equals(resolucion)){
				trueque.setEstado(Constantes.ESTADO_CANJE_PENDIENTE);
				canje.setEstado(Constantes.ESTADO_CANJE_PENDIENTE);
				canje.setUsuario(usuario);
				resolucionLabel = Constantes.RESOLUCION_LIBRE_RESERVADO_LABEL; 
				asunto = Constantes.EMAIL_ASUNTO_RESERVA;
			// El trueque ha sido aceptado por el usuario propietario
			}else if(Constantes.RESOLUCION_RESERVADO_CANJEADO.equals(resolucion)){
				trueque.setEstado(Constantes.ESTADO_CANJE_CANJEADO);
				canje.setEstado(Constantes.ESTADO_CANJE_CANJEADO);
				resolucionLabel = Constantes.RESOLUCION_RESERVADO_CANJEADO_LABEL; 
				asunto = Constantes.EMAIL_ASUNTO_RESERVA;
			} 
			
			// Almacenar información del canje
			canjeBL.saveOrUpdate(canje);
			
			// Envio de email al usuario propietario del trueque
			Mail mail = new Mail();
			String cuerpo = Constantes.EMAIL_CABECERA_HOLA + canje.getAgenda().getUsuario().getNombre() + Constantes.EMAIL_CIERRE_H2 + 
					Constantes.EMAIL_INFORMA + usuario.getNombre() + usuario.getApellido1() + usuario.getApellido2() + 
					Constantes.EMAIL_HA + resolucionLabel  + Constantes.EMAIL_TRUEQUE + Constantes.COMILLAS + 
					canje.getTrueque().getTitulo() + Constantes.COMILLAS + Constantes.BR + Constantes.BR + Constantes.EMAIL_CIERRE_H2 + 
					Constantes.EMAIL_CANJEO_REALIZA + sdf.format(canje.getFecha()) + Constantes.EMAIL_DE + canje.getHora_inicio() +
					Constantes.EMAIL_A + canje.getHora_fin() + Constantes.EMAIL_CIERRE_H2 +  Constantes.EMAIL_SALUDO; 
			mail.enviarMail(canje.getAgenda().getUsuario().getCorreo_electronico(), Constantes.EMAIL_ADMINISTRADOR, null, asunto, cuerpo, null, null);
			log.debug("Envio email a " + canje.getAgenda().getUsuario().getCorreo_electronico());			

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return agenda(request, response);
	}

	
	/**
	 * Método que envia un email al usuario
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView 
	 */
	public ModelAndView contacto(HttpServletRequest request, HttpServletResponse response){
		log.debug("Contacto Usuario");
		ModelAndView model = new ModelAndView(Constantes.OPCIONES_CANJEO_TRUEQUE);
		// Usuario en sesion
		Usuario usuario = (Usuario)request.getSession().getAttribute(Constantes.USUARIO);
		
		try {
			request.setCharacterEncoding(Constantes.ENCODING);
			String email = request.getParameter("email");
			String mensaje = request.getParameter("mensaje");
			// Envio de email
			Mail mail = new Mail();
			String cuerpo = Constantes.EMAIL_CABECERA_HOLA + email + Constantes.EMAIL_CIERRE_H2 + 
							Constantes.EMAIL_APERTURA_H3 + Constantes.EMAIL_CIERRE_H3 +
							Constantes.EMAIL_USUARIO + usuario.getNombre() + " " + usuario.getApellido1() + " " + usuario.getApellido2() + " " +
							Constantes.EMAIL_MSM + Constantes.BR + mensaje + Constantes.BR + Constantes.EMAIL_SALUDO; 
			mail.enviarMail(email, Constantes.EMAIL_ADMINISTRADOR, null, Constantes.EMAIL_ASUNTO_CONSULTA, cuerpo, null, null);
			log.debug("Envio email a " + email);			
			
		} catch (Throwable e) {
			logger.error("Error registrando usuario", e);
			e.printStackTrace();
		}
		return model;
	}
	
	/**
	 * Método que muestra el formulario para enviar un email
	 * 
	 * @param request
	 * @param response
	 * @return ModelAndView formulario email
	 * @throws Throwable
	 */
	public ModelAndView contactoEmail(HttpServletRequest request, HttpServletResponse response) throws Throwable{
		ModelAndView model = new ModelAndView(Constantes.ENVIAR_EMAIL); 
		String email = request.getParameter("email");
		model.addObject("email", email);
		return model;
	}	

}
