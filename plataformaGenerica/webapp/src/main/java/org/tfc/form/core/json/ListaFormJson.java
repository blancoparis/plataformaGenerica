package org.tfc.form.core.json;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * Es la estructura de datos donde, guardaremos la información,
 * para el tema de las listas. 
 * 
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class ListaFormJson implements Serializable{

	private String descripcion;
	
	private List<ElementoListaJsonForm> elementos;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<ElementoListaJsonForm> getElementos() {
		return elementos;
	}

	public void setElementos(List<ElementoListaJsonForm> elementos) {
		this.elementos = elementos;
	}
	
	
	
	
}
