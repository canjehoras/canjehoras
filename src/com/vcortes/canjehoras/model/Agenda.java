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
	private Boolean estado;
	
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
	public Agenda(Long id, Boolean estado, Usuario usuario) {
		this.id = id;
		this.estado = estado;
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

	/**
	 * Obtiene el estado de la agenda
	 * 
	 * @return estado (1-DISPONIBLE / 0-NO DISPONIBLE)
	 */
	public Boolean getEstado() {
		return estado;
	}

	/**
	 * Fija el estado de la agenda
	 * 
	 * @param estado
	 */
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

	
}

