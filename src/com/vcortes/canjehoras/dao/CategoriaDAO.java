package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vcortes.canjehoras.model.Categoria;


public class CategoriaDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(CategoriaDAO.class);
	
	public List<Categoria> findAll() throws Throwable {
		log.debug("findAll");
		return findAll(Categoria.class);
	}

	
	
/**	public Usuario findUsuarioByLogin(String login) throws Exception {
		log.info("findUsuarioByLogin");		
		Criteria q = sessionFactory.getCurrentSession().createCriteria(Usuario.class);
		q.add(Restrictions.eq("correo_electronico", login));
		List result = q.list();
		
		return (Usuario) first(result);
	}*/

	
	/**
	 Provincia p = new Provincia();
	p.setCodigo("aaaa");
	p.setDescripcion("aaaa");
	p.setId(999);
	saveOrUpdate(p); 
	
	if(result!=null && result.size()>0){
		return (Provincia) result.get(0);
	}else{
		return null;
	}
	 */

}
