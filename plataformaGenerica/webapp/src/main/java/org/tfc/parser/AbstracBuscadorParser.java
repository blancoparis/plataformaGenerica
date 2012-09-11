package org.tfc.parser;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.tfc.EntityBD;
import org.tfc.form.AbstractBuscadorForm;
import org.tfc.form.subs.AbstractTablaSubForm;
import org.tfc.utils.GenericUtils;
/**
 * 
 * @author David Blanco París
 *
 * @param <ID>
 * @param <E>
 * @param <FB>
 * @param <TF>
 */
public class AbstracBuscadorParser < ID extends Serializable, E extends EntityBD<ID>
, FB extends AbstractBuscadorForm<TF, ID>
, TF extends AbstractTablaSubForm<ID>> {
	
	@SuppressWarnings("unused")
	private Class<E> classEntity;
	private Class<FB> classBuscadorForm;
	private Class<TF> classTablaBuscador;
	
	@SuppressWarnings("unchecked")
	public AbstracBuscadorParser() {
		classEntity=((Class<E>) GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(),1));
		classBuscadorForm=(Class<FB>)GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(),2);
		classTablaBuscador=(Class<TF>)GenericUtils
				.getPrimeroTypeParametroDeclaroOnSuperclass(this.getClass(),3);
	}

	public FB getForm(List<E> entidades,FB form) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		FB valdev=form;
		if(valdev==null){
			valdev=classBuscadorForm.newInstance();
		}
		valdev.setResultado(new ArrayList<TF>());
		TF elemento = null;
		for(E entidad:entidades){
			elemento=classTablaBuscador.newInstance();
			BeanUtils.copyProperties(elemento,entidad);
			valdev.getResultado().add(elemento);
		}
		return valdev;
	}
	
}
