package org.tfc.bom;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.tfc.EntityCombo;
/**
 * Es donde definimos el combo
 * @author David Blanco París
 *
 */
@SuppressWarnings("serial")
@Entity
public class Flujo implements EntityCombo<Long>{
	@Id
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
