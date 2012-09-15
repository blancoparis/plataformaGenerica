<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="titulo" description="Es el titulo de la venta inicial"  %>
<%@ attribute name="mensaje" description="Es el mensaje estandar"  %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
<%-- Titulo--%>
<c:set var="mensTitulo" >
 <fmt:message key="general.titulo"/>
</c:set>
<c:if test="${not empty titulo}">
	<c:set var="mensTitulo">
	 <fmt:message key="${titulo}"/>
	</c:set>
</c:if>
<%-- Mensaje --%>
<c:set var="mensMensaje" >
 <fmt:message key="general.mensaje"/>
</c:set>
<c:if test="${not empty mensaje}">
	<c:set var="mensMensaje">
	 <fmt:message key="${mensaje}"/>
	</c:set>
</c:if>

<div id="${id}" title="${mensTitulo}" style="display:none">
		<p>
			<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span >
			<span id="${id}textoConfirmacion">${mensMensaje}</span>
			<div class="modalEspera" style="display:none"><img src="<c:url value="/resources/img/cargando.gif"/>" /></div>
		</p>
</div>
</fmt:bundle>
