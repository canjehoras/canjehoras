package com.vcortes.canjehoras.controller;

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
			List<Canje> canjeReservado = canjeBL.listadoCanjes(idAgenda, Constantes.ESTADO_CANJE_OCUPADO);
			model.addObject("listadoCanjesLibres", canjeLibres);
			model.addObject("listadoCanjesReservado", canjeReservado);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
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
