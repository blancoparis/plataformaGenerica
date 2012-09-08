package org.tfc.action;

import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.action.utils.ErroresDbpUtils;
import org.tfc.form.PruebaForm;

public class PruebaAction extends BaseAction<PruebaForm>{

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
			operacionCorrecta(context);
		}
		return resolucionEvent(context);
	}
	
}
