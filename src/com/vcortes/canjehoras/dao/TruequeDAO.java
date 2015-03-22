package com.vcortes.canjehoras.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
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
	
	
	public Trueque saveTrueque(Trueque trueque,InputStream fichero)throws Throwable {
		 Session session = sessionFactory.getCurrentSession();
         ByteArrayOutputStream buffer = new ByteArrayOutputStream();

         int nRead;
         byte[] data = new byte[16384];

         while ((nRead = fichero.read(data, 0, data.length)) != -1) {
             buffer.write(data, 0, nRead);
         }

         buffer.flush();
         Blob blob = Hibernate.getLobCreator(session).createBlob(buffer.toByteArray());
         trueque.setImagen(blob);


         return (Trueque) saveOrUpdate(trueque);
         
	}
	
}
