package org.tfc.controller.json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tfc.bom.Flujo;
import org.tfc.service.FlujoService;

@Controller
@RequestMapping("/flujo")
public class FlujoJsonController extends AbstractComboJsonController<Flujo> {
	
	@Autowired
	public void setService(FlujoService service) {
		super.setService(service);
	}

}
