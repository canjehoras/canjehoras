package com.vcortes.canjehoras.dao;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Canje;

public class CanjeDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(CanjeDAO.class);
	
	public List<Canje> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Canje.class);
	}

	public List<Canje> listadoCanjesPorAgenda(Long idAgenda, String estado, Long idUsuario)throws Throwable {
		log.debug("listadoTruequesLibres");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Canje.class);
			q.add(Restrictions.or(Restrictions.eq("agenda.id", idAgenda), Restrictions.eq("usuario.id", idUsuario)));
			List result = q.list();
			return result;
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
	public List<Canje> listadoCanjesUsuarioDemanda (Long idUsuario)throws Throwable {
		log.debug("listadoCanjesUsuarioDemanda");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Canje.class);
			if(null != idUsuario){
				q.add(Restrictions.eq("usuario.id", idUsuario));
			}
			q.addOrder(Order.desc("id"));
			List result = q.list();
			return result;
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}	
	
	
	public List<Canje> findCanjesPorTrueque(Long idTrueque)throws Throwable {
		log.debug("findCanjesPorTrueque");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Canje.class);
			q.add(Restrictions.eq("trueque.id", idTrueque));
			List result = q.list();
			return result;
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	

	public List<Canje> listadoCanjesFecha(Date fecha)throws Throwable {
		log.debug("listadoCanjesFecha");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Canje.class);
			if(null != fecha){
				q.add(Restrictions.eq("fecha", fecha));
			}
			List result = q.list();
			return result;
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
	public Canje detalle(Long id)throws Throwable {
		log.debug("detalle");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Canje.class);
			q.add(Restrictions.eq("id", id));
			return (Canje) q.uniqueResult();
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
	
}
