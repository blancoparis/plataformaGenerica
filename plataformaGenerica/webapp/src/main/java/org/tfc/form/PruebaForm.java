package org.tfc.form;

import org.hibernate.validator.constraints.NotBlank;
import org.tfc.form.core.OperacionBaseForm;

@SuppressWarnings("serial")
public class PruebaForm extends OperacionBaseForm<Long>{
	@NotBlank
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
