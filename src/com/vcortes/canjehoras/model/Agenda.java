package com.vcortes.canjehoras.model;

import java.io.Serializable;

/**
 * Almacena los datos de la agenda en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Agenda implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Usuario usuario;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Agenda(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 *    
	 */
	public Agenda(Long id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}
	
	/**
	 * Obtiene el identificador de la agenda
	 * 
	 * @return id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * Fija el identificador de la agenda
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

	
}

