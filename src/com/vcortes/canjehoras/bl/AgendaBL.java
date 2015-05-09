package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.AgendaDAO;

public class AgendaBL {
	
	private AgendaDAO agendaDAO;

	public AgendaDAO getAgendaDAO() {
		return agendaDAO;
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return agendaDAO.saveOrUpdate(instance);
	}
	
	public void setAgendaDAO(AgendaDAO agendaDAO) {
		this.agendaDAO = agendaDAO;
	}


}
