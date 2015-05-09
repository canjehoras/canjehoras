package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.CanjeDAO;

public class CanjeBL {
	
	private CanjeDAO canjeDAO;

	public CanjeDAO getCanjeDAO() {
		return canjeDAO;
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return canjeDAO.saveOrUpdate(instance);
	}
	
	public void setCanjeDAO(CanjeDAO canjeDAO) {
		this.canjeDAO = canjeDAO;
	}

}
