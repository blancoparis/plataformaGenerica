package org.tfc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tfc.bom.Prueba;
import org.tfc.dao.PruebaDao;
import org.tfc.service.PruebaService;

@Repository(value = "pruebaService")
public class PruebaServiceImpl 
	extends AbstractServiceImpl<Prueba, Long>
	implements PruebaService{

	private PruebaDao dao;
	@Autowired
	private PruebaServiceImpl( PruebaDao  dao) {
		super(dao);
		this.dao=dao;
	}
}