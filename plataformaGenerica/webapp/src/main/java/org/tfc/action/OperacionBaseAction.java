package org.tfc.action;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.EntityBD;
import org.tfc.exception.DbpException;
import org.tfc.form.OperacionBaseForm;
import org.tfc.form.enumerados.TipoOperacionCrud;
import org.tfc.parser.AbstractParser;
import org.tfc.service.AbstractService;
import org.tfc.utils.GenericUtils;

public class OperacionBaseAction<F extends OperacionBaseForm<ID>,ID extends Serializable,E extends EntityBD<ID>> extends BaseAction<F> {

	private static final Logger logger = LoggerFactory.getLogger(OperacionBaseAction.class);
	
	private AbstractParser<F,ID,E> parser;
	
	private AbstractService<E,ID> service;
	
	@SuppressWarnings("unused")
	private Class<F> classForm;
	@SuppressWarnings("unused")
	private Class<ID> classID;
	@SuppressWarnings("unused")
	private Class<E> classEntity;
	
	@SuppressWarnings("unchecked")
	public OperacionBaseAction() {
		super();
		classForm = (Class<F>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass());
		classID = (Class<ID>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(),1);
		classEntity=(Class<E>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(),2);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev= super.setupForm(context);
		F form = (F)getFormObject(context);
		form.setOperacionCrud((String)((HttpServletRequest)context.getExternalContext().getNativeRequest()).getParameter("operacionCrud"));
		if(((HttpServletRequest)context.getExternalContext().getNativeRequest()).getParameter("id")!=null){
			form.setId((ID)new Long(Long.parseLong((String)((HttpServletRequest)context.getExternalContext().getNativeRequest()).getParameter("id"))));
		}
		if(StringUtils.isBlank(form.getOperacionCrud())){
			form.setOperacionCrud(TipoOperacionCrud.ALTA.name());
		}
		TipoOperacionCrud tipoOperacionCrud = TipoOperacionCrud.valueOf(form.getOperacionCrud());
		switch(tipoOperacionCrud){
			case CONSULTA:
			case MODIFICAR:{
				parser.getForm(service.findOne(form.getId()),form);
				break;
			}
			case ALTA:{
				
				// No hacemos nada
				break;
			}
			case ELIMINAR:{
				procesarError("Esta operacion no es valida");
				break;
			}
		}
		logger.debug(" Hemos accedido con la operacion [{}] [{}]",form.getOperacionCrud(),form.getId());
		return valdev;
	}
	
	public Event establecerModificacion(RequestContext context) throws Exception{
		@SuppressWarnings("unchecked")
		F form = (F)getFormObject(context);
		form.setOperacionCrud(TipoOperacionCrud.MODIFICAR.name());
		return success();
	}
	
	public Event postEliminar(RequestContext context) throws Exception{
		@SuppressWarnings("unchecked")
		F form = (F)getFormObject(context);
		form.setOperacionCrud(TipoOperacionCrud.ELIMINAR.name());
		return success();
	}
	
	public Event confirmar(RequestContext context) throws Exception {
		Event valdev=null;
		context.getActiveFlow().getId();
		@SuppressWarnings("unchecked")
		F form = (F)getFormObject(context);
		procesarOperacion(form);
		valdev =resolucionEvent(context);
		logger.debug(" Valdev [{}]",valdev);
		if(valdev != null
				&& valdev.getId()!=null
				&& success().getId().equals(valdev.getId())){
			operacionCorrecta(context);
		}else{
			operacionError(context);
		}
		return valdev;
	}

	private void procesarOperacion(F form) throws InstantiationException,
			IllegalAccessException, InvocationTargetException, DbpException {
		logger.debug("Operacion a realizar la operacion [{}] con el siguiente ID[{}]"
				,form!=null?form.getOperacionCrud():"El form es nulo"
				,form!=null?form.getId():"El form es nulo");
		TipoOperacionCrud operacionCrud =null;
		if(!StringUtils.isBlank(form.getOperacionCrud())){
			operacionCrud=TipoOperacionCrud.valueOf(form.getOperacionCrud());
		}
		switch(operacionCrud){
			case ALTA:{
				E entidad =parser.getEntity(form);
				entidad.setId(null);
				form.setId(service.save(entidad).getId());
				break;
			}
			case MODIFICAR:{
				service.update(parser.getEntity(form,service.findOne(form.getId())));
				break;
			}
			case CONSULTA:{
				procesarError("Esta operacion no es valida ["+operacionCrud+"]");
				break;
			}
			case ELIMINAR:{
				service.deleteById(form.getId());
				break;
			}
			default:{
				procesarError("Esta operacion no es valida ["+operacionCrud+"]");
				break;
			}
		}
		logger.debug("Se ha realizado la operacion [{}] con el siguiente ID[{}]"
				,operacionCrud
				,form!=null?form.getId():"El form es nulo");
	}

	/**
	 * Se encarga de procesar el error.
	 * @param error	El error que vamos a mostrar
	 * @throws DbpException
	 */
	protected void procesarError(String error) throws DbpException {
		logger.error(error);
		throw new DbpException(error);
	}
	
	
	public AbstractParser<F, ID, E> getParser() {
		return parser;
	}

	public void setParser(AbstractParser<F, ID, E> parser) {
		this.parser = parser;
	}

	public AbstractService<E, ID> getService() {
		return service;
	}

	public void setService(AbstractService<E, ID> service) {
		this.service = service;
	}



	
	
	
	
}