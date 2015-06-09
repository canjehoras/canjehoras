package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Usuario;
import com.vcortes.canjehoras.utils.Constantes;


public class UsuarioDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(UsuarioDAO.class);

	/**
	 * Recupera los datos del Usuario por el nombre de usuario
	 * 
	 * @param login
	 * @return Usuario
	 * @throws Exception
	 */
	public Usuario findUsuarioByLogin(String login) throws Exception {
		log.info("findUsuarioByLogin");		
		Criteria q = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		q.add(Restrictions.eq(Constantes.CORREO_ELECTRONICO, login));
		List result = q.list();
		return (Usuario) first(result);
	}
	
	public Usuario findUsuarioById(Long id_usuario) throws Exception {
		log.info("findUsuarioById");		
		Criteria q = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		q.add(Restrictions.eq("id", id_usuario));
		List result = q.list();
		return (Usuario) first(result);
	}

}
