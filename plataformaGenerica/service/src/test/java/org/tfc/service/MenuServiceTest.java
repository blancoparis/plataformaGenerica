package org.tfc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Menu;
import org.tfc.bom.Menu.TipoMenu;
import org.tfc.exception.DbpException;
import org.tfc.service.impl.MenuServiceImpl.TipoErrorMenu;

/**
 * 
 * Es el test del dao, para la entidad menu
 * 
 * @author dbp
 *
 */

public class MenuServiceTest extends GenericServiceTest<Menu,Long>{
	
	final Logger logger = LoggerFactory.getLogger(MenuServiceTest.class); 
	
	@Autowired
	public FlujoService flujoService;
	
	@Autowired
	public void setService(MenuService service) {
		super.setService(service);
	}
	
	public enum EscenarioValidacionMenu{
		MENU_CORRECTO(1L,TipoErrorMenu.NADA,1L),
		MENU_CORRECTO_VARIOS(1L,TipoErrorMenu.NADA,1L,1L,1l,1L),
		MENU_SIN_NADA(1L,TipoErrorMenu.NADA),
		MENU_CON_HIJO_ERRONEO(1L,TipoErrorMenu.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO,2L),
		MENU_CON_HIJOS_ERRONEOS(1L,TipoErrorMenu.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO,2L,2L),
		MENU_CON_HIJOS_ERRONEOS_MEZCLA_INICIO(1L,TipoErrorMenu.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO,2L,1L,1L),
		MENU_CON_HIJOS_ERRONEOS_MEZCLA_MEDIO(1L,TipoErrorMenu.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO,1L,2L,1L),
		MENU_CON_HIJOS_ERRONEOS_MEZCLA_FIN(1L,TipoErrorMenu.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO,1L,1L,2L),
		;
		private Menu menu;
		private TipoErrorMenu tipo;

		private EscenarioValidacionMenu(Long idMenu,TipoErrorMenu  valdev,Long... hijos ) {
			this.menu=new Menu();
			menu.setId(idMenu);
			menu.setTipo(TipoMenu.FLUJO);
			if(hijos!=null && hijos.length>0){
				menu.setHijos(new HashSet<Menu>());
				Menu hijo=null;
				for(Long idPadre:hijos){
					hijo=new Menu();
					if(idPadre.equals(idMenu)){
						hijo.setPadre(this.menu);
					}else{
						Menu padre=new Menu();
						padre.setId(idPadre);
						hijo.setPadre(padre);
					}
					menu.getHijos().add(hijo);
				}
			}
			this.tipo=valdev;
		}
		
	}
	@Test
	public void testValidacion(){
		for(EscenarioValidacionMenu escenarioValidacionMenu:EscenarioValidacionMenu.values()){
			assertEquals("El escenario "+escenarioValidacionMenu.name()
					,escenarioValidacionMenu.tipo
					,((MenuService)getService()).validarEntradaMenu(escenarioValidacionMenu.menu));
		}
	}
	@Test
	@Transactional
	public void testCrearOpcionDeMenu() throws DbpException{
		Menu opcionFlujo=new Menu();
		opcionFlujo.setFlujo(flujoService.findOne(1L));
		opcionFlujo.setTipo(TipoMenu.FLUJO);
		opcionFlujo.setDescripcion("Ejemplo");
		Menu nodoRaiz=getService().findOne(1L);
		int elementosAntes=nodoRaiz.getHijos().size();
		Menu resultado=((MenuService)getService()).crearOpcionMenu(opcionFlujo);
		nodoRaiz=getService().findOne(1L);
		assertEquals("Elmento",nodoRaiz.getHijos().size(),elementosAntes+1);
		assertTrue("Miramos que el hijo se creado bien",nodoRaiz.getHijos().contains(resultado));
	}
	@Test
	@Transactional
	public void testCrearOpcionMenuFlujo() throws DbpException{
		Menu opcionFlujo=new Menu();
		Menu nodoRaiz=getService().findOne(1L);
		int elementosAntes=nodoRaiz.getHijos().size();
		Menu resultado=((MenuService)getService()).crearOpcionMenu(opcionFlujo,1L);
		nodoRaiz=getService().findOne(1L);
		assertEquals("Elmento",nodoRaiz.getHijos().size(),elementosAntes+1);
		assertTrue("Miramos que el hijo se creado bien",nodoRaiz.getHijos().contains(resultado));
		
	}
	
	@Test
	@Transactional
	public void testSaveError(){
		//for(EscenarioValidacionMenu escenarioValidacionMenu:EscenarioValidacionMenu.values()){
			//procesarElEscenario(escenarioValidacionMenu);//EscenarioValidacionMenu.MENU_CON_HIJO_ERRONEO);
		//}
		procesarElEscenario(EscenarioValidacionMenu.MENU_CON_HIJO_ERRONEO);
	}
	
	private void procesarElEscenario(
			EscenarioValidacionMenu escenarioValidacionMenu) {
		try {
			getService().save(escenarioValidacionMenu.menu);
		} catch (DbpException e) {
			logger.debug("Ha saltado el siguiente error en el escenario [{}] ",escenarioValidacionMenu.name(),e);
			if(escenarioValidacionMenu.tipo.equals(TipoErrorMenu.NADA)){
				fail("En este escenario no se esperaba un error");
			}
			assertEquals("En el escenario "+escenarioValidacionMenu.name()
					,escenarioValidacionMenu.tipo.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO.getMensaje()
					, e.getMessage());
		}
	}
}