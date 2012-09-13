package org.tfc.form.core;

import java.io.Serializable;
import java.util.List;

import org.tfc.form.core.json.OperacionResultadoJson;
import org.tfc.form.core.subs.AbstractTablaSubForm;

@SuppressWarnings("serial")
public class AbstractBuscadorForm<TF extends AbstractTablaSubForm<ID>, ID extends Serializable> extends BaseForm {

	private ID id;
	
	private List<TF> resultado;

	private OperacionResultadoJson operacionResultadoJson;
	
	
	
	public OperacionResultadoJson getOperacionResultadoJson() {
		return operacionResultadoJson;
	}

	public void setOperacionResultadoJson(
			OperacionResultadoJson operacionResultadoJson) {
		this.operacionResultadoJson = operacionResultadoJson;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public List<TF> getResultado() {
		return resultado;
	}

	public void setResultado(List<TF> resultado) {
		this.resultado = resultado;
	}

	

}