package org.tfc.bom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.tfc.EntityBD;

/**
 * 
 * @author David Blanco París
 *
 */
@Entity
public class Menu implements EntityBD<Long>{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String descripcion;
	
	@ManyToOne()
	private Flujo flujo;

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

	public Flujo getFlujo() {
		return flujo;
	}

	public void setFlujo(Flujo flujo) {
		this.flujo = flujo;
	}
	
	
	
}
