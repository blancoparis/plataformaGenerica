<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
<jsp:include page="/WEB-INF/jsp/includes/ventaModalOperaciones.jsp"/>
	<article>
		<section>
			<h1><font><font><fmt:message key="pruebas.buscador.seccion.titulo" /></font></font></h1>
			<p>
				<form:form action="${flowExecutionUrl}" commandName="form">
					<input type="hidden" id="_eventId" name="_eventId" value="" />
					<input type="hidden" name="_flowExecutionKey"  value="${flowExecutionKey}"/>
					<plantilla:erroresNegocio form="${form}" />
					<dbp:grupoBasico >

					</dbp:grupoBasico>
					<div align="center">
						<p><jsp:include page="/WEB-INF/jsp/includes/botonBuscar.jsp"/>
						<jsp:include page="/WEB-INF/jsp/includes/botonAlta.jsp"/>
						</p>
					</div>
				</form:form>
				<jsp:include page="/WEB-INF/jsp/pruebas/tablaBuscador.jsp"/>
				<%--<jsp:include page="/WEB-INF/jsp/plantillas/buscador/tablaBuscadorEjemplo.jsp"/>--%>
			</p>
		</section>
		<footer>
			<font><font><fmt:message key="general.seccion.publico" /></font></font><span><font><font>18	de marzo 2011</font></font></span>
		</footer>
	</article>
	
</fmt:bundle>