/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tfc;

import java.io.Serializable;

/**
 *
 * Es la interfaz que tienen que implementar cualquier entity.
 * 
 * @author david
 */
public interface EntityBD<ID extends Serializable> extends Serializable{
    
    public ID getId();

    public void setId(ID id);
}
