package com.vcortes.canjehoras.model;

import java.io.Serializable;
import java.util.Date;


/**
 * Almacena todos los trueques existentes en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Publicacion implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha;
	private String hora;
	private String comentario;
	private Usuario usuario;
	private Foro foro;

	/**
	 * Constructor por defecto
	 * 
	 */
	public Publicacion(){
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
	public Publicacion(Long id, Date fecha, String hora, String comentario, Usuario usuario, Foro foro) {
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.comentario = comentario;
		this.usuario = usuario;
		this.foro = foro;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Foro getForo() {
		return foro;
	}

	public void setForo(Foro foro) {
		this.foro = foro;
	}


}

