<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<%@ attribute name="id" required="true"  %>
<%@ attribute name="entidad" required="true"  %>
<%@ attribute name="etiqueta" required="true"  %>
<%@ attribute name="valor"   %>
<%@ attribute name="tipo"   %>

<label for="${id}">${etiqueta} </label>
<select id="${id}" name="${id}"> </select>
<plantilla:configuracionJsonLista entidad="${entidad}" id="${id}" valor="${valor}" tipo="${tipo}"/>
