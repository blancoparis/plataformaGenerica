package org.tfc.action.utils;

import org.tfc.form.core.BaseForm;
import org.tfc.form.subs.ErroresNegocioSubForm;

public class ErroresDbpUtils {
	/**
	 * Se encarga de establecer un error de neogocio
	 * @param form
	 * @param error
	 */
	public static void procesarErrorNegocio(BaseForm form,String mesnajeError){
		ErroresNegocioSubForm error=new ErroresNegocioSubForm();
		error.setMensaje(mesnajeError);
		error.setTitulo("Error:");
		form.getErroresNegocio().add(error);
	}
	
	
}
