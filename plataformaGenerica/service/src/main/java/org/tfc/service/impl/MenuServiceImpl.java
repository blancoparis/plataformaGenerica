package org.tfc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.tfc.bom.Menu;
import org.tfc.dao.MenuDao;
import org.tfc.service.MenuService;

@Repository(value = "menuService")
public class MenuServiceImpl 
	extends AbstractServiceImpl<Menu, Long>
	implements MenuService{
	final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	private MenuDao dao;
	@Autowired
	private MenuServiceImpl( MenuDao  dao) {
		super(dao);
		this.dao=dao;
	}
	
	public enum TipoErrorMenu{
		ERROR_EL_PADRE_NO_CORRESPONDE_CON_EL_HIJO,
		NADA,
		;
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
}