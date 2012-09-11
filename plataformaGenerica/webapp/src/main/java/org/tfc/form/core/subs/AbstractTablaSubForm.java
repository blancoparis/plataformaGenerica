package org.tfc.form.core.subs;

import java.io.Serializable;
/**
 * 
 * Establecemos el identificador del registro.
 * 
 * @author David Blanco París
 *
 * @param <ID>
 */
@SuppressWarnings("serial")
public class AbstractTablaSubForm <ID extends Serializable> implements Serializable {

	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}
	
	
}