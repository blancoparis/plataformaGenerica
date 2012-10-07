package org.tfc.form.core.subs;

import java.io.Serializable;
import java.util.List;

import org.tfc.bom.Menu.TipoMenu;
/**
 * Nodo donde pintamos un arbol.
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class NodoArbolSubForm implements Serializable{
	
	private String descripcion;
	private String url;
	private TipoMenu tipo;
	private List<NodoArbolSubForm> hijos;
	private NodoArbolSubForm padre;
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public List<NodoArbolSubForm> getHijos() {
		return hijos;
	}
	public void setHijos(List<NodoArbolSubForm> hijos) {
		this.hijos = hijos;
	}
	public NodoArbolSubForm getPadre() {
		return padre;
	}
	public void setPadre(NodoArbolSubForm padre) {
		this.padre = padre;
	}
	public TipoMenu getTipo() {
		return tipo;
	}
	public void setTipo(TipoMenu tipo) {
		this.tipo = tipo;
	}
	

}
