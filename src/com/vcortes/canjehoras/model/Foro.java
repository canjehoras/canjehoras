package com.vcortes.canjehoras.model;

import java.io.Serializable;
import java.util.Date;


/**
 * Almacena todos los trueques existentes en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Foro implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha_creacion;
	private String hora_creacion;
	private Trueque trueque;

	/**
	 * Constructor por defecto
	 * 
	 */
	public Foro(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param fecha_alta
	 * @param estado
	 * @param titulo
	 * @param descripcion
	 * @param tipo
	 * @param imagen
	 * @param usuario
	 * @param categoria
	 */
	public Foro(Long id, Date fecha_creacion, String hora_creacion, Trueque trueque) {
		this.id = id;
		this.fecha_creacion = fecha_creacion;
		this.hora_creacion = hora_creacion;
		this.trueque = trueque;
	}
	
	/**
	 * Obtiene el identificador del trueque
	 * 
	 * @return id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * Fija el identificador del trueque
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getHora_creacion() {
		return hora_creacion;
	}

	public void setHora_creacion(String hora_creacion) {
		this.hora_creacion = hora_creacion;
	}

	public Trueque getTrueque() {
		return trueque;
	}

	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
	}

}

