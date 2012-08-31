package org.tfc.form.subs;

import java.io.Serializable;
/**
 * Es una clase para organizar los errores.
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class ErroresNegocioSubForm implements Serializable{
	
	private String titulo;
	private String mensaje;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
