package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.ForoDAO;
import com.vcortes.canjehoras.model.Foro;

public class ForoBL {
	
	private ForoDAO foroDAO;

	public ForoDAO getForoDAO() {
		return foroDAO;
	}

	public void setForoDAO(ForoDAO foroDAO) {
		this.foroDAO = foroDAO;
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return foroDAO.saveOrUpdate(instance);
	}
	
	public Foro findForoPorTrueque(Long idTrueque)throws Throwable {
		return foroDAO.findForoPorTrueque(idTrueque);
	}
}
