package com.vcortes.canjehoras.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

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
	
	public List findAll(Object instance) throws Exception{
		logger.info("findAll - BaseDAO");
		return (sessionFactory.getCurrentSession().createCriteria(instance.getClass()).list());
	}
			
	public List findAll(Object instance, String orderBy) throws Exception{
		logger.info("findAll - BaseDAO");
		Session session = (Session) sessionFactory.getCurrentSession();
		return (session.createCriteria(instance.getClass()).addOrder(Order.asc(orderBy)).list());
	}
	
	/**
	 * Elimina todos los objetos de la colección pasada como parámetro
	 * @param list
	 * @throws Exception
	 */
	public void deleteAll(Collection list) throws Exception {
		logger.debug("deleteAll");
		sessionFactory.getCurrentSession().delete(list);
	}
	
	/**
	 * Elimina el objeto pasado como parámetro
	 * @param instance
	 * @throws Exception
	 */
	public void delete(Object instance) throws Exception {
		logger.debug("delete - BaseDAO");
		sessionFactory.getCurrentSession().delete(instance);
	}
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	/**
	 * Ejecuta una consulta "SQL"
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List executeSQL(String sql) throws Exception {
		logger.debug("executeSQL");
		SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return query.list();
	}
}
