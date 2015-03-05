package com.vcortes.canjehoras.model;

import java.io.Serializable;

/**
 * Almacena las categorias existentes en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String descripcion;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Categoria(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 *    
	 */
	public Categoria(Long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	/**
	 * Obtiene el identificador de la categoria
	 * 
	 * @return id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * Fija el identificador de la categoria
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}	
	
	/**
	 * Obtiene la descripcion de la categoria
	 * 
	 * @return descripción
	 */
	public String getDescripcion(){
		return descripcion;
	}

	/**
	 * Fija la descripcion de la categoria
	 * 
	 * @param descripción
	 */
	public void setDescripcion(String descripcion){
		this.descripcion = descripcion;
	}
}

