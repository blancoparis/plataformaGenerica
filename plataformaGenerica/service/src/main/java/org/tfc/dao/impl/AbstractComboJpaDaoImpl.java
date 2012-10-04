package org.tfc.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.tfc.EntityCombo;
import org.tfc.dao.AbstractComboJpaDao;
/**
 * Implementación de los combos
 * @author David Blanco París
 *
 * @param <T>
 * @param <ID>
 */
public class AbstractComboJpaDaoImpl <T extends EntityCombo<ID>, ID extends Serializable> 
	extends AbstractJpaDaoImpl<T,ID> implements AbstractComboJpaDao<T,ID>{

	public List<T> findAllOrder() {
		return entityManager.createQuery("from " + getClazzT().getName() +" order by descripcion")
				.getResultList();
	}
}
