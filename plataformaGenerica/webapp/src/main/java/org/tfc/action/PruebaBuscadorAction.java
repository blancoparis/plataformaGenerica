package org.tfc.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.action.core.BuscadorBaseAction;
import org.tfc.bom.Prueba;
import org.tfc.form.PruebaBuscadorForm;
import org.tfc.form.core.json.OperacionResultadoJson;
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

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		 //((HttpServletRequest)context.getExternalContext().getNativeRequest()).setAttribute("jsonResultado", "prueba");
		OperacionResultadoJson operJson = new OperacionResultadoJson();
		operJson.setDescripcion("Periquito");
		PruebaBuscadorForm form =(PruebaBuscadorForm)getFormObject(context);
		form.setOperacionResultadoJson(operJson);
		return super.setupForm(context);
	}

	
	
	
}
