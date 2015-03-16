package com.vcortes.canjehoras.bl;

import java.util.List;

import com.vcortes.canjehoras.dao.TruequeDAO;
import com.vcortes.canjehoras.model.Trueque;


public class TruequeBL {
	
	private TruequeDAO truequeDAO;

	
	public List<Trueque> findAll(Object instance) throws Exception {
		return truequeDAO.findAll(instance);
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return truequeDAO.saveOrUpdate(instance);
	}

	public TruequeDAO getTruequeDAO() {
		return truequeDAO;
	}


	public void setTruequeDAO(TruequeDAO truequeDAO) {
		this.truequeDAO = truequeDAO;
	}

}
