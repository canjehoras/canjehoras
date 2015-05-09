package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.PrefCategoria;

public class PrefCategoriaDAO extends BaseDAO {
	private static final Log log = LogFactory.getLog(PrefCategoriaDAO.class);
	
	public List<PrefCategoria> findByUsuario(Long id_usuario) throws Throwable {
		log.debug("findByUsuario");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(PrefCategoria.class);
			q.add(Restrictions.eq("usuario.id", id_usuario));
			q.addOrder(Order.desc("id"));
			return q.list();
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
	public List<PrefCategoria> findPreferenciaCategoria(Long categoria) throws Throwable {
		log.debug("findPreferenciaCategoria");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(PrefCategoria.class);
			q.add(Restrictions.eq("categoria.id", categoria));
			q.addOrder(Order.desc("id"));
			return q.list();
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
}
