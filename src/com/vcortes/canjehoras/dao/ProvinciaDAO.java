package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vcortes.canjehoras.model.Provincia;


public class ProvinciaDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(ProvinciaDAO.class);
	
	public List<Provincia> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Provincia.class);
	}
	
}
