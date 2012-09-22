package org.tfc.service;

import org.tfc.bom.Menu;
import org.tfc.service.impl.MenuServiceImpl.TipoErrorMenu;
/**
 * Interfaz para definir las operaciones de la entidad menu.
 * @author dbp
 *
 */

public interface MenuService extends AbstractService<Menu, Long>{
	/**
	 * Se encarga ce controlar la siguientes operaciones:
	 *  
	 *  <ul>
	 *  	<li>Controla que todos los hijos esten correctamente colocado con su padre.</li>
	 *  </ul>
	 *  
	 * @param menu	Es el menu que vamos a validar.
	 * 
	 * @return Se retorna si hemos tenido, algun tipo de error.
	 * 
	 */
	public TipoErrorMenu  validarEntradaMenu(Menu menu);
}