package org.tfc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InicioController {

	@RequestMapping("inicioAction")
	public ModelAndView show() {
	    return new ModelAndView("welcomeView");
	}
	@RequestMapping("plantillaFormularioAction")
	public ModelAndView plantillaFormulario(){
	    return new ModelAndView("plantillaFormularioView");
	}

	@RequestMapping("plantillaFormularioConsultaAction")
	public ModelAndView plantillaFormularioConsulta(){
		ModelAndView valdev =new ModelAndView("plantillaFormularioView");
		valdev.addObject("readonly", true);
	    return valdev;
	}

	
	@RequestMapping("plantillaBuscadorAction")
	public ModelAndView plantillaBuscador(){
	    return new ModelAndView("plantillaBuscadorView");
	}
}
