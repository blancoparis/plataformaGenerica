<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<%@ attribute name="id" required="true"  %>
<%@ attribute name="entidad" required="true"  %>
<%@ attribute name="etiqueta" required="true"  %>
<%@ attribute name="valor"   %>

<label for="${id}">${etiqueta} </label><input id="${id}" name="${id}" type="text" list="data${id}" value="${valor}"/>
<datalist id="data${id}">
</datalist>
<input id="json_data${id}" class="urlJson" type="hidden" value="/webapp/${entidad}/json/lista.htm"/>
<input id="valorInicial_data${id}" class="valorComboJson" type="hidden" value="${valor}"/>

