package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Trueque;


public class TruequeDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(TruequeDAO.class);
	
	public List<Trueque> findTrueque(Long idProvincia, Long idCategoria, Long idUsuario)throws Throwable {
		log.debug("findTrueque");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Trueque.class);
			if(null != idCategoria){
				q.add(Restrictions.eq("categoria.id", idCategoria));
			}
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
	
	public Trueque detalle(Long id)throws Throwable {
		log.debug("detalle");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Trueque.class);
			q.add(Restrictions.eq("id", id));
			return (Trueque) q.uniqueResult();
			
		} catch (Exception e) {
			log.error("", e);
		}
		return null;
	}
	
	/**
	 * 
	 * @param descripcion
	 * @return
	 */
	public List<Trueque> buscarTrueques(String descripcion, List<Provincia> provincias, Categoria categoria){
		log.debug("detalle");
		try {
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Trueque.class);
			if(descripcion!=null && !"".equals(descripcion)){
				q.add(Restrictions.ilike("descripcion", "%" + descripcion + "%"));
			}
			
			if(provincias!=null && provincias.size()>0){
				q.add(Restrictions.in("provincia", provincias));
			}
			
			if(categoria!=null){
				q.add(Restrictions.eq("categoria", categoria));
			}
			return q.list();
		} catch (Exception e) {
			log.error("Error realizando la búsqueda de trueques", e);
		}
		return null;
		
		
	}
}
