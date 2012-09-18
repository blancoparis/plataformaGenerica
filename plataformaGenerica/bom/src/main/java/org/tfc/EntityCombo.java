package org.tfc;

import java.io.Serializable;
/**
 * 
 * Simboliza los datos del combo
 * 
 * @author David Blanco París
 *
 * @param <ID>
 */
public interface EntityCombo <ID extends Serializable> extends EntityBD<ID>{ 
	
	   public String getDescripcion();

	   public void setDescripcion(String id);

}
