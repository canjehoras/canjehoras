package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.Collection;

import com.vcortes.canjehoras.dao.UsuarioDAO;
import com.vcortes.canjehoras.model.Usuario;

public class UsuarioBL {
	
	private UsuarioDAO usuarioDAO;

	/**
	 * Recupera los datos del Usuario por el nombre de usuario
	 * 
	 * @param login
	 * @return Usuario
	 * @throws Exception
	 */
	public Usuario findUsuarioByLogin(String login) throws Exception {
		return usuarioDAO.findUsuarioByLogin(login);
	}
	
	public Usuario findUsuarioById(Long id_usuario) throws Exception {
		return usuarioDAO.findUsuarioById(id_usuario);
	}
	
	public Object saveOrUpdate(Object instance) throws Exception{
		return usuarioDAO.saveOrUpdate(instance);
	}
	
	public void deleteAll(Collection list) throws Exception {
		usuarioDAO.deleteAll(list);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return usuarioDAO.findById(instance, id);
	}
	
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
/**	public Usuario findProvincia(Long id_usuario) throws Throwable {
		return usuarioDAO.findProvincia(id_usuario);
	}*/

}
