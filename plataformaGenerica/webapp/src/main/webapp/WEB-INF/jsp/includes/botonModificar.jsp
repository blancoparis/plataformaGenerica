<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<c:set var="etiquetaBoton"><fmt:message key="geberal.button.modificar" /></c:set>
	<input type="submit" value="${etiquetaBoton}" id="botonModificar"  />

	
</fmt:bundle>