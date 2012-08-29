package org.tfc.action;

import org.springframework.validation.DataBinder;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

public class BaseAction extends FormAction{

	
	
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev=super.setupForm(context);
			
		return valdev;
	}

	@Override
	protected void initBinder(RequestContext context, DataBinder binder) {
		super.initBinder(context, binder);
	}

	
	
}
