package org.tfc.service.impl;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tfc.bom.Menu;
import org.tfc.dao.MenuDao;
import org.tfc.exception.DbpException;
import org.tfc.service.MenuService;

@Repository(value = "menuService")
public class MenuServiceImpl 
	extends AbstractServiceImpl<Menu, Long>
	implements MenuService{
	final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	public static Long ID_NODO_RAIZ=1L;
	
	private MenuDao dao;
	@Autowired
	private MenuServiceImpl( MenuDao  dao) {
		super(dao);
		this.dao=dao;
	}
	
	public enum TipoErrorMenu{
		ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO("error.elHijoNoEstaBienAsociadoAlPadre.mensaje"),
		NADA(null),
		;
		String mensaje;

		private TipoErrorMenu(String mensaje) {
			this.mensaje = mensaje;
		}

		public String getMensaje() {
			return mensaje;
		}
		
	}
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
	public TipoErrorMenu  validarEntradaMenu(Menu menu){
		TipoErrorMenu valdev=TipoErrorMenu.NADA;
		if(menu!=null){
			if(menu.getHijos()!=null && menu.getHijos().size()>0){
				boolean error=false;
				for(Menu hijo:menu.getHijos()){
					if(hijo.getPadre()==null || !hijo.getPadre().equals(menu)){
						logger.error("El hijo de [{}]  no esta asociado correcatmente con el padre [{}]"
								,hijo!=null?hijo.getId():hijo
								,menu!=null?menu.getId():menu);
						logger.error("El hijo tenia asociado al siguiente padre [{}]"
								,hijo!=null?hijo.getPadre():hijo);
						error=true;
						break;
					}
				}
				if(error){
					valdev=TipoErrorMenu.ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO;
				}
			}
		}
		return valdev;
	}
	@Override
	@Transactional(rollbackFor=DbpException.class)
	public Menu save(Menu entity) throws DbpException {
		TipoErrorMenu tipoErrorMenu=validarEntradaMenu(entity);
		if(!tipoErrorMenu.equals(TipoErrorMenu.NADA)){
			throw new DbpException(tipoErrorMenu.mensaje);
		}else{
			return super.save(entity);
		}
	}
	@Override
	@Transactional(rollbackFor=DbpException.class)
	public Menu update(Menu entity) throws DbpException {
		TipoErrorMenu tipoErrorMenu=validarEntradaMenu(entity);
		if(!tipoErrorMenu.equals(TipoErrorMenu.NADA)){
			throw new DbpException(tipoErrorMenu.mensaje);
		}else{
			return super.update(entity);
		}
	}
	
	/**
	 * SE encarga de crear una opcion de menu.
	 *   - Se cuelgan del nodo raiz.
	 * 
	 * @param menu
	 * @return
	 * @throws DbpException 
	 */
	@Transactional(rollbackFor=DbpException.class)
	public Menu crearOpcionMenu(Menu menu) throws DbpException{
		Menu valdev=save(menu);
		return addDescendiente(ID_NODO_RAIZ, valdev);
	}
	
	/**
	 * 
	 * Se encarga de añadir un descendiente al hijo.
	 * 
	 * @param idPadre
	 * @param menu
	 * @return
	 * @throws DbpException
	 */
	@Transactional(rollbackFor=DbpException.class)
	public Menu addDescendiente(Long idPadre,Menu menu) throws DbpException{
		Menu valdev=menu;
		Menu nodoRaiz = findOne(idPadre);
		menu.setPadre(nodoRaiz);
		if(nodoRaiz.getHijos()==null){
			nodoRaiz.setHijos(new HashSet<Menu>());
		}
		nodoRaiz.getHijos().add(valdev);
		update(nodoRaiz);
		return valdev;
		
	}
}