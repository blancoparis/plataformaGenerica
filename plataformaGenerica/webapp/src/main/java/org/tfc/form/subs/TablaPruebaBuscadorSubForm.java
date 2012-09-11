package org.tfc.form.subs;

import java.io.Serializable;
/**
 * 
 * 
 * 
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class TablaPruebaBuscadorSubForm extends AbstractTablaSubForm<Long> implements Serializable{
	
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
