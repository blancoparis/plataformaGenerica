package org.tfc.action;

import java.util.ArrayList;

import org.springframework.validation.DataBinder;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.form.BaseForm;
import org.tfc.form.subs.ErroresNegocioSubForm;

public class BaseAction<F extends BaseForm> extends FormAction{

	
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev=super.setupForm(context);
		F form=(F)getFormObject(context);
		form.setErroresNegocio(new ArrayList<ErroresNegocioSubForm>());
		return valdev;
	}

	@Override
	protected void initBinder(RequestContext context, DataBinder binder) {
		super.initBinder(context, binder);
	}

	
	protected Event resolucionEvent(RequestContext context) throws Exception{
		return resolucionEvent((F)getFormObject(context));
	}
	
	protected Event resolucionEvent(F form){
		return resolucionEvent(success(), form);
	}
	
	protected Event resolucionEvent(Event event,F form){
		if(form!=null 
				&& form.getErroresNegocio()!=null
				&& form.getErroresNegocio().size()>0){
			return error();
		}else{
			return event;
		}
	}

	
}
