package org.tfc.service;

import org.tfc.bom.Menu;
import org.tfc.bom.Menu.TipoMenu;
import org.tfc.exception.DbpException;
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
	public Menu crearOpcionMenu(Menu menu) throws DbpException;
	public Menu crearOpcionMenu(Menu menu,Long idFlujo) throws DbpException;
	public Menu crearOpcionMenu(Menu menu,TipoMenu tipo) throws DbpException;
	/**
	 * 
	 * Se encarga de añadir un descendiente al hijo.
	 * 
	 * @param idPadre	Es el idPadre al que vamos adjuntar el hijo.
	 * @param menu		Es la opción de menu que vamos a crear.
	 * @return
	 * @throws DbpException
	 */
	public Menu addDescendiente(Long idPadre,Menu menu) throws DbpException;
	/**
	 * Lo que hace es volver a colgar la opción de menu del nodo raiz.
	 * @param menu
	 * @return
	 * @throws DbpException
	 */
	public Menu eliminarEntradaMenu(Menu menu)throws DbpException;
	
	
}