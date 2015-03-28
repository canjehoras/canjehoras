package com.vcortes.canjehoras.model;

import java.io.Serializable;

/**
 * Almacena las preferencias de los usuarios en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class PrefCategoria implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Usuario usuario;
	private Categoria categoria;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public PrefCategoria(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 *    
	 */
	public PrefCategoria(Long id, Usuario usuario, Categoria categoria) {
		this.id = id;
		this.usuario = usuario;
		this.categoria = categoria;
	}
	
	/**
	 * Obtiene el identificador de las preferencias
	 * 
	 * @return id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * Fija el identificador de las preferencias
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}	
	
	/**
	 * Obtiene el usuario asociado a la preferencia
	 * 
	 * @return usuario
	 */
	public Usuario getUsuario(){
		return usuario;
	}

	/**
	 * Fija el usuario asociado a la preferencia
	 * 
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}
	
	/**
	 * Obtiene la categoria asociado a la preferencia
	 * 
	 * @return categoria
	 */
	public Categoria getCategoria(){
		return categoria;
	}

	/**
	 * Fija la categoria asociado a la preferencia
	 * 
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}
}

