package org.tfc.action.utils;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tfc.core.ResultadoTest;
import org.tfc.exception.DbpException;
import org.tfc.form.BaseForm;
import org.tfc.form.enumerados.TipoOperacionResultado;

public class OperacionesDebUtilsTest {

	private static final Logger logger = LoggerFactory.getLogger(OperacionesDebUtilsTest.class);
	
	public static BaseForm form = new BaseForm();
	
	enum EscenarioOperacionesDbpUtils {
		// ERROR FORM
		TODO_NULL(null, null, null, null, ResultadoTest.ERROR_EXCEPTION,
				OperacionesDebUtils.ERROR_FORM),
		FORM_NULL_TIPO_OPERACION_NULL_NULL(null,TipoOperacionResultado.OK,null,null, ResultadoTest.ERROR_EXCEPTION,
				OperacionesDebUtils.ERROR_FORM),
		FORM_NULL_TIPO_OPERACION_DESCRIPCION_NULL(null,TipoOperacionResultado.OK,"D",null, ResultadoTest.ERROR_EXCEPTION,
						OperacionesDebUtils.ERROR_FORM),
		FORM_NULL_TIPO_OPERACION_DESCRIPCION_MENSAJE(null,TipoOperacionResultado.OK,"D","M", ResultadoTest.ERROR_EXCEPTION,
								OperacionesDebUtils.ERROR_FORM),
		// Error tipo de null.
        FORM_TIPO_NULL_NULL_NULL_NULL(OperacionesDebUtilsTest.form,null,null,null,ResultadoTest.ERROR_EXCEPTION,
        		"He encontrado un nulo tipo["+null+"] form ["+OperacionesDebUtilsTest.form+"]"),
        FORM_TIPO_NULL_DESCRIPCION_NULL_NULL(OperacionesDebUtilsTest.form,null,"D",null,ResultadoTest.ERROR_EXCEPTION,
        		"He encontrado un nulo tipo["+null+"] form ["+OperacionesDebUtilsTest.form+"]"),								
        FORM_TIPO_NULL_DESCRIPCION_MENSAJE_NULL(OperacionesDebUtilsTest.form,null,"D","M",ResultadoTest.ERROR_EXCEPTION,
                		"He encontrado un nulo tipo["+null+"] form ["+OperacionesDebUtilsTest.form+"]"),				
   		FORMTNULL_TIPO_OK_NULL_NULL(OperacionesDebUtilsTest.form,TipoOperacionResultado.OK,null,null,ResultadoTest.ERROR_EXCEPTION,
        		"He encontrado un nulo tipo["+null+"] form ["+OperacionesDebUtilsTest.form+"]",true,false),                		
		// tipo validos.
        FORM_TIPO_OK_NULL_NULL(OperacionesDebUtilsTest.form,TipoOperacionResultado.OK,null,null,ResultadoTest.OK,null),        			
        FORM_TIPO_OK_DESRIPCION_NULL(OperacionesDebUtilsTest.form,TipoOperacionResultado.OK,"D",null,ResultadoTest.OK,null),
        FORM_TIPO_OK_DESRIPCION_MENSAJE(OperacionesDebUtilsTest.form,TipoOperacionResultado.OK,"D","M",ResultadoTest.OK,null),

        FORM_TIPO_ERROR_NULL_NULL(OperacionesDebUtilsTest.form,TipoOperacionResultado.ERROR,null,null,ResultadoTest.OK,null),        			
        FORM_TIPO_ERROR_DESRIPCION_NULL(OperacionesDebUtilsTest.form,TipoOperacionResultado.ERROR,"D",null,ResultadoTest.OK,null),
        FORM_TIPO_ERROR_DESRIPCION_MENSAJE(OperacionesDebUtilsTest.form,TipoOperacionResultado.ERROR,"D","M",ResultadoTest.OK,null),
        // Form sin el tipo
        FORM_TIPO_NULL_NULL_NULL(OperacionesDebUtilsTest.form,null,null,null,ResultadoTest.OK,null,false,true),        			
        FORM_TIPO_NULL_DESRIPCION_NULL(OperacionesDebUtilsTest.form,null,"D",null,ResultadoTest.OK,null,false,true),
        FORM_TIPO_NULL_DESRIPCION_MENSAJE(OperacionesDebUtilsTest.form,null,"D","M",ResultadoTest.OK,null,false,true),
        
		;
		BaseForm form;
		TipoOperacionResultado tipoOperacionResultado;
		String descripcion;
		String mensaje;
		ResultadoTest resultadoTest;
		String mensajeError;
		Boolean errorSoloForm;
		Boolean sinTipo;

