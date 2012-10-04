package org.tfc.controller.json;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tfc.EntityCombo;
import org.tfc.form.core.json.ElementoListaJsonForm;
import org.tfc.form.core.json.ListaFormJson;
import org.tfc.service.AbstractComboService;

public abstract class AbstractComboJsonController <T extends EntityCombo<Long>>{

	private AbstractComboService<T,Long> service;
	
	public AbstractComboJsonController() {
		super();
		
	}

	@RequestMapping("/json/{tipo}/lista")
	public @ResponseBody  ListaFormJson lista(@PathVariable String tipo) throws Exception{
		ListaFormJson json=new ListaFormJson();
		json.setElementos(new ArrayList<ElementoListaJsonForm>());
		ElementoListaJsonForm item = null;
		for(T elemento: this.getService().findAll()){
			item = new ElementoListaJsonForm();
			item.setId(elemento.getId());
			item.setDescripcion(elemento.getDescripcion());
			json.getElementos().add(item);
		}
		System.out.println(" El tipo "+tipo);
		return json;
	}
	
	public AbstractComboService<T, Long> getService() {
		return service;
	}

	public void setService(AbstractComboService<T, Long> service) {
		this.service = service;
	}

	
	
}