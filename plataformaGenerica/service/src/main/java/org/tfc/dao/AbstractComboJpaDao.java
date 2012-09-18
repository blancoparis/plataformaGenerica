package org.tfc.dao;

import java.io.Serializable;

import org.tfc.EntityCombo;
/**
 * La abstración relacionada con los combos
 * @author David Blanco París
 *
 * @param <T>
 * @param <ID>
 */
public interface AbstractComboJpaDao <T extends EntityCombo<ID>, ID extends Serializable> extends AbstractJpaDao<T,ID>{

}
