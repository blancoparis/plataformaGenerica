<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<%@ attribute name="elemento" required="true" type="org.tfc.form.core.subs.AbstractTablaSubForm" %>
<%@ attribute name="etiqueta" required="true"  %>
<%@ attribute name="flujo" required="true"  %>
<%@ attribute name="descripcionEliminar" required="true" %>
<a href="${flowExecutionUrl}&_eventId=registro&id=${elemento.id}&operacionCrud=CONSULTA&flow=${flujo}">${etiqueta}</a>
<a href="${flowExecutionUrl}&_eventId=registro&id=${elemento.id}&operacionCrud=MODIFICAR&flow=${flujo}">[modificar]</a>
<a id="enlace${elemento.id}" href="${flowExecutionUrl}&_eventId=eliminar&id=${elemento.id}" class="eliminarRegistro">[eliminar]</a>
<input id="desripcionenlace${elemento.id}" type="hidden" value="${descripcionEliminar}"/>
