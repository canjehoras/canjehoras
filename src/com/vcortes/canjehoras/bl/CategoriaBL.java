package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.List;

import com.vcortes.canjehoras.dao.CategoriaDAO;
import com.vcortes.canjehoras.model.Categoria;


public class CategoriaBL {
	
	private CategoriaDAO categoriaDAO;

	
	public List<Categoria> findAll(Object instance) throws Exception {
		return categoriaDAO.findAll(instance);
	}

	public List<Categoria> findAll(Object instance, String orderBy) throws Exception {
		return categoriaDAO.findAll(instance, orderBy);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return categoriaDAO.findById(instance, id);
	}

	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}


	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