		private EscenarioOperacionesDbpUtils(BaseForm form,
				TipoOperacionResultado tipoOperacionResultado,
				String descripcion, String mensaje,
				ResultadoTest resultadoTest, String mensajeError) {
			this(form,tipoOperacionResultado,descripcion,mensaje,resultadoTest,mensajeError,false,false);
		}

		private EscenarioOperacionesDbpUtils(BaseForm form,
				TipoOperacionResultado tipoOperacionResultado,
				String descripcion, String mensaje,
				ResultadoTest resultadoTest, String mensajeError,
				Boolean errorSoloForm,Boolean sinTipo) {
			this.form = form;
			this.tipoOperacionResultado = tipoOperacionResultado;
			this.descripcion = descripcion;
			this.mensaje = mensaje;
			this.resultadoTest = resultadoTest;
			this.mensajeError = mensajeError;
			this.errorSoloForm = errorSoloForm;
			this.sinTipo=sinTipo;
		}
		
	}

	@Test
	public void prueba() throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		for (EscenarioOperacionesDbpUtils escenario : EscenarioOperacionesDbpUtils
				.values()) {
			logger.info("INICIO: procesar el escenario [{}]",escenario.name());
			logger.debug("ESCENARIO  mensaje[{}] descriptivo[{}] " ,escenario.mensaje,escenario.descripcion);
			BaseForm resultado=null;
			if(!escenario.sinTipo){
				procesarMensaje(escenario);
				procesarMensajeM(escenario);
				procesarMensajeT(escenario);
				procesarMensajeTM(escenario);
			}
			procesarMensajeDM(escenario);
			logger.info("FIN: procesar el escenario [{}]",escenario.name());
		}
	}


	private void procesarMensaje(EscenarioOperacionesDbpUtils escenario)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		BaseForm resultado;
		try {
			resetearEscenario(escenario);
			resultado=OperacionesDebUtils.procesarMensaje(escenario.form);
			assertEquals(escenario.form.getTipoOperacion().getDescipcion(),resultado.getTextoTipoOperacion());
			assertEquals(escenario.form.getTipoOperacion().getMensajeDescripcion(),resultado.getMensajeTipoOperacion());
			procesarErrorDespuesEjecucion(escenario);
		} catch (DbpException e) {
			procesarException(escenario, e);
		}
	}


	private void procesarMensajeM(EscenarioOperacionesDbpUtils escenario)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		BaseForm resultado;
		try {
			resetearEscenario(escenario);
			logger.debug(" form tipo operacion [{}]",escenario.form!=null?escenario.form.getTipoOperacion():"Form null");
			resultado=OperacionesDebUtils.procesarMensaje(escenario.form,
					escenario.mensaje);
			procesarAssertFTOdescripcion(escenario, resultado);
			procesarAssertMensaje(escenario, resultado);
			procesarErrorDespuesEjecucion(escenario);
		} catch (DbpException e) {
			procesarException(escenario, e);
		}
	}


	private void procesarMensajeT(EscenarioOperacionesDbpUtils escenario)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		BaseForm resultado;
		try {
			resetearEscenario(escenario);
			resultado=OperacionesDebUtils.procesarMensaje(escenario.form,
					escenario.tipoOperacionResultado);
			procesarAssertTOmensaje(escenario, resultado);
			procesarAssertTOdescripcion(escenario, resultado);
			if(!escenario.errorSoloForm){
				procesarErrorDespuesEjecucion(escenario);
			}
		} catch (DbpException e) {
			procesarException(escenario, e);
		}
	}

	private void procesarAssertFTOdescripcion(
			EscenarioOperacionesDbpUtils escenario, BaseForm resultado) {
		logger.debug(" Assert form tipo operacion [{}]",escenario.form!=null?escenario.form.getTipoOperacion():"Form null");
		if(escenario.form!=null && escenario.form.getTipoOperacion()!=null){
			assertEquals("Se espera que sea "+resultado.getMensajeTipoOperacion()
					,escenario.form.getTipoOperacion().getDescipcion(),resultado.getTextoTipoOperacion());
		}else{
			assertNull("Es nulo"
					,resultado.getTextoTipoOperacion());
		}
	}
	
	
	private void procesarAssertFTOmensaje(
			EscenarioOperacionesDbpUtils escenario, BaseForm resultado) {
		logger.debug(" Assert form tipo operacion [{}]",escenario.form!=null?escenario.form.getTipoOperacion():"Form null");
		if(escenario.form!=null && escenario.form.getTipoOperacion()!=null){
			assertEquals("Se espera que sea "+resultado.getMensajeTipoOperacion()
					,escenario.form.getTipoOperacion().getMensajeDescripcion(),resultado.getMensajeTipoOperacion());
		}else{
			assertNull("Es nulo"
					,resultado.getTextoTipoOperacion());
		}
	}
	
	private void procesarAssertTOmensaje(
			EscenarioOperacionesDbpUtils escenario, BaseForm resultado) {
		if(escenario.tipoOperacionResultado!=null){
			assertEquals(escenario.tipoOperacionResultado.getMensajeDescripcion(),resultado.getMensajeTipoOperacion());
		}else{
			assertNull(resultado.getTextoTipoOperacion());
		}
	}


	private void procesarMensajeTM(EscenarioOperacionesDbpUtils escenario)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		BaseForm resultado;
		try {
			resetearEscenario(escenario);
			resultado=OperacionesDebUtils.procesarMensaje(escenario.form,
					escenario.tipoOperacionResultado, escenario.mensaje);
			procesarAssertTOdescripcion(escenario, resultado);
			procesarAssertMensaje(escenario, resultado);

			if(!escenario.errorSoloForm){
				procesarErrorDespuesEjecucion(escenario);
			}
		} catch (DbpException e) {
			procesarException(escenario, e);
		}
	}


	private void procesarAssertTOdescripcion(
			EscenarioOperacionesDbpUtils escenario, BaseForm resultado) {
		if(escenario.tipoOperacionResultado!=null){
			assertEquals(escenario.tipoOperacionResultado.getDescipcion(),resultado.getTextoTipoOperacion());
		}else{
			assertNull(resultado.getTextoTipoOperacion());
		}
	}
	
	
	private void procesarMensajeDM(EscenarioOperacionesDbpUtils escenario
			) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		BaseForm resultado;
		try {
			resetearEscenario(escenario);
			
			resultado=OperacionesDebUtils.procesarMensaje(escenario.form,
					escenario.descripcion, escenario.mensaje);
			
			procesarAssertMensaje(escenario, resultado);
			procesarAssertDescripcion(escenario,resultado);

		} catch (DbpException e) {
			procesarException(escenario, e);
		}
	}
	private void resetearEscenario(EscenarioOperacionesDbpUtils escenario) {
		if(escenario.form!=null){
			if(!escenario.errorSoloForm && escenario.form!=null){
				escenario.form.setTipoOperacion(escenario.tipoOperacionResultado);
			}
			escenario.form.setMensajeTipoOperacion(null);
			escenario.form.setTextoTipoOperacion(null);
		}
	}
	private void procesarAssertDescripcion(EscenarioOperacionesDbpUtils escenario,
			BaseForm form) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		logger.debug(" form [{}] " ,BeanUtils.describe(form));
		if(escenario.descripcion!=null){
			
			assertEquals("Escenario --> "+escenario.name()
					+" Escenario ["+escenario.descripcion+"] form["+form.getTextoTipoOperacion() + "]"
					,escenario.descripcion,form.getTextoTipoOperacion());
		}else{
			assertNull("Escenario --> "+escenario.name(),form.getTextoTipoOperacion());
		}
		
	}
	
	private void procesarAssertMensaje(EscenarioOperacionesDbpUtils escenario,
			BaseForm form) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		logger.debug(" form [{}] " ,BeanUtils.describe(form));
		if(escenario.mensaje!=null){
			
			assertEquals("Escenario --> "+escenario.name()
					+" Escenario ["+escenario.mensaje+"] form["+form.getMensajeTipoOperacion() + "]"
					,escenario.mensaje,form.getMensajeTipoOperacion());
		}else{
			assertNull("Escenario --> "+escenario.name(),form.getMensajeTipoOperacion());
		}
	}

	private void procesarErrorDespuesEjecucion(
			EscenarioOperacionesDbpUtils escenario) {
		if(escenario.resultadoTest == ResultadoTest.ERROR_EXCEPTION){
			fail("Se esperaba un error en el escenario ["+escenario.name()+"]");
		}
	}

	private void procesarException(EscenarioOperacionesDbpUtils escenario,
			DbpException e) {
		if (escenario.resultadoTest == ResultadoTest.ERROR_EXCEPTION) {
			assertEquals("Intentar procesar el escenario",
					escenario.mensajeError, e.getMessage());
		} else {
			fail("Error a la escepción [" + e.getMessage() + "]en el escenario ["+escenario.name()+"]");
		}
	}

}
