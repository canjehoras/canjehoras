package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vcortes.canjehoras.model.Canje;

public class CanjeDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(CanjeDAO.class);
	
	public List<Canje> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Canje.class);
	}

}
