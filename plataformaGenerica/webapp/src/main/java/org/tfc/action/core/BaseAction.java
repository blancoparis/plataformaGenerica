package org.tfc.action.core;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.DataBinder;
import org.springframework.webflow.action.FormAction;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.action.utils.OperacionesDebUtils;
import org.tfc.exception.DbpException;
import org.tfc.form.core.BaseForm;
import org.tfc.form.enumerados.TipoOperacionResultado;
import org.tfc.form.subs.ErroresNegocioSubForm;

public class BaseAction<F extends BaseForm> extends FormAction {

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev = super.setupForm(context);
		@SuppressWarnings("unchecked")
		F form = (F) getFormObject(context);
		form.setErroresNegocio(new ArrayList<ErroresNegocioSubForm>());
		return valdev;
	}

	@Override
	protected void initBinder(RequestContext context, DataBinder binder) {
		super.initBinder(context, binder);
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	     dateFormat.setLenient(false);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@SuppressWarnings("unchecked")
	protected Event resolucionEvent(RequestContext context) throws Exception {
		return resolucionEvent((F) getFormObject(context));
	}

	protected Event resolucionEvent(F form) {
		return resolucionEvent(success(), form);
	}

	protected Event resolucionEvent(Event event, F form) {
		if (form != null && form.getErroresNegocio() != null
				&& form.getErroresNegocio().size() > 0) {
			return error();
		} else {
			return event;
		}
	}
	/**
	 * Le indicamos que la operación se ha realizado correctamente. 
	 * 
	 * @param context	
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws DbpException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void operacionCorrecta(RequestContext context)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, DbpException, Exception {
		OperacionesDebUtils.procesarMensaje((F) getFormObject(context),
				TipoOperacionResultado.OK);
	}
	/**
	 * Le indicamos que la operación se ha realizado correctamente.
	 * @param context
	 * @param mensaje
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws DbpException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void operacionCorrecta(RequestContext context, String mensaje)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, DbpException, Exception {
		OperacionesDebUtils.procesarMensaje((F) getFormObject(context),
				TipoOperacionResultado.OK,mensaje);

	}
	
	/**
	 * Le indicamos que la operación se ha producido un error
	 * @param context
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws DbpException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void operacionError(RequestContext context)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, DbpException, Exception {
		OperacionesDebUtils.procesarMensaje((F) getFormObject(context),
				TipoOperacionResultado.ERROR);
	}
	
	/**
	 * Le indicamos que la operación ha sido erronea.
	 * @param context
	 * @param mensaje
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws DbpException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void operacionError(RequestContext context,String mensaje)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, DbpException, Exception {
		OperacionesDebUtils.procesarMensaje((F) getFormObject(context),
				TipoOperacionResultado.ERROR,mensaje);
	}
	/**
	 * Le indicamos que la operación del descripcion y mensaje.
	 * @param context	
	 * @param descripcion	Es la descripción del tipo de operación.
	 * @param mensaje		Es el mensaje que vamos a poner.
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws DbpException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	protected void operacionDefinida(RequestContext context,String descripcion,String mensaje) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, DbpException, Exception{
		OperacionesDebUtils.procesarMensaje((F) getFormObject(context),
				descripcion,mensaje);
		
	}
}
