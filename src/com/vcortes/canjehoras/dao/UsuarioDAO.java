package com.vcortes.canjehoras.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Usuario;


public class UsuarioDAO extends BaseDAO {

	private static final Log log = LogFactory.getLog(UsuarioDAO.class);
	
	
	public Provincia findUsuarioByLogin(String login) throws Exception {
		log.info("findUsuarioByLogin");
		try{
			Criteria q = sessionFactory.getCurrentSession().createCriteria(Provincia.class);
			q.add(Restrictions.eq("codigo", login));
			List result = q.list();
			sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
			
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
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	

}
