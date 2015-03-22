package com.vcortes.canjehoras.bl;

import java.io.InputStream;
import java.util.List;

import com.vcortes.canjehoras.dao.TruequeDAO;
import com.vcortes.canjehoras.model.Trueque;


public class TruequeBL {
	
	private TruequeDAO truequeDAO;

	
	public Object saveOrUpdate(Object instance) throws Exception{
		return truequeDAO.saveOrUpdate(instance);
	}
	
	public List findAll(Object instance) throws Exception{
		return truequeDAO.findAll(instance);
	}

	public Trueque saveTrueque(Trueque trueque,InputStream fichero)throws Throwable {
		return truequeDAO.saveTrueque(trueque, fichero);
	}
	
	public TruequeDAO getTruequeDAO() {
		return truequeDAO;
	}


	public void setTruequeDAO(TruequeDAO truequeDAO) {
		this.truequeDAO = truequeDAO;
	}
	
	public List<Trueque> findTrueque(Long idCategoria, Long idUsuario) throws Throwable {
		return truequeDAO.findTrueque(idCategoria, idUsuario);
	}

}
