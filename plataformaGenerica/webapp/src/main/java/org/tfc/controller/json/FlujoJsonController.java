package org.tfc.controller.json;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tfc.form.core.json.ElementoListaJsonForm;
import org.tfc.form.core.json.ListaFormJson;

@Controller

public class FlujoJsonController {

	@RequestMapping("/flujoJson")
	public @ResponseBody  ListaFormJson lista(){
			ListaFormJson json=new ListaFormJson();
			json.setDescripcion("perico");
			json.setElementos(new ArrayList<ElementoListaJsonForm>());
			ElementoListaJsonForm item = new ElementoListaJsonForm();
			item.setId(1L);
			item.setDescripcion("elemento 1");
			json.getElementos().add(item);
			item = new ElementoListaJsonForm();
			item.setId(2L);
			item.setDescripcion("Elemento 2");
			json.getElementos().add(item);
			return json;
	}
}
