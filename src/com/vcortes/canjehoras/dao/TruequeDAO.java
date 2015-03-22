package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Trueque;


public class TruequeDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(TruequeDAO.class);
	
	public List<Trueque> findTrueque(Long idCategoria, Long idUsuario)throws Throwable {
		log.debug("findTrueque");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Trueque.class);
			q.add(Restrictions.eq("categoria.id", idCategoria));
			List result = q.list();
			return result;
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
}
