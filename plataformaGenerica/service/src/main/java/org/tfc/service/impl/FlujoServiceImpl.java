package org.tfc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tfc.bom.Flujo;
import org.tfc.dao.FlujoDao;
import org.tfc.service.FlujoService;

@Repository(value = "flujoService")
public class FlujoServiceImpl 
	extends AbstractComboServiceImpl<Flujo, Long>
	implements FlujoService{

	private FlujoDao dao;
	@Autowired
	private FlujoServiceImpl( FlujoDao  dao) {
		super(dao);
		this.dao=dao;
	}
}