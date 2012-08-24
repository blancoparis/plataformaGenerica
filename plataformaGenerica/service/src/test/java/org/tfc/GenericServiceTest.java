package org.tfc;

import java.io.Serializable;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tfc.service.AbstractService;

public abstract class GenericServiceTest <T extends EntityBD<ID>, ID extends Serializable>
extends ServiceTest{

	// Logger.
	private static final Logger logger = LoggerFactory
			.getLogger(GenericServiceTest.class);
	private AbstractService<T,ID> service;

	public AbstractService<T, ID> getService() {
		return service;
	}

	public void setService(AbstractService<T, ID> service) {
		this.service = service;
	}

	@Test
	public void testEstaContenedor(){
		logger.debug("Prueba para validar que el service existe y se crea bien en el contenedor.");
		assertNotNull("No existe el servicio",service);
	}
	
}
