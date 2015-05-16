package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Agenda;
import com.vcortes.canjehoras.model.Canje;

public class CanjeDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(CanjeDAO.class);
	
	public List<Canje> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Canje.class);
	}

	public List<Canje> listadoCanjesLibres(Long idUsuario)throws Throwable {
		log.debug("listadoTruequesLibres");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Agenda.class);
			if(null != idUsuario){
				q.add(Restrictions.eq("usuario.id", idUsuario));
			}
			List result = q.list();
			return result;
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
}
