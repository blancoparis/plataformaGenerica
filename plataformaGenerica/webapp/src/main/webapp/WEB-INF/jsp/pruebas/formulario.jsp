<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
<jsp:include page="/WEB-INF/jsp/includes/ventaModalOperaciones.jsp"/>
	<article>
		<section>
			<h1><font><font><fmt:message key="pruebas.formulario.seccion.titulo" /></font></font></h1>
			<p>
				<jsp:include page="/WEB-INF/jsp/includes/operacionesBasicas.jsp"/>
				<form:form action="${flowExecutionUrl}" commandName="form">
					<input type="hidden" id="_eventId" name="_eventId" value="" />
					<input type="hidden" name="_flowExecutionKey"  value="${flowExecutionKey}"/>
					<plantilla:erroresNegocio form="${form}" />
					<c:choose>
						<c:when test="${form.operacionCrud == 'CONSULTA'}"><c:set var="readOnly" value="true"/></c:when>
						<c:otherwise><c:set var="readOnly" value="false"/></c:otherwise>
					</c:choose>	
					<dbp:grupoBasico >
						<%--
						<c:set var="etiquetaFecha"><fmt:message key='pruebas.formulario.campo.fecha' /></c:set>
						<dbp:campoBasico id="fecha" type="date" 
							label="${etiquetaFecha}" readonly="${readOnly}"
							requiered="true" value="2011-09-08" />
						<c:set var="etiquetaCorreo"><fmt:message key="pruebas.formulario.campo.correo" /></c:set>
						<dbp:campoBasico id="correo" type="email" 
							label="${etiquetaCorreo}" readonly="${readOnly}"
							requiered="true" value="david@gmail.com" />
						<c:set var="etiquetaNumero"><fmt:message key="pruebas.formulario.campo.numero" /></c:set>
						<dbp:campoBasico id="numero" type="number" 
							label="${etiquetaNumero}" readonly="${readOnly}"
							requiered="true" value="23" />
						<c:set var="etiquetaTelefono"><fmt:message key="pruebas.formulario.campo.telefono" /></c:set>
						<dbp:campoBasico id="telefono" type="tel" 
							label="${etiquetaTelefono}" readonly="${readOnly}"
							requiered="true" value="123" />
						<c:set var="etiquetaUrl"><fmt:message key="pruebas.formulario.campo.url" /></c:set>
						<dbp:campoBasico id="url" type="url" 
							label="${etiquetaUrl}" readonly="${readOnly}"
							requiered="true" value="http://www.google.es" />
						<c:set var="etiquetaPruebaFecha"><fmt:message key="pruebas.formulario.campo.pruebaFecha" /></c:set>
						<dbp:campoBasico id="pruebaFecha"	type="date"
							label="${etiquetaPruebaFecha}" readonly="${readOnly}" 
							requiered="false" />
						--%>
						
						
						<c:set var="etiquetaDescripcion"><fmt:message key="pruebas.formulario.campo.descripcion" /></c:set>
						<dbp:campoBasico autofocus="autofocus" id="descripcion"	type="text"
							label="${etiquetaDescripcion}" readonly="${readOnly}" 
							requiered="false" value="${form.descripcion}" />
						<form:errors path="descripcion"	id="error_descripcion" cssClass="errorCampo" cssStyle="display:none;"/>
						
						<c:set var="etiquetaFecha"><fmt:message key='pruebas.formulario.campo.fecha' /></c:set>
						<dbp:campoBasico id="fecha" type="date" 
							label="${etiquetaFecha}" readonly="${readOnly}"
							requiered="true" value="${form.fecha}" />
						<form:errors path="fecha"	id="error_fecha" cssClass="errorCampo" cssStyle="display:none;"/>							
					</dbp:grupoBasico>
					<div align="center">
						<p><jsp:include page="/WEB-INF/jsp/includes/botoneraOperaciones.jsp"/></p>
					</div>
			
					
				</form:form>
			</p>
		</section>
		<footer>
			<font><font><fmt:message key="general.seccion.publico" /></font></font><span><font><font>18	de marzo 2011</font></font></span>
		</footer>
	</article>
	
</fmt:bundle>