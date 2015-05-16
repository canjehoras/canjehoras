package com.vcortes.canjehoras.bl;

import java.util.List;

import com.vcortes.canjehoras.dao.PublicacionDAO;
import com.vcortes.canjehoras.model.Publicacion;

public class PublicacionBL {
	
	private PublicacionDAO publicacionDAO;

	public PublicacionDAO getPublicacionDAO() {
		return publicacionDAO;
	}

	public void setPublicacionDAO(PublicacionDAO publicacionDAO) {
		this.publicacionDAO = publicacionDAO;
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return publicacionDAO.saveOrUpdate(instance);
	}
	
	public List <Publicacion> findPublicacionPorForo(Long idForo)throws Throwable {
		return publicacionDAO.findPublicacionPorForo(idForo);
	}
}
