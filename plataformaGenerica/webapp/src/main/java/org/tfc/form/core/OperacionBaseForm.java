package org.tfc.form.core;

import java.io.Serializable;

/**
 * 
 * Se esblecemos las parametros para el tipo de operación.
 * 
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
public class OperacionBaseForm<ID extends Serializable> extends BaseForm {

	private String operacionCrud;
	
	private ID id;
	
	

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getOperacionCrud() {
		return operacionCrud;
	}

	public void setOperacionCrud(String operacionCrud) {
		this.operacionCrud = operacionCrud;
	}
	
	

}