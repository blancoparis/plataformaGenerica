<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<%@ attribute name="id" required="true"  %>
<%@ attribute name="entidad" required="true"  %>
<%@ attribute name="valor"   %>
<c:set var="tipo" value="NADA"/>
<input id="json_${id}" class="urlJson" type="hidden"  value="/webapp/${entidad}/json/${tipo}/lista.htm"/>
<input id="valorInicial_${id}" class="valorComboJson" type="hidden" value="${valor}"/>

