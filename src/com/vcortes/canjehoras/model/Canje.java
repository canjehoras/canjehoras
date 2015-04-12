package com.vcortes.canjehoras.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Almacena las reservas de los usuarios en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Canje implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Usuario usuario;
	private Trueque trueque;
	private Agenda agenda;
	private Date fecha;
	private String hora_inicio;
	private String hora_fin;
	private String modalidad;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Canje(){
	}
	
	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 *    
	 */
	public Canje(Long id, Usuario usuario, Trueque trueque, Agenda agenda, 
			Date fecha, String hora_inicio, String hora_fin, String modalidad) {
		this.id = id;
		this.usuario = usuario;
		this.trueque = trueque;
		this.agenda = agenda;
		this.fecha = fecha;
		this.hora_inicio = hora_inicio;
		this.hora_fin = hora_fin;
	}
	
	/**
	 * Obtiene el identificador de las reservas
	 * 
	 * @return id
	 */
	public Long getId(){
		return id;
	}

	/**
	 * Fija el identificador de las reservas
	 * 
	 * @param id
	 */
	public void setId(Long id){
		this.id = id;
	}	
	
	/**
	 * Obtiene el usuario asociado a la reserva
	 * 
	 * @return usuario
	 */
	public Usuario getUsuario(){
		return usuario;
	}

	/**
	 * Fija el usuario asociado a la reserva
	 * 
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;
	}

	/**
	 * Obtiene el trueque asociado a la reserva
	 * 
	 * @return trueque
	 */
	public Trueque getTrueque() {
		return trueque;
	}

	/**
	 * Fija el trueque de las reservas
	 * 
	 * @param trueque
	 */
	public void setTrueque(Trueque trueque) {
		this.trueque = trueque;
	}

	/**
	 * Obtiene la agenda asociado a la reserva
	 * 
	 * @return agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * Fija la agenda de las reservas
	 * 
	 * @param agenda
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	/**
	 * Obtiene la fecha asociado a la reserva
	 * 
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Fija la fecha de las reservas
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene la hora de inicio asociado a la reserva
	 * 
	 * @return hora_inicio
	 */
	public String getHora_inicio() {
		return hora_inicio;
	}

	/**
	 * Fija la hora inicio de las reservas
	 * 
	 * @param hora_inicio
	 */
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	/**
	 * Obtiene la hora final asociado a la reserva
	 * 
	 * @return hora_fin
	 */
	public String getHora_fin() {
		return hora_fin;
	}

	/**
	 * Fija la hora final de las reservas
	 * 
	 * @param hora_fin
	 */
	public void setHora_fin(String hora_fin) {
		this.hora_fin = hora_fin;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
}

