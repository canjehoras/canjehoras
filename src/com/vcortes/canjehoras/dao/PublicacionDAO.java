package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Publicacion;

public class PublicacionDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(PublicacionDAO.class);
	
	public List<Publicacion> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Publicacion.class);
	}

	public List<Publicacion>  findPublicacionPorForo(Long idForo)throws Throwable {
		log.debug("findPublicacionPorForo");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Publicacion.class);
			if(null != idForo){
				q.add(Restrictions.eq("foro.id", idForo));
			}	
			q.addOrder(Order.asc("fecha"));
			List result = q.list();
			return result;
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
}
