package com.vcortes.canjehoras.model;

/**
 * Tabla Maestra Provincia
 * @author Vanesa Cort�s
 *
 */
public class Provincia extends Base {

	private static final long serialVersionUID = 1L;
	private String codigo;
	private String descripcion;

	/**
	 * Contructor basico
	 */
	public Provincia() {
	}

	public Provincia(Long id) {
		setId(id);
	}

	/**
	 * Constructor
	 * 
	 * @param codigo
	 * @param descripcion
	 */
	public Provincia(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el codigo del tipo
	 * 
	 * @return C�digo del tipo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Fija el c�digo del tipo
	 * 
	 * @param codigo
	 *            C�digo del tipo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene la descripcion del tipo
	 * 
	 * @return Descripci�n del tipo
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Fija la descripcion del tipo
	 * 
	 * @param descripcion
	 *            Descripci�n del tipo
	 */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		} else if (o instanceof Provincia && ((Provincia) o).getId().longValue() == this.getId().doubleValue()) {
			return true;
		} else {
			return false;
		}
	}
}

