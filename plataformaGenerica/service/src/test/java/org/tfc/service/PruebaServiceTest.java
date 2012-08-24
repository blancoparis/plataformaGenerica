package org.tfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Prueba;

/**
 * 
 * Es el test del dao, para la entidad prueba
 * 
 * @author dbp
 *
 */

public class PruebaServiceTest extends GenericServiceTest<Prueba,Long>{
	@Autowired
	public void setService(PruebaService service) {
		super.setService(service);
	}
	

}