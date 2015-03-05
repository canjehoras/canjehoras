package com.vcortes.canjehoras.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Almacena los datos de los usuarios en la aplicación
 * @author Vanesa Cortés Gimeno
 *
 */
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String idioma;
	private String perfil;
	private Date fecha_alta;
	private Date fecha_baja;
	private String correo_electronico;
	private String pass;
	private String apellido1;
	private String apellido2;
	private String nombre;
	private String movil;
	private String telefono;
	private Boolean wassap;
	private Integer num_acceso;
	private Date fecha_ultimo_acceso;	
	private Provincia provincia;
	private Agenda agenda;
	
	/**
	 * Constructor por defecto
	 * 
	 */
	public Usuario(){
	}
	
	/**
	 * Constructor para el registro
	 * 
	 * @param id
	 * @param correo_electronico
	 * @param pass
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param movil
	 * @param telefono
	 * @param wassap
	 * @param provincia
	 * @param idioma
	 * @param perfil
	 * @param fecha_alta
	 */
	public Usuario(Long id, String correo_electronico, String pass,
			String nombre, String apellido1, String apellido2,
			String movil, String telefono, Boolean wassap, 
			Provincia provincia, String idioma, String perfil, Date fecha_alta) {
		this.id = id;
		this.correo_electronico = correo_electronico;
		this.pass = pass;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.movil = movil;
		this.telefono = telefono;
		this.wassap = wassap;
		this.idioma = idioma;
		this.provincia = provincia;
		this.perfil = perfil;
		this.fecha_alta = fecha_alta;
	}
	
	/**
	 * Constructor 
	 * 
	 * @param id
	 * @param correo_electronico
	 * @param pass
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param movil
	 * @param telefono
	 * @param wassap
	 * @param provincia
	 * @param idioma
	 * @param perfil
	 * @param fecha_alta
	 * @param fecha_baja
	 * @param num_acceso
	 * @param fecha_ultimo_acceso
	 * @param agenda
	 */
	public Usuario(Long id, String correo_electronico, String pass,
			String nombre, String apellido1, String apellido2,
			String movil, String telefono, Boolean wassap, 
			Provincia provincia, String idioma, String perfil, Date fecha_alta, 
			Date fecha_baja, Integer num_acceso, Date fecha_ultimo_acceso, Agenda agenda) {
		this.id = id;
		this.correo_electronico = correo_electronico;
		this.pass = pass;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre = nombre;
		this.movil = movil;
		this.telefono = telefono;
		this.wassap = wassap;
		this.idioma = idioma;
		this.provincia = provincia;
		this.perfil = perfil;
		this.fecha_alta = fecha_alta;
		this.fecha_baja = fecha_baja;
		this.num_acceso = num_acceso;
		this.fecha_ultimo_acceso = fecha_ultimo_acceso;
		this.agenda = agenda;
	}

	/**
	 * Obtiene el identificador del usuario
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Fija el identificador del usuario
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Obtiene el idioma del usuario
	 * @return idioma
	 */
	public String getIdioma() {
		return idioma;
	}

	/**
	 * Fija el idioma del usuario
	 * 
	 * @param idioma
	 */
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	/**
	 * Obtiene el perfil del usuario
	 * @return perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Fija el perfil del usuario
	 * 
	 * @param perfil
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Obtiene la fecha de alta del usuario
	 * @return fecha_alta
	 */
	public Date getFecha_alta() {
		return fecha_alta;
	}

	/**
	 * Fija la fecha de alta del usuario
	 * 
	 * @param fecha_alta
	 */
	public void setFecha_alta(Date fecha_alta) {
		this.fecha_alta = fecha_alta;
	}

	/**
	 * Obtiene la fecha de baja del usuario
	 * @return fecha_baja
	 */
	public Date getFecha_baja() {
		return fecha_baja;
	}

	/**
	 * Fija la fecha de baja del usuario
	 * 
	 * @param fecha_baja
	 */
	public void setFecha_baja(Date fecha_baja) {
		this.fecha_baja = fecha_baja;
	}

	/**
	 * Obtiene el correo electronico del usuario
	 * @return correo_electronico
	 */
	public String getCorreo_electronico() {
		return correo_electronico;
	}

	/**
	 * Fija el correo electronico del usuario
	 * 
	 * @param correo_electronico
	 */
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	/**
	 * Obtiene el pass del usuario
	 * @return pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * Fija el pass del usuario
	 * 
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Obtiene el apellido1 del usuario
	 * @return apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * Fija el apellido1 del usuario
	 * 
	 * @param apellido1
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * Obtiene el apellido2 del usuario
	 * @return apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * Fija el apellido2 del usuario
	 * 
	 * @param apellido2
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * Obtiene el nombre del usuario
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Fija el nombre del usuario
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el movil del usuario
	 * @return movil
	 */
	public String getMovil() {
		return movil;
	}

	/**
	 * Fija el movil del usuario
	 * 
	 * @param movil
	 */
	public void setMovil(String movil) {
		this.movil = movil;
	}

	/**
	 * Obtiene el telefono del usuario
	 * @return telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Fija el telefono del usuario
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene si el usuario tiene o no wassap
	 * @return wassap
	 */
	public Boolean getWassap() {
		return wassap;
	}

	/**
	 * Fija si el usuario tiene o no wassap
	 * 
	 * @param wassap
	 */
	public void setWassap(Boolean wassap) {
		this.wassap = wassap;
	}

	/**
	 * Obtiene el numero de acceso del usuario
	 * @return num_acceso
	 */
	public Integer getNum_acceso() {
		return num_acceso;
	}

	/**
	 * Fija el número de acceso del usuario
	 * 
	 * @param num_acceso
	 */
	public void setNum_acceso(Integer num_acceso) {
		this.num_acceso = num_acceso;
	}

	/**
	 * Obtiene la fecha del último acceso del usuario
	 * @return fecha_ultimo_acceso
	 */
	public Date getFecha_ultimo_acceso() {
		return fecha_ultimo_acceso;
	}

	/**
	 * Fija la fecha del último acceso del usuario
	 * 
	 * @param fecha_ultimo_acceso
	 */
	public void setFecha_ultimo_acceso(Date fecha_ultimo_acceso) {
		this.fecha_ultimo_acceso = fecha_ultimo_acceso;
	}

	/**
	 * Obtiene la provincia del usuario
	 * @return provincia
	 */
	public Provincia getProvincia() {
		return provincia;
	}

	/**
	 * Fija la provincia del usuario
	 * 
	 * @param provincia
	 */
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	/**
	 * Obtiene la agenda del usuario
	 * @return agenda
	 */
	public Agenda getAgenda() {
		return agenda;
	}

	/**
	 * Fija la agenda del usuario
	 * 
	 * @param agenda
	 */
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}	
}
