package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Provincia;


public class ProvinciaDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(ProvinciaDAO.class);
	
	public List<Provincia> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Provincia.class);
	}
	
	/**
	 * 
	 * @param codigo
	 * @return
	 */
	public Provincia findProvinciaByCodigo(String codigo){
		log.debug("findProvinciaByCodigo");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Provincia.class);
			q.add(Restrictions.eq("codigo", codigo));
			return (Provincia) q.uniqueResult();
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
}
