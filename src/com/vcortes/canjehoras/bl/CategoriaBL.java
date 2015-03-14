package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.CategoriaDAO;


public class CategoriaBL {
	
	private CategoriaDAO categoriaDAO;

	
/**	public List<Categoria> findAll(Object instance) throws Exception {
		return categoriaDAO.findAll(instance);
	}*/


	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}


	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
