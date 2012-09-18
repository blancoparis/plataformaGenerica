package org.tfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Flujo;

/**
 * 
 * Es el test del dao, para la entidad flujo
 * 
 * @author dbp
 *
 */

public class FlujoServiceTest extends GenericServiceTest<Flujo,Long>{
	@Autowired
	public void setService(FlujoService service) {
		super.setService(service);
	}
	

}