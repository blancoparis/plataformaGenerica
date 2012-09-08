package org.tfc.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.action.utils.ErroresDbpUtils;
import org.tfc.bom.Prueba;
import org.tfc.form.PruebaForm;
import org.tfc.parser.PruebaParser;
import org.tfc.service.PruebaService;

public class PruebaAction extends BaseAction<PruebaForm>{

	@Autowired
	private PruebaService service;
	@Autowired
	private PruebaParser pruebaParser;
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev= super.setupForm(context);
		PruebaForm form = (PruebaForm)getFormObject(context);
		form.setDescripcion("Inicio setup");
		return valdev;
	}


	public Event confirmar(RequestContext context) throws Exception {
		PruebaForm form = (PruebaForm)getFormObject(context);
		if(form.getDescripcion().equals("error")){
			ErroresDbpUtils.procesarErrorNegocio(form, "Prueba de error");
		}else{
			Prueba prueba= pruebaParser.getEntity(form);
			prueba=service.save(prueba);
			operacionCorrecta(context);
		}
		return resolucionEvent(context);
	}
	
}
