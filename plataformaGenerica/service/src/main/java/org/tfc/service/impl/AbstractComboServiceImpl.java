package org.tfc.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.tfc.EntityCombo;
import org.tfc.dao.AbstractComboJpaDao;
import org.tfc.service.AbstractComboService;

public  class AbstractComboServiceImpl <T extends EntityCombo<ID>, ID extends Serializable>
extends AbstractServiceImpl<T,ID> implements AbstractComboService<T, ID>{

	public AbstractComboServiceImpl(AbstractComboJpaDao<T, ID> dao) {
		super(dao);
	}
	@Transactional(readOnly=true)
	public List<T> findAllOrder(){
		return((AbstractComboJpaDao<T, ID>)this.dao).findAllOrder();
	}
}
