package org.tfc.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.bom.Prueba;
import org.tfc.form.PruebaForm;
import org.tfc.parser.PruebaParser;
import org.tfc.service.PruebaService;

public class PruebaAction extends OperacionBaseAction<PruebaForm,Long,Prueba>{
	
	@Autowired
	public void setService(PruebaService service) {
		super.setService(service);
	}

	@Autowired
	public void setParser(PruebaParser parser) {
		super.setParser(parser);
	}
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev= super.setupForm(context);
		return valdev;
	}
	
}
