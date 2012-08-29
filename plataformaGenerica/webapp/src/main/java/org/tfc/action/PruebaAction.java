package org.tfc.action;

import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.form.PruebaForm;

public class PruebaAction extends BaseAction{

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev= super.setupForm(context);
		PruebaForm form = (PruebaForm)getFormObject(context);
		form.setDescripcion("Inicio setup");
		return valdev;
	}

	
	
	@Override
	public Event bind(RequestContext context) throws Exception {
		System.out.println("BIND");
		return super.bind(context);
	}



	public Event confirmar(RequestContext context) throws Exception {
		PruebaForm form = (PruebaForm)getFormObject(context);
		System.out.println("Entro"+form.getDescripcion());
		return success();
	}
	
}
