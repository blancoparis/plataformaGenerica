package org.tfc.action.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tfc.exception.DbpException;
import org.tfc.form.core.BaseForm;
import org.tfc.form.enumerados.TipoOperacionResultado;

/**
 * 
 * Es donde procesamos los mensajes de tipo de operación.
 * 
 * @author David Blanco París
 *
 */
public class OperacionesDebUtils {
	
	public static final String ERROR_FORM = "Es necesario que exista el objeto form, para poder pasar la información";
	private static final Logger logger = LoggerFactory.getLogger(OperacionesDebUtils.class);
	
	/**
	 * 
	 * Se encarga de cargar en el objeto formulario la información. 
	 * 
	 * @param form  Es Objeto de la vista con el que vamos a trabajar.
	 * @param mensaje Es el mensaje del texto.
	 * @return
	 * @throws DbpException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static <F extends BaseForm> F procesarMensaje(F form,String mensaje) throws DbpException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return procesarMensaje(form,form!=null?form.getTipoOperacion():null,mensaje);
	}
	/**
	 * 
	 * Se encarga de cargar en el objeto formulario la información. 
	 * 
	 * @param form	 Es Objeto de la vista con el que vamos a trabajar.
	 * @return
	 * @throws DbpException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static <F extends BaseForm> F procesarMensaje(F form) throws DbpException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		return procesarMensaje(form,form!=null?form.getTipoOperacion():null);
	}
	
	/**
	 * 
	 * Se encarga de cargar en el objeto formulario la información.  
	 *  
	 * @param form Es Objeto de la vista con el que vamos a trabajar.
	 * @param tipo El tipo de operación con el que vamos a trabajar
	 * @param mensaje	Es el mensaje de la operación.
	 * @return
	 * @throws DbpException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static <F extends BaseForm> F procesarMensaje(F form,TipoOperacionResultado tipo,String mensaje) throws DbpException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		establecerElTipoDeOperacion(form, tipo);
		return procesarMensaje(form,tipo.getDescipcion(),mensaje);
	}
	
	/**
	 * 
	 * Se encarga de cargar en el objeto formulario la información. 
	 * 
	 * @param form Es Objeto de la vista con el que vamos a trabajar.
	 * @param tipo El tipo de operación con el que vamos a trabajar
	 * @return
	 * @throws DbpException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static <F extends BaseForm> F procesarMensaje(F form,TipoOperacionResultado tipo) throws DbpException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		establecerElTipoDeOperacion(form, tipo);
		return procesarMensaje(form,tipo.getDescipcion(),tipo.getMensajeDescripcion());
	}
	
	/**
	 *
	 * Se encarga de cargar en el objeto formulario la información.
	 * 
	 * @param form	Es Objeto de la vista con el que vamos a trabajar.
	 * @param descripcion	La descipción de la operación.
	 * @param mensaje	El mensaje explicativo de la operación.
	 * @return
	 * @throws DbpException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static <F extends BaseForm> F procesarMensaje(F form
			,String descripcion,String mensaje) throws DbpException, IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		if(form!=null){
			logger.debug(" Descripcion [{}] [{}]",descripcion,mensaje);
			form.setTextoTipoOperacion(descripcion);
			form.setMensajeTipoOperacion(mensaje);
			logger.debug(" form [{}] " ,BeanUtils.describe(form));
		}else{
			procesarError(ERROR_FORM);
		}
		return form;
	}

	/**
	 * Se encarga de establecer el tipo de operación y controla que no es nulo.
	 * 
	 * @param form 	Es Objeto de la vista con el que vamos a trabajar.
	 * @param tipo Es el tipo de operacion con el que vamos a trabajar.
	 * @throws DbpException
	 */
	private static <F extends BaseForm> void establecerElTipoDeOperacion(
			F form, TipoOperacionResultado tipo) throws DbpException {
		if(tipo!=null && form !=null){
			form.setTipoOperacion(tipo);
		}else{
			if(form==null){
				procesarError(ERROR_FORM);
			}else{
				procesarError("He encontrado un nulo tipo["+tipo+"] form ["+form+"]");
			}
		}
	}
	/**
	 * Se encarga de procesar el error
	 * @param error
	 * @throws DbpException
	 */
	private static void procesarError(String error) throws DbpException {
		logger.error(error);
		throw new DbpException(error);
	}

}
