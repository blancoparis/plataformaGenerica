package org.tfc.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericDaoTest;
import org.tfc.bom.Flujo;
import org.tfc.bom.Menu;
import org.tfc.bom.Menu.TipoMenu;


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
	
	
	
	
	public MenuDaoTest() {
		super(false);
	}




	@Test
	public void testInserccionDelFlujo(){
		Integer elementosFlujoInicial=flujoDao.findAll().size();
		Menu elemento = new Menu();
		elemento.setDescripcion("Ejemplo");
		elemento.setFlujo(flujoDao.findOne(1L));
		elemento.setTipo(TipoMenu.FLUJO);
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
	public void testCreacionFlujo(){
		Flujo elemento=new Flujo();
		elemento.setId(2L);
		elemento.setDescripcion("prueba2");
		Menu menu = new Menu();
		menu.setFlujo(elemento);
		menu.setTipo(TipoMenu.FLUJO);
		Menu valdev=getDaoJpa().save(menu);
		System.out.println("ID->"+valdev.getId());
		Menu resultado=getDaoJpa().findOne(valdev.getId());
		getDaoJpa().getEntityManager().flush();
		//System.out.println("Flujos"+flujoDao.findAll().size());
	}

	@Ignore
	@Test
	public void testCrearMenuDesdeMemoria(){
		Menu padre = crearMenuBasico();
	}
	/**
	 * 
	 * Quitamos el hijo del padre.
	 * Actualizamos el padre.
	 * Y borramos el hijo.
	 * 
	 */
	@Ignore
	@Test
	public void testEliminarMenu(){
		Menu padre = crearMenuBasico();
		Long idPadre=padre.getId();
		Long idHijo=padre.getHijos().toArray(new Menu[0])[0].getId();
		padre.setHijos(null);
		getDaoJpa().update(padre);
		getDaoJpa().deleteById(idHijo);
		assertEquals(getDaoJpa().findAll().size(), 1);
		getDaoJpa().getEntityManager().flush();
		/*padre.setHijos(null);
		getDaoJpa().update(padre);
		assertEquals(getDaoJpa().findAll().size(), 2);*/
	}
	
	private Menu crearMenuBasico() {
		assertEquals("Se esperan 0 nodos",getDaoJpa().findAll().size(),0);
		Menu hijo1 = crearHijo();
		Menu elemento = new Menu();
		elemento.setDescripcion("Padre");
		elemento.setFlujo(flujoDao.findOne(1L));
		elemento.setHijos(new HashSet<Menu>());	
		elemento.setTipo(TipoMenu.FLUJO);
		hijo1.setPadre(elemento);
		elemento.getHijos().add(hijo1);
		getDaoJpa().save(elemento);
		Long idPadre = elemento.getId();
		getDaoJpa().getEntityManager().flush();	
		Menu padre = getDaoJpa().findOne(idPadre);
		assertEquals("Se esperan 2 nodos",getDaoJpa().findAll().size(),2);
		assertEquals("Tiene un hijo",padre.getHijos().size(),1);
		for(Menu hijo:padre.getHijos()){
			assertNotNull(hijo.getPadre());
			assertEquals(hijo.getPadre().getId(),padre.getId());
		}
		return padre;
	}
	
	private Menu crearHijo() {
		Menu hijo1 = new Menu();
		hijo1.setDescripcion("h1");
		hijo1.setFlujo(flujoDao.findOne(1L));
		hijo1.setTipo(TipoMenu.FLUJO);
		return hijo1;
	}
}
