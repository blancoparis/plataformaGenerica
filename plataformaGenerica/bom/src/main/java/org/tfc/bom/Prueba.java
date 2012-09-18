package org.tfc.bom;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.tfc.EntityBD;


@Entity
public class Prueba implements EntityBD<Long>{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descripcion;
	
	private Date fecha;
	
	
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

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
