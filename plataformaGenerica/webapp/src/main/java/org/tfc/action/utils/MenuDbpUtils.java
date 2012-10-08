package org.tfc.action.utils;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.tfc.form.core.subs.NodoArbolSubForm;

/**
 * 
 * Se encarga de gestionar los menus.
 * 
 * @author David Blanco París
 *
 */
public class MenuDbpUtils {
	/**
	 * 
	 * Se encarga de establecer el menu.
	 * 
	 * @param request
	 */
	public static void establecerMenu(HttpServletRequest request){
		HttpSession session=  request.getSession();
		session.setAttribute("menuDbp", menu());
	}
	
	public static NodoArbolSubForm menu(){
		return mockMenu();
	}
	
	private static NodoArbolSubForm mockMenu(){
		NodoArbolSubForm valdev=new NodoArbolSubForm();
		valdev.setId(0L);
		valdev.setDescripcion("Raiz");
		valdev.setUrl("/raiz/url");
		valdev.setHijos(new ArrayList<NodoArbolSubForm>());
		valdev.getHijos().add(mockHijo(1L,valdev,"a1"));
		valdev.getHijos().add(mockHijo(2L,valdev,"a2",mockHijo(4L,valdev,"a2b1"),mockHijo(5L,valdev,"a2b2")));
		valdev.getHijos().add(mockHijo(3L,valdev,"a3"));
		valdev.getHijos().add(mockHijo(6L,valdev,"Operaciones"
				,mockHijo(7L,"/inicioAction.htm",valdev,"Inicio")
				,mockHijo(8L,"/prueba.htm",valdev,"prueba")
				));
		return valdev;
	}

	private static NodoArbolSubForm mockHijo(Long id,NodoArbolSubForm padre,String descripcion,NodoArbolSubForm... hijos){
		return mockHijo(id, "/"+descripcion+"/url",padre, descripcion, hijos);
	}
	
	private static NodoArbolSubForm mockHijo(Long id,String url,NodoArbolSubForm padre,String descripcion,NodoArbolSubForm... hijos){
		NodoArbolSubForm valdev= new NodoArbolSubForm();
		valdev.setId(id);
		valdev.setDescripcion(descripcion);
		valdev.setUrl(url);
		valdev.setPadre(padre);
		if(hijos!=null && hijos.length>0){
			valdev.setHijos(new ArrayList<NodoArbolSubForm>());
			for(NodoArbolSubForm hijo:hijos){
				hijo.setPadre(valdev);
				valdev.getHijos().add(hijo);
			}
		}
		return valdev;
	}


}
