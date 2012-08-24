<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
<jsp:include page="/WEB-INF/jsp/includes/ventaModalOperaciones.jsp"/>
	<article>
		<section>
			<h1><font><font><fmt:message key="buscaror.seccion.titulo" /></font></font></h1>
			<p>
			<form action="plantillaBuscadorAction.htm">
				<dbp:grupoBasico >
					<c:set var="etiquetaFecha"><fmt:message key='buscador.campo.fecha' /></c:set>
					<dbp:campoBasico id="fecha" type="date" 
							label="${etiquetaFecha}"
							requiered="true" value="2011-09-08" />
				</dbp:grupoBasico>
			<div align="center">
				<p><jsp:include page="/WEB-INF/jsp/includes/botonBuscar.jsp"/></p>
			</div>
			</form>
						</p>
				
			<jsp:include page="/WEB-INF/jsp/plantillas/buscador/tablaBuscadorEjemplo.jsp"/>
		</section>
		<footer>
			<font><font><fmt:message key="general.seccion.publico" /></font></font><span><font><font>18	de marzo 2011</font></font></span>
		</footer>
	</article>
</fmt:bundle>