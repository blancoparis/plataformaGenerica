package org.tfc.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.tag.common.core.UrlSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tfc.action.core.OperacionBaseAction;
import org.tfc.form.core.subs.NodoArbolSubForm;

@SuppressWarnings("serial")
public class MenuTag extends BodyTagSupport{
	
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);	
	
	private NodoArbolSubForm nodo;
	
	private String context;
	
	private String idMenu;
	
	private String claseIntermedio;
	
	private String claseHoja;
	
	private String claseMenu;
	
	
	public MenuTag() {
		super();
		init();
	}
	private void init() {
		context=null;
		idMenu="menu";
		claseIntermedio="expandable expanded";
		claseHoja=null;
		claseMenu=null;
	}
	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print(pintarArbol(nodo));
		} catch (IOException e) {
			logger.error("Pintando el menu [{}]",e.getMessage(),e);
			throw new JspException("Error al intentar pintar el menu",e);
		}
		return super.doEndTag();
    }
	private String pintarArbol(NodoArbolSubForm nodo) throws JspException{
		String valdev="";
		valdev+="<ul id='"+idMenu+"' "+(StringUtils.isBlank(claseMenu)?"":" class=\""+claseMenu+"\" ")+" >";
		if(nodo.getHijos()!=null && nodo.getHijos().size()>0){
			for(NodoArbolSubForm hijo:nodo.getHijos()){
				valdev+=pintarArbol(hijo,0);	
			}
		}else{
			valdev+=pintarArbol(nodo,0); 
		}
		valdev+="</ul>";
		return valdev;
	}
	
	private String pintarArbol(NodoArbolSubForm nodo,int nivel) throws JspException{
		String valdev="<li>";
		if(nodo.getHijos()!=null && nodo.getHijos().size()>0){
			valdev+=pintarTextoNodo("#",nodo.getDescripcion(),claseIntermedio);
			valdev+="<ul>";
			for(NodoArbolSubForm hijo:nodo.getHijos()){
				valdev+=pintarArbol(hijo,nivel+1);
			}
			valdev+="</ul>";
		}else{
			valdev+=pintarTextoNodo(UrlSupport.resolveUrl(nodo.getUrl(),context , pageContext),nodo.getDescripcion(),claseHoja);
		}
		return valdev+"</li>";
	}

	public String pintarTextoNodo(String url,String descripcion,String clase){
		return "<a href=\""+url+"\" "+(StringUtils.isBlank(clase)?"":" class=\""+clase+"\" ")+"><font><font>"+descripcion+"</font></font></a>";
	}
	
	
	public NodoArbolSubForm getNodo() {
		return nodo;
	}

	public void setNodo(NodoArbolSubForm nodo) {
		this.nodo = nodo;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}
	public String getClaseIntermedio() {
		return claseIntermedio;
	}
	public void setClaseIntermedio(String claseIntermedio) {
		this.claseIntermedio = claseIntermedio;
	}
	public String getClaseHoja() {
		return claseHoja;
	}
	public void setClaseHoja(String claseHoja) {
		this.claseHoja = claseHoja;
	}
	public String getClaseMenu() {
		return claseMenu;
	}
	public void setClaseMenu(String claseMenu) {
		this.claseMenu = claseMenu;
	}

	
	
}
