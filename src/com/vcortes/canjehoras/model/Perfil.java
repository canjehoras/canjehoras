package com.vcortes.canjehoras.model;

// Generated 31-ene-2015 17:30:18 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil implements java.io.Serializable {

	private Integer id;
	private String codigo;
	private String descripcion;
	private Set usuarios = new HashSet(0);

	public Perfil() {
	}

	public Perfil(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Perfil(String codigo, String descripcion, Set usuarios) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set usuarios) {
		this.usuarios = usuarios;
	}

}
