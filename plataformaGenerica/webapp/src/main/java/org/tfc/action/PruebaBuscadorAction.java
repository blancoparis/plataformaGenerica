package org.tfc.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.tfc.bom.Prueba;
import org.tfc.form.PruebaBuscadorForm;
import org.tfc.form.subs.TablaPruebaBuscadorSubForm;
import org.tfc.parser.PruebaBuscadorParser;
import org.tfc.service.PruebaService;
/**
 * 
 * Es el buscador.
 * 
 * @author David Blanco París
 *
 */
public class PruebaBuscadorAction extends BuscadorBaseAction<PruebaBuscadorForm,TablaPruebaBuscadorSubForm,Long,Prueba>{
	
	@Autowired
	public void setService(PruebaService service) {
		super.setService(service);
	}

	@Autowired
	public void setBuscadorParser(PruebaBuscadorParser parser) {
		super.setBuscadorParser(parser);
	}

	
	
	
}
