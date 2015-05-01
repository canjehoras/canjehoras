package com.vcortes.canjehoras.bl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.vcortes.canjehoras.dao.TruequeDAO;
import com.vcortes.canjehoras.model.Categoria;
import com.vcortes.canjehoras.model.Provincia;
import com.vcortes.canjehoras.model.Trueque;


public class TruequeBL {
	
	private TruequeDAO truequeDAO;

	
	public Object saveOrUpdate(Object instance) throws Exception{
		return truequeDAO.saveOrUpdate(instance);
	}
	
	public List findAll(Object instance) throws Exception{
		return truequeDAO.findAll(instance);
	}
	
	public Object findById(Object instance, Serializable id) throws Exception {
		return truequeDAO.findById(instance, id);
	}

	public TruequeDAO getTruequeDAO() {
		return truequeDAO;
	}


	public void setTruequeDAO(TruequeDAO truequeDAO) {
		this.truequeDAO = truequeDAO;
	}
	
	public List<Trueque> findTrueque(Long idProvincia, Long idCategoria, Long idUsuario, String estado) throws Throwable {
		return truequeDAO.findTrueque(idProvincia, idCategoria, idUsuario, estado);
	}
	
	public List<Trueque> findTruequePreferencias(ArrayList<Long> listadoProvincia, ArrayList<Long> listadoCategoria, String estado) throws Throwable {
		return truequeDAO.findTruequePreferencias(listadoProvincia, listadoCategoria, estado);
	}

	public Trueque detalle(Long id) throws Throwable {
		return truequeDAO.detalle(id);
	}
	
	public List<Trueque> buscarTrueques(String descripcion, List<Provincia> provincias, Categoria categoria){
		return truequeDAO.buscarTrueques(descripcion, provincias, categoria);
	}
}
