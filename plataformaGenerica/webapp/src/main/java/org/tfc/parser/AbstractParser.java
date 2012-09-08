package org.tfc.parser;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.tfc.EntityBD;
import org.tfc.form.BaseForm;
import org.tfc.utils.GenericUtils;
/**
 * 
 * 
 * 
 * @author David Blanco París
 *
 * @param <F>
 * @param <E>
 */
public class AbstractParser <F extends BaseForm,ID extends Serializable, E extends EntityBD<ID>>{

	private Class<F> classForm;
	private Class<E> classEntity;
	
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
	
	public F getForm(E entity) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		F valdev=classForm.newInstance();
		BeanUtils.copyProperties(valdev, entity);
		return valdev;
	}
}
