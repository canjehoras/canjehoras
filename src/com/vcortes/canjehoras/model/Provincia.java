package com.vcortes.canjehoras.model;

import java.io.Serializable;

/**
 * Almacena las provincias existentes en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Provincia implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Provincia(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 *    
	 */
	public Provincia(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene el identificador de la provincia
	 * 
	 * @return id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * Fija el identificador de la provincia
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}	
	
	/**
	 * Obtiene la descripcion de la provincia
	 * 
	 * @return descripción
	 */
	public String getDescripcion(){
		return descripcion;
	}

	/**
	 * Fija la descripcion de la provincia
	 * 
	 * @param descripción
	 */
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
}

