<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<c:choose>
	 	<c:when test="${form.operacionCrud=='CONSULTA'}">
	 		<jsp:include page="/WEB-INF/jsp/includes/botonModificar.jsp"/>
	 		<jsp:include page="/WEB-INF/jsp/includes/botonEliminar.jsp"/>
	 		
	 	</c:when>
	 	<c:when test="${form.operacionCrud=='ALTA'}">
	 		<jsp:include page="/WEB-INF/jsp/includes/botonEnviar.jsp"/>
	 	</c:when>
	 	<c:when test="${form.operacionCrud=='MODIFICAR'}">
	 		<jsp:include page="/WEB-INF/jsp/includes/botonEnviar.jsp"/>
	 		<jsp:include page="/WEB-INF/jsp/includes/botonEliminar.jsp"/>
	 	</c:when>
	</c:choose>
</fmt:bundle>