package org.tfc.form;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.tfc.form.core.OperacionBaseForm;

@SuppressWarnings("serial")
public class PruebaForm extends OperacionBaseForm<Long>{
	@NotBlank
	private String descripcion;

	private Date fecha;

	
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
