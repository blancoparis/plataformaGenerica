package org.tfc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Usuario;

/**
 * 
 * Es el test del dao, para la entidad usuario
 * 
 * @author dbp
 *
 */

public class UsuarioServiceTest extends GenericServiceTest<Usuario,Long>{
	@Autowired
	public void setService(UsuarioService service) {
		super.setService(service);
	}
	

}