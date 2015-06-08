package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Agenda;

/**
 * Clase de la capa de acceso a la agenda
 * 
 * @author Vanesa Cortés
 *
 */
public class AgendaDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(AgendaDAO.class);
	
	/**
	 * Devuelve todas las agendas de la aplicación
	 * @return List<Agenda>
	 * @throws Throwable
	 */
	public List<Agenda> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Agenda.class);
	}

	/**
	 * Busca la agenda completa por el identificador de usuario
	 * @param idUsuario
	 * @return Agenda
	 * @throws Throwable
	 */
	public Agenda findAgendaPorUsuario(Long idUsuario)throws Throwable {
		log.debug("findAgendaPorUsuario");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Agenda.class);
			q.add(Restrictions.eq("usuario.id", idUsuario));
			return (Agenda) q.uniqueResult();
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
}
