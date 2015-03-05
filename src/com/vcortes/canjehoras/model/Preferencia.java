package com.vcortes.canjehoras.model;

import java.io.Serializable;

/**
 * Almacena las preferencias de los usuarios en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Preferencia implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Usuario usuario;
	private Categoria categoria;
	private Provincia provincia;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Preferencia(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 *    
	 */
	public Preferencia(Long id, Usuario usuario, Categoria categoria, Provincia provincia) {
		this.id = id;
		this.usuario = usuario;
		this.categoria = categoria;
		this.provincia = provincia;
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
	
	/**
	 * Obtiene la provincia asociado a la preferencia
	 * 
	 * @return categoria
	 */
	public Provincia getProvincia(){
		return provincia;
	}

	/**
	 * Fija la provincia asociado a la preferencia
	 * 
	 * @param categoria
	 */
	public void setProvincia(Provincia provincia){
		this.provincia = provincia;
	}
}

