package org.tfc.action;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;
import org.tfc.EntityBD;
import org.tfc.form.AbstractBuscadorForm;
import org.tfc.form.subs.AbstractTablaSubForm;
import org.tfc.parser.AbstracBuscadorParser;
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

	@SuppressWarnings("unchecked")
	public Event buscar(RequestContext context) throws Exception {
		Event valdev = success();
		F form = (F) getFormObject(context);
		form =buscadorParser.getForm(service.findAll(),form);
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