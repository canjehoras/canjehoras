package com.vcortes.canjehoras.bl;

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
	
	public List<Canje> listadoCanjesLibres(Long idUsuario)throws Throwable {
		return canjeDAO.listadoCanjesLibres(idUsuario);
	}
}
