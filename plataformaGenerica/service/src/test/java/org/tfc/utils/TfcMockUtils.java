/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tfc.utils;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.BeanInstantiationException;
import org.springframework.beans.BeanUtils;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.util.ReflectionUtils.FieldFilter;

/**
 *
 * La clase de utilidades de los mock.
 * 
 * @author david
 */
public class TfcMockUtils {
    /**
     * Instancias un objeto entity, con las cadenas de texto inicializadas.
     * 
     * @param <T>           Es la clase con la que vamos a trabajar.
     * @param entityClass   Es la clase de entidad correspondiente.
     * @param prefijo       Es el prefijo que le vamos a poner.
     * @return  Nos devuelve la entidad.
     * @throws BeanInstantiationException
     * @throws IllegalArgumentException 
     */
    public static <T extends Serializable,ID extends Serializable> T entityMock(Class<T> entityClass,String prefijo) throws BeanInstantiationException, IllegalArgumentException {
        T elemento = BeanUtils.instantiate(entityClass);
        CandidatasFieldClaaBack candidatas = obtenerCandidatas(entityClass);
        for(Field campo:candidatas.getCandidatas()){
            ReflectionTestUtils.invokeSetterMethod(elemento, campo.getName(), campo.getName()+prefijo);
        }
        return elemento;
    }


    /**
     * Assert de las entidades del mock.
     * 
     * @param <T>           Es la clase con la que vamos a trabajar.
     * @param entityClass   Es la clase de entidad correspondiente.
     * @param prefijo       Es el prefijo que le vamos a poner.
     * @param entity        Es la entidad.
     */
    public static<T extends Serializable,ID extends Serializable> void assertEntityMock(Class<T> entityClass,String prefijo,T entity) {
        CandidatasFieldClaaBack candidatas = obtenerCandidatas(entityClass);
        for(Field campo:candidatas.getCandidatas()){
            assertEquals("Falla el assert en el campo ("+campo.getName()+")"
                    ,(String)ReflectionTestUtils.invokeGetterMethod(entity, campo.getName())
                    ,campo.getName()+prefijo);
        }
    }
    
    private static  <T extends Serializable,ID extends Serializable> CandidatasFieldClaaBack obtenerCandidatas(Class<T> entityClass) throws IllegalArgumentException {
        CandidatasFieldClaaBack candidatas = new CandidatasFieldClaaBack();
        ReflectionUtils.doWithFields(entityClass, candidatas, new CandidatasFieldFilter());
        return candidatas;
    }

    /**
     * CLASES ENMBEBIDAS.
     */
    
    private static class CandidatasFieldClaaBack implements FieldCallback {
        
        private List<Field> candidatas=new ArrayList<Field>();

        public void doWith(final Field field) throws IllegalArgumentException, IllegalAccessException {
            candidatas.add(field);
        }
        public List<Field> getCandidatas() {
            return candidatas;
        }

        @SuppressWarnings("unused")
		public void setCandidatas(List<Field> candidatas) {
            this.candidatas = candidatas;
        }
    }

    private static class CandidatasFieldFilter implements FieldFilter {

        public boolean matches(final Field field) {
            final int modifiers = field.getModifiers();
            return !Modifier.isStatic(modifiers) && field.getType().getCanonicalName().equals(String.class.getCanonicalName());
        }
    }
}
