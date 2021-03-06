package org.tfc.parser.core;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.tfc.EntityBD;
import org.tfc.form.core.BaseForm;
import org.tfc.utils.GenericUtils;
/**
 * 
 * @author David Blanco París
 *
 * @param <F>
 * @param <ID>
 * @param <E>
 */
public class AbstractParser <F extends BaseForm
, ID extends Serializable, E extends EntityBD<ID>
>{

	private Class<F> classForm;
	private Class<E> classEntity;

	
	@SuppressWarnings("unchecked")
	public AbstractParser() {
		super();
		classForm = (Class<F>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass());
		classEntity=(Class<E>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(),2);
	}

	public E getEntity(F form) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		return getEntity(form,null);
	}
	
	public E getEntity(F form,E entity) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		E valdev= entity;
		if(valdev==null){
				valdev=classEntity.newInstance();
		}
		BeanUtils.copyProperties(valdev, form);
		return valdev;
	}
	

	
	
	public F getForm(E entity,F form) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		F valdev=form;
		if(valdev==null){
			valdev=classForm.newInstance();
		}
		BeanUtils.copyProperties(valdev, entity);
		return valdev;
	}
}
