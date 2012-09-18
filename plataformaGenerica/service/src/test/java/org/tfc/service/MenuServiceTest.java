package org.tfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Menu;

/**
 * 
 * Es el test del dao, para la entidad menu
 * 
 * @author dbp
 *
 */

public class MenuServiceTest extends GenericServiceTest<Menu,Long>{
	@Autowired
	public void setService(MenuService service) {
		super.setService(service);
	}
	

}