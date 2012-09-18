package org.tfc.service;

import java.io.Serializable;

import org.tfc.EntityCombo;
/**
 * Servicio que gestiona la logica relacionada con los combos.
 * @author David Blanco París
 *
 * @param <T>
 * @param <ID>
 */
public interface AbstractComboService <T extends EntityCombo<ID>, ID extends Serializable> 
	extends AbstractService<T,ID> {

}
