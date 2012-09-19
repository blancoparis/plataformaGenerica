package org.tfc.bom;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


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
	
	@OneToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval=false)
	  @JoinTable(name="hijos")
	private Set<Menu> hijos;
	@ManyToOne()
	@JoinColumn(referencedColumnName="id")
	private Menu padre;
	
	

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

	public Set<Menu> getHijos() {
		return hijos;
	}

	public void setHijos(Set<Menu> menu) {
		this.hijos = menu;
	}

	public Menu getPadre() {
		return padre;
	}

	public void setPadre(Menu padre) {
		this.padre = padre;
	}
	
	
	
}
