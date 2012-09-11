<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<%@ attribute name="elemento" required="true" type="org.tfc.form.subs.AbstractTablaSubForm" %>
<%@ attribute name="etiqueta" required="true"  %>
<%@ attribute name="flujo" required="true"  %>
<a href="${flowExecutionUrl}&_eventId=registro&id=${elemento.id}&operacionCrud=CONSULTA&flow=${flujo}">${etiqueta}</a>
<a href="${flowExecutionUrl}&_eventId=registro&id=${elemento.id}&operacionCrud=MODIFICAR&flow=${flujo}">[modificar]</a>
<a href="${flowExecutionUrl}&_eventId=eliminar&id=${elemento.id}">[eliminar]</a>

