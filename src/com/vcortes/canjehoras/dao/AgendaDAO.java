package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vcortes.canjehoras.model.Agenda;

public class AgendaDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(AgendaDAO.class);
	
	public List<Agenda> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Agenda.class);
	}

}
