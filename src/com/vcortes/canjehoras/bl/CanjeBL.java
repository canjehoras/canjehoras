package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.Date;
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
	
	public List<Canje> listadoCanjesPorAgenda(Long idAgenda, String estado, Long idUsuario)throws Throwable {
		return canjeDAO.listadoCanjesPorAgenda(idAgenda, estado, idUsuario);
	}
	
	public List<Canje> listadoCanjesUsuarioDemanda (Long idUsuario)throws Throwable {
		return canjeDAO.listadoCanjesUsuarioDemanda(idUsuario);
	}
	
	public List<Canje> listadoCanjesFecha(Date date)throws Throwable {
		return canjeDAO.listadoCanjesFecha(date);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return canjeDAO.findById(instance, id);
	}
	
	public Canje detalle(Long id) throws Throwable {
		return canjeDAO.detalle(id);
	}
	
	public List<Canje> findCanjesPorTrueque(Long idTrueque)throws Throwable {
		return canjeDAO.findCanjesPorTrueque(idTrueque);
	}
}
