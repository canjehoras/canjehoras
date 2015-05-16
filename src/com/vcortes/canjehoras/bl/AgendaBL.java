package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.AgendaDAO;
import com.vcortes.canjehoras.model.Agenda;

public class AgendaBL {
	
	private AgendaDAO agendaDAO;

	public AgendaDAO getAgendaDAO() {
		return agendaDAO;
	}

	public void setAgendaDAO(AgendaDAO agendaDAO) {
		this.agendaDAO = agendaDAO;
	}
	
	public Object saveOrUpdate(Object instance) throws Exception{
		return agendaDAO.saveOrUpdate(instance);
	}

	public Agenda findAgendaPorUsuario(Long idUsuario)throws Throwable {
		return agendaDAO.findAgendaPorUsuario(idUsuario);
	}
}
