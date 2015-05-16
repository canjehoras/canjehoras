package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Foro;

public class ForoDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(ForoDAO.class);
	
	public List<Foro> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Foro.class);
	}

	public Foro findForoPorTrueque(Long idTrueque)throws Throwable {
		log.debug("findForoPorTrueque");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Foro.class);
			q.add(Restrictions.eq("trueque.id", idTrueque));
			return (Foro) q.uniqueResult();
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
}
