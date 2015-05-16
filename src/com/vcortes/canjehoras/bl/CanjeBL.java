package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.List;

import com.vcortes.canjehoras.dao.CanjeDAO;
import com.vcortes.canjehoras.model.Canje;

public class CanjeBL {
	
	private CanjeDAO canjeDAO;

	public CanjeDAO getCanjeDAO() {
		return canjeDAO;
	}
	public void setCanjeDAO(CanjeDAO canjeDAO) {
		this.canjeDAO = canjeDAO;
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return canjeDAO.saveOrUpdate(instance);
	}
	
	public List<Canje> listadoCanjes(Long idAgenda, String estado)throws Throwable {
		return canjeDAO.listadoCanjes(idAgenda, estado);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return canjeDAO.findById(instance, id);
	}
}
