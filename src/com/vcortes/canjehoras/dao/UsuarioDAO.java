package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Usuario;


public class UsuarioDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(UsuarioDAO.class);

	public Usuario findUsuarioByLogin(String login) throws Exception {
		log.info("findUsuarioByLogin");		
		Criteria q = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		q.add(Restrictions.eq("correo_electronico", login));
		List result = q.list();
		
		return (Usuario) first(result);
	}

/**	public Usuario findProvincia(Long id_usuario)throws Throwable {
		log.debug("detalle");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
			q.add(Restrictions.eq("id", id_usuario));
			return (Usuario) q.uniqueResult();
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}*/

}
