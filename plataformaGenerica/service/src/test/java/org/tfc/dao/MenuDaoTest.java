package org.tfc.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.tfc.GenericDaoTest;
import org.tfc.bom.Flujo;
import org.tfc.bom.Menu;


/**
 * 
 * Es el test del dao, para la entidad menu
 * 
 * @author dbp
 *
 */
public class MenuDaoTest extends GenericDaoTest<Menu,Long> {
	@Autowired
	private FlujoDao flujoDao;
	
	@Autowired
	public void setDaoJpa(MenuDao dao) {
		super.setDaoJpa(dao);
	}	
	@Test
	@Transactional
	public void testInserccionDelFlujo(){
		Integer elementosFlujoInicial=flujoDao.findAll().size();
		Menu elemento = new Menu();
		elemento.setDescripcion("Ejemplo");
		elemento.setFlujo(flujoDao.findOne(1L));
		Menu valdev= getDaoJpa().save(elemento);
		Long id=valdev.getId();
		Menu resultado=getDaoJpa().findOne(id);
		assertEquals("Ha variado la tabla de los flujos",elementosFlujoInicial,(Integer)flujoDao.findAll().size());
		getDaoJpa().deleteById(id);
		assertEquals("Ha variado la tabla de los flujos",elementosFlujoInicial,(Integer)flujoDao.findAll().size());
	}
	/**
	 * En este esperamos que al crear un flujo desde fuera nos falle.
	 */
	@Test(expected=IllegalStateException.class)
	@Transactional
	public void testCreacionFlujo(){
		Flujo elemento=new Flujo();
		elemento.setId(2L);
		elemento.setDescripcion("prueba2");
		Menu menu = new Menu();
		menu.setFlujo(elemento);
		Menu valdev=getDaoJpa().save(menu);
		System.out.println("ID->"+valdev.getId());
		Menu resultado=getDaoJpa().findOne(valdev.getId());
		getDaoJpa().getEntityManager().flush();
		//System.out.println("Flujos"+flujoDao.findAll().size());
	}
}
