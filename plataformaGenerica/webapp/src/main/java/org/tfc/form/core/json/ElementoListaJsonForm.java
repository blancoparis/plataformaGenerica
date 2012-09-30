package org.tfc.form.core.json;

import java.io.Serializable;
/**
 * 
 * Es donde guardaremos un item de un listado para los json.
 * 
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class ElementoListaJsonForm implements Serializable{
	
	private Long id;
	private String descripcion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
