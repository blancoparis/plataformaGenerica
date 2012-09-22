package org.tfc.service;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.GenericServiceTest;
import org.tfc.bom.Menu;
import org.tfc.service.impl.MenuServiceImpl.TipoErrorMenu;

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
	
}