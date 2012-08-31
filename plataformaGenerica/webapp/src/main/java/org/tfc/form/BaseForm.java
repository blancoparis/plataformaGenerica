package org.tfc.form;

import java.io.Serializable;
import java.util.List;

import org.tfc.form.subs.ErroresNegocioSubForm;

@SuppressWarnings("serial")
public class BaseForm implements Serializable{

	private List<ErroresNegocioSubForm> erroresNegocio;

	public List<ErroresNegocioSubForm> getErroresNegocio() {
		return erroresNegocio;
	}

	public void setErroresNegocio(List<ErroresNegocioSubForm> erroresNegocio) {
		this.erroresNegocio = erroresNegocio;
	}
	
	
}
