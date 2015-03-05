package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.UsuarioDAO;
import com.vcortes.canjehoras.model.Usuario;

public class UsuarioBL {
	
	private UsuarioDAO usuarioDAO;

	
	public Usuario findUsuarioByLogin(String login) throws Exception {
		return usuarioDAO.findUsuarioByLogin(login);
	}
	
	public Object saveOrUpdate(Object instance) throws Exception{
		return usuarioDAO.saveOrUpdate(instance);
	}
	
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	

}
