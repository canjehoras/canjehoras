package com.vcortes.canjehoras.bl;

import com.vcortes.canjehoras.dao.UsuarioDAO;
import com.vcortes.canjehoras.model.Provincia;

public class UsuarioBL {
	
	private UsuarioDAO usuarioDAO;

	
	public Provincia findUsuarioByLogin(String login) throws Exception {
		return usuarioDAO.findUsuarioByLogin(login);
	}
	
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	

}
