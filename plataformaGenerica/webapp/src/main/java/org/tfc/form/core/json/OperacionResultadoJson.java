package org.tfc.form.core.json;

import java.io.Serializable;

public class OperacionResultadoJson implements Serializable {
	
	private String operacion;
	
	private String descripcion;
	

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
