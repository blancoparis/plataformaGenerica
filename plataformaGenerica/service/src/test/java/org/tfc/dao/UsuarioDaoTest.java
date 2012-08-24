package org.tfc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericDaoTest;
import org.tfc.bom.Usuario;

/**
 * 
 * Es el test del dao, para la entidad usuario
 * 
 * @author dbp
 *
 */
public class UsuarioDaoTest extends GenericDaoTest<Usuario,Long> {
	
	@Autowired
	public void setDaoJpa(UsuarioDao dao) {
		super.setDaoJpa(dao);
	}	
	
}
