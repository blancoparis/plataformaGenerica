package org.tfc.action.core;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.EntityBD;
import org.tfc.form.core.AbstractBuscadorForm;
import org.tfc.form.core.subs.AbstractTablaSubForm;
import org.tfc.parser.core.AbstracBuscadorParser;
import org.tfc.service.AbstractService;
import org.tfc.utils.GenericUtils;
/**
 * 
 * @author David Blanco París
 *
 * @param <F>
 * @param <TF>
 * @param <ID>
 * @param <E>
 */
public class BuscadorBaseAction
 <F extends AbstractBuscadorForm<TF, ID>
, TF extends AbstractTablaSubForm<ID>
, ID extends Serializable
, E extends EntityBD<ID>>
		extends BaseAction<F> {

	@SuppressWarnings("unused")
	private Class<F> claseFormulario;
	@SuppressWarnings("unused")
	private Class<TF> claseTablaSubForm;
	@SuppressWarnings("unused")
	private Class<ID> claseId;
	@SuppressWarnings("unused")
	private Class<E>  claseE;
	
	private AbstracBuscadorParser<ID,E,F,TF> buscadorParser;
	private AbstractService<E,ID> service;

	@SuppressWarnings("unchecked")
	public BuscadorBaseAction() {
		super();
		claseFormulario = (Class<F>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(), 0);
		claseTablaSubForm = (Class<TF>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(), 1);
		claseId = (Class<ID>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(), 2);
		claseE= (Class<E>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(), 3);
	}


	public Event buscar(RequestContext context) throws Exception {
		Event valdev = success();
		operacionDeBusqueda(context);
		return valdev;
	}

	private void operacionDeBusqueda(RequestContext context) throws Exception,
			InstantiationException, IllegalAccessException,
			InvocationTargetException {
		@SuppressWarnings("unchecked")
		F form = (F) getFormObject(context);
		form =buscadorParser.getForm(service.findAll(),form);
	}
	
	public Event eliminar(RequestContext context) throws Exception{
		Event valdev = success();
		if(((HttpServletRequest)context.getExternalContext().getNativeRequest()).getParameter("id")!=null){
			@SuppressWarnings("unchecked")
			ID id=(ID)new Long(Long.parseLong((String)((HttpServletRequest)context.getExternalContext().getNativeRequest()).getParameter("id")));
			service.deleteById(id);
			operacionDeBusqueda(context);
		}
		//Thread.sleep(10000L);
		return valdev;
	}

	public AbstracBuscadorParser<ID, E, F, TF> getBuscadorParser() {
		return buscadorParser;
	}

	public void setBuscadorParser(AbstracBuscadorParser<ID, E, F, TF> buscadorParser) {
		this.buscadorParser = buscadorParser;
	}

	public AbstractService<E, ID> getService() {
		return service;
	}

	public void setService(AbstractService<E, ID> service) {
		this.service = service;
	}
	
	
}