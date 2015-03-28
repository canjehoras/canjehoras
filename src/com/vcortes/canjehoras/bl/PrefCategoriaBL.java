package com.vcortes.canjehoras.bl;

import java.util.List;

import com.vcortes.canjehoras.dao.PrefCategoriaDAO;
import com.vcortes.canjehoras.model.PrefCategoria;


public class PrefCategoriaBL {
	
	private PrefCategoriaDAO prefCategoriaDAO;

	public PrefCategoriaDAO getPrefCategoriaDAO() {
		return prefCategoriaDAO;
	}

	public void setPrefCategoriaDAO(PrefCategoriaDAO prefCategoriaDAO) {
		this.prefCategoriaDAO = prefCategoriaDAO;
	}

	public List<PrefCategoria> findByUsuario(Long id_usuario) throws Throwable {
		return prefCategoriaDAO.findByUsuario(id_usuario);
	}

	public Object saveOrUpdate(Object instance) throws Exception{
		return prefCategoriaDAO.saveOrUpdate(instance);
	}
}
