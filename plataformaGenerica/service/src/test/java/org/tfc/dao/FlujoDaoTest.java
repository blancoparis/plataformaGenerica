package org.tfc.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericDaoTest;
import org.tfc.bom.Flujo;

/**
 * 
 * Es el test del dao, para la entidad flujo
 * 
 * @author dbp
 *
 */
public class FlujoDaoTest extends GenericDaoTest<Flujo,Long> {
	
	
	
	public FlujoDaoTest() {
		super(false);
	}

	@Autowired
	public void setDaoJpa(FlujoDao dao) {
		super.setDaoJpa(dao);
	}	
	@Test
	public void testFlujo(){
		assertEquals("Se esperan encontra el número de flujos",1,getDaoJpa().findAll().size());
	}
	
}
