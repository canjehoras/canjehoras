package com.vcortes.canjehoras.bl;

import java.util.List;

import com.vcortes.canjehoras.dao.PrefProvinciaDAO;
import com.vcortes.canjehoras.model.PrefProvincia;


public class PrefProvinciaBL {
	
	private PrefProvinciaDAO prefProvinciaDAO;

	public PrefProvinciaDAO getPrefProvinciaDAO() {
		return prefProvinciaDAO;
	}

	public void setPrefProvinciaDAO(PrefProvinciaDAO prefProvinciaDAO) {
		this.prefProvinciaDAO = prefProvinciaDAO;
	}

	public List<PrefProvincia> findByUsuario(Long id_usuario) throws Throwable {
		return prefProvinciaDAO.findByUsuario(id_usuario);
	}
	
	public List<PrefProvincia> findPreferenciaProvincia(Long provincia) throws Throwable {
		return prefProvinciaDAO.findPreferenciaProvincia(provincia);
	}
	
	public Object saveOrUpdate(Object instance) throws Exception{
		return prefProvinciaDAO.saveOrUpdate(instance);
	}
	
	public void delete(Object instance) throws Exception {
		prefProvinciaDAO.delete(instance);
	}
}
