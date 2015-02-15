package com.vcortes.canjehoras.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

public class BaseDAO {

	protected static final Log logger = LogFactory.getLog(BaseDAO.class);
	
	protected SessionFactory sessionFactory;
	
	public Object first(List result){
		if(result!=null && result.size()>0){
			return result.get(0);
		}
		return null;
	}
	
	public Object saveOrUpdate(Object instance) throws Exception {
		logger.info("saveOrUpdate - BaseDAO");
		sessionFactory.getCurrentSession().saveOrUpdate(instance);
		return instance;
	}

	
	public Object findFirstByExample(Object instance) throws Exception {
		logger.info("findFirstByExample - BaseDAO");
		return sessionFactory.getCurrentSession().createCriteria(instance.getClass()).add(
					Example.create(instance)).setMaxResults(1).uniqueResult();
	}
	
	public List findByExample(Object instance) throws Exception {
		logger.info("findByExample - BaseDAO");
		return sessionFactory.getCurrentSession().createCriteria(instance.getClass()).add(
				Example.create(instance)).list();
	}

	
	public Object findById(Object instance, Serializable id) throws Exception {
		logger.info("findById - BaseDAO");
		return (sessionFactory.getCurrentSession().get(instance.getClass(), id));
	}
	
			
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
