package com.vcortes.canjehoras.model;

import java.io.Serializable;
import java.util.Date;

import com.mysql.jdbc.Blob;

/**
 * Almacena todos los trueques existentes en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Trueque implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date fecha_alta;
	private String estado;
	private String titulo;
	private String descripcion;
	private String tipo;
	private Blob imagen;
	private Usuario usuario;
	private Categoria categoria;

	/**
	 * Constructor por defecto
	 * 
	 */
	public Trueque(){
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
	public Trueque(Long id, Date fecha_alta, String estado, String titulo, 
					String descripcion, String tipo, Blob imagen, Usuario usuario, Categoria categoria) {
		this.id = id;
		this.fecha_alta = fecha_alta;
		this.estado = estado;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.imagen = imagen;
		this.usuario = usuario;
		this.categoria = categoria;
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

	/**
	 * Obtiene la fecha de alta del trueque
	 * 
	 * @return fecha_alta
	 */
	public Date getFecha_alta() {
		return fecha_alta;
	}

	/**
	 * Fija la fecha de alta del trueque
	 * 
	 * @param fecha_alta
	 */
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	/**
	 * Obtiene el estado del trueque
	 * 
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Fija el estado del trueque
	 * 
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene el titulo del trueque
	 * 
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Fija el titulo del trueque
	 * 
	 * @param titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene el descripcion del trueque
	 * 
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Fija la descripción del trueque
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el tipo del trueque
	 * 
	 * @return tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Fija el tipo del trueque
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el imagen del trueque
	 * 
	 * @return imagen
	 */
	public Blob getImagen() {
		return imagen;
	}

	/**
	 * Fija la imagen del trueque
	 * 
	 * @param imagen
	 */
	public void setImagen(Blob imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene el usuario del trueque
	 * 
	 * @return usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * Fija el usuario del trueque
	 * 
	 * @param usuario
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene la categoria del trueque
	 * 
	 * @return id
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Fija la categoria del trueque
	 * 
	 * @param categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
}

