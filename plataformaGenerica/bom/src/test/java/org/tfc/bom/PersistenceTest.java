package org.tfc.bom;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersistenceTest extends BomTestGeneric{

	final Logger logger = LoggerFactory.getLogger(PersistenceTest.class);
	
	@Test
	public void inicioPersitence(){
		logger.debug("ECO");
		System.out.println(emf);
	}

}
