package org.tfc.action;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

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

public class OperacionBaseAction<F extends OperacionBaseForm<ID>,ID extends Serializable,E extends EntityBD<ID>> extends BaseAction<F> {

	private static final Logger logger = LoggerFactory.getLogger(OperacionBaseAction.class);
	
	private AbstractParser<F,ID,E> parser;
	
	private AbstractService<E,ID> service;
	
	public OperacionBaseAction() {
		super();
	}

	@Override
	public Event setupForm(RequestContext context) throws Exception {
		Event valdev= super.setupForm(context);
		F form = (F)getFormObject(context);
		if(StringUtils.isBlank(form.getOperacionCrud())){
			form.setOperacionCrud(TipoOperacionCrud.ALTA.name());
		}
		logger.debug(" Hemos accedido con la operacion [{}]",form.getTipoOperacion());
		return valdev;
	}
	
	public Event confirmar(RequestContext context) throws Exception {
		Event valdev=null;
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