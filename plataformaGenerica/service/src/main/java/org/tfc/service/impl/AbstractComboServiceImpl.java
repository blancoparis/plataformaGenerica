package org.tfc.service.impl;

import java.io.Serializable;

import org.tfc.EntityCombo;
import org.tfc.dao.AbstractComboJpaDao;

public  class AbstractComboServiceImpl <T extends EntityCombo<ID>, ID extends Serializable>
extends AbstractServiceImpl<T,ID>{

	public AbstractComboServiceImpl(AbstractComboJpaDao<T, ID> dao) {
		super(dao);
	}

}
