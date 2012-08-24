package org.tfc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericDaoTest;
import org.tfc.bom.Prueba;

/**
 * 
 * Es el test del dao, para la entidad prueba
 * 
 * @author dbp
 *
 */
public class PruebaDaoTest extends GenericDaoTest<Prueba,Long> {
	
	@Autowired
	public void setDaoJpa(PruebaDao dao) {
		super.setDaoJpa(dao);
	}	
	
}
