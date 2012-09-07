package org.tfc.form.enumerados;

/**
 * Definimos los tipos de operación estandar.</br>
 * <ul>
 * 	<li><b>Ok</b>: Para cuando la operación se ha realizado correctamente</li>
 *  <li><b>Error</b>:Para cuando se ha producido un error</li>
 * </ul>
 * @author David Blanco París
 *
 */
public enum TipoOperacionResultado {
	OK("general.tipoOperacion.ok.descripcion","general.tipoOperacion.ok.mensajeDescripcion"),
	ERROR("general.tipoOperacion.error.descripcion","general.tipoOperacion.error.mensajeDescripcion")
	;
	private String descipcion;
	private String mensajeDescripcion;
	private TipoOperacionResultado(String descipcion, String mensajeDescripcion) {
		this.descipcion = descipcion;
		this.mensajeDescripcion = mensajeDescripcion;
	}
	
	public String getDescipcion() {
		return descipcion;
	}
	public void setDescipcion(String descipcion) {
		this.descipcion = descipcion;
	}
	public String getMensajeDescripcion() {
		return mensajeDescripcion;
	}
	public void setMensajeDescripcion(String mensajeDescripcion) {
		this.mensajeDescripcion = mensajeDescripcion;
	}
	
	
}
