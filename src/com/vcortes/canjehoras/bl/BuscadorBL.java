package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.List;

import com.vcortes.canjehoras.dao.BuscadorDAO;
import com.vcortes.canjehoras.model.Categoria;


public class BuscadorBL {
	
	private BuscadorDAO buscadorDAO;

	
	public List<Categoria> findAll(Object instance) throws Exception {
		return buscadorDAO.findAll(instance);
	}

	public List findAll(Object instance, String orderBy) throws Exception {
		return buscadorDAO.findAll(instance, orderBy);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return buscadorDAO.findById(instance, id);
	}

	public void setBuscadorDAO(BuscadorDAO buscadorDAO) {
		this.buscadorDAO = buscadorDAO;
	}


}
