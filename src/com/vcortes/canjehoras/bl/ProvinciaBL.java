package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.List;

import com.vcortes.canjehoras.dao.ProvinciaDAO;
import com.vcortes.canjehoras.model.Provincia;


public class ProvinciaBL {
	
	private ProvinciaDAO ProvinciaDAO;

	
	public List<Provincia> findAll(Object instance) throws Exception {
		return ProvinciaDAO.findAll(instance);
	}

	public List<Provincia> findAll(Object instance, String orderBy) throws Exception {
		return ProvinciaDAO.findAll(instance, orderBy);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return ProvinciaDAO.findById(instance, id);
	}

	public ProvinciaDAO getProvinciaDAO() {
		return ProvinciaDAO;
	}

	public void setProvinciaDAO(ProvinciaDAO ProvinciaDAO) {
		this.ProvinciaDAO = ProvinciaDAO;
	}

}
