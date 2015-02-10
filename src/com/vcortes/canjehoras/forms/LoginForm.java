package com.vcortes.canjehoras.forms;

import com.vcortes.canjehoras.model.Idioma;
import com.vcortes.canjehoras.model.Provincia;

public class LoginForm {
	
	private String correoElectronico;
	private String pass;
	
	private Idioma idioma;
	private Provincia provincia;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String movil;
	private String telefono;
	private Boolean wassap;
	
	
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Idioma getIdioma() {
		return idioma;
	}
	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
	public Provincia getProvincia() {
		return provincia;
	}
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMovil() {
		return movil;
	}
	public void setMovil(String movil) {
		this.movil = movil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Boolean getWassap() {
		return wassap;
	}
	public void setWassap(Boolean wassap) {
		this.wassap = wassap;
	}

}
