/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tfc.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

/**
 * 
 * Clase de utilidades para trabajar con los genericos.
 * 
 * @author david
 */
public class GenericUtils {
    public static Class<?> getPrimeroTypeParametroDeclaroOnSuperclass(Class<?> clazz) {
     return getPrimeroTypeParametroDeclaroOnSuperclass(clazz,0);
    }
    /**
     * 
     * Se encarga de obtener el primer parametro de clase padre.<br>
     * <br>
     * Nota tenemos controlado el caso de cglib, que es el padre del padre :P.
     * 
     * @param clazz
     * @return 
     */
    public static Class<?> getPrimeroTypeParametroDeclaroOnSuperclass(Class<?> clazz,int posicion) {
        if (clazz == null) {
            throw new IllegalArgumentException("clazz no puede ser null");
        }
        Type classGenType = obtenerElGenType(clazz);

        if (classGenType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) classGenType).getActualTypeArguments();
            if ((params != null) && (params.length >= 1)) {
                return (Class<?>) params[posicion];
            }
        }

        for (Type ifGenType : clazz.getGenericInterfaces()) {
            if (ifGenType instanceof ParameterizedType) {
                Type[] params = ((ParameterizedType) ifGenType).getActualTypeArguments();
                if ((params != null) && (params.length >= 1)) {
                    return (Class<?>) params[posicion];
                }
            }
        }


        throw new IllegalArgumentException(
                "No hemos encontrado el tipo para la clase (" + clazz.getSimpleName()+")");
    }

    /**
     * Nos devuelve el tipo generico, teniendo encuenta el CGLIB.
     * @param clazz
     * @return 
     */
    private static Type obtenerElGenType(Class<?> clazz) {
        Type classGenType = clazz.getGenericSuperclass();
        // En el caso de CGLIB, la solución es sacar el generico de la super clase.
        if (clazz.getName().contains("$$EnhancerByCGLIB$$")) {
            classGenType = clazz.getSuperclass().getGenericSuperclass();
        }
        return classGenType;
    }
    
    public static <T,R> List<R> copyList(List<T> elementos,Class<R> classR) throws IllegalAccessException, InvocationTargetException{
        List<R> valdev = new ArrayList<R>();
          for(T entityT:elementos){
            R elemento=org.springframework.beans.BeanUtils.instantiate(classR);
            BeanUtils.copyProperties(elemento,entityT);
            valdev.add(elemento);
        }
        return valdev;
    }
    
       public static Method findAnnotatedMethod(Class<? extends Annotation> annotationType, Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return null;
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getAnnotation(annotationType) != null) {
                return method;
            }
        }
        return findAnnotatedMethod(annotationType, clazz.getSuperclass());
    }

    public static Field findAnnotatedField(Class<? extends Annotation> annotationType, Class<?> clazz) {
        if (clazz == null || clazz.equals(Object.class)) {
            return null;
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(annotationType) != null) {
                return field;
            }
        }
        return findAnnotatedField(annotationType, clazz.getSuperclass());
    }
    
    public static List<Field> findAnnotatedFields(Class<? extends Annotation> annotationType,Class<?> clazz){
        List<Field> campos = new ArrayList<Field>();
        findAnnotatedField(annotationType, clazz, campos);
        return campos;
    }
    
    private static void findAnnotatedField(Class<? extends Annotation> annotationType, Class<?> clazz,List<Field> campos) {
        if (clazz == null || clazz.equals(Object.class)) {
            return;
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (field.getAnnotation(annotationType) != null) {
                campos.add(field);
            }
        }
        for (Field field : clazz.getFields()) {
            if (field.getAnnotation(annotationType) != null) {
                campos.add(field);
            }
        }
        findAnnotatedField(annotationType, clazz.getSuperclass());
    }    
}
