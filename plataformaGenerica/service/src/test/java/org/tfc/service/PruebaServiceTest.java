package org.tfc.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Prueba;
import org.tfc.exception.DbpException;

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
	@Transactional
	@Test
	public void testear() throws DbpException{
		Prueba elemento = new Prueba();
		Prueba resultado=getService().save(elemento);
		System.out.println("Resultado "+ resultado.getId());
		System.out.println("Eco");
		resultado=getService().findOne(resultado.getId());
		System.out.println("Resultado "+ resultado.getId());
	}
}