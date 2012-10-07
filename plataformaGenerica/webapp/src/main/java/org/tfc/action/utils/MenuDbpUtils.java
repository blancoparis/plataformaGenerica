package org.tfc.action.utils;

import java.util.ArrayList;

import org.tfc.form.core.subs.NodoArbolSubForm;

/**
 * 
 * Se encarga de gestionar los menus.
 * 
 * @author David Blanco París
 *
 */
public class MenuDbpUtils {
	
	public static NodoArbolSubForm menu(){
		return mockMenu();
	}
	
	private static NodoArbolSubForm mockMenu(){
		NodoArbolSubForm valdev=new NodoArbolSubForm();
		valdev.setDescripcion("Raiz");
		valdev.setUrl("/raiz/url");
		valdev.setHijos(new ArrayList<NodoArbolSubForm>());
		valdev.getHijos().add(mockHijo(valdev,"a1"));
		valdev.getHijos().add(mockHijo(valdev,"a2",mockHijo(valdev,"a2b1"),mockHijo(valdev,"a2b2")));
		valdev.getHijos().add(mockHijo(valdev,"a3"));
		return valdev;
	}

	private static NodoArbolSubForm mockHijo(NodoArbolSubForm padre,String descripcion,NodoArbolSubForm... hijos){
		NodoArbolSubForm valdev= new NodoArbolSubForm();
		valdev.setDescripcion(descripcion);
		valdev.setUrl("/"+descripcion+"/url");
		valdev.setPadre(padre);
		if(hijos!=null && hijos.length>0){
			valdev.setHijos(new ArrayList<NodoArbolSubForm>());
			for(NodoArbolSubForm hijo:hijos){
				valdev.getHijos().add(hijo);
			}
		}
		return valdev;
	}


}
