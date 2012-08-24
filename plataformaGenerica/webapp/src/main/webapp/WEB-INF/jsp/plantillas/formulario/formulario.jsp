<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
<jsp:include page="/WEB-INF/jsp/includes/ventaModalOperaciones.jsp"/>
<c:set var="readOnly" >${readonly}</c:set>
	<article>
		<section>
			<h1><font><font><fmt:message key="formulario.seccion.titulo" /></font></font></h1>
			<p>
				<form action="plantillaFormularioAction.htm">
					<dbp:grupoBasico >
						<c:set var="etiquetaFecha"><fmt:message key='formulario.campo.fecha' /></c:set>
						<dbp:campoBasico id="fecha" type="date" 
							label="${etiquetaFecha}" readonly="${readOnly}"
							requiered="true" value="2011-09-08" />
						<c:set var="etiquetaCorreo"><fmt:message key="formulario.campo.correo" /></c:set>
						<dbp:campoBasico id="correo" type="email" 
							label="${etiquetaCorreo}" readonly="${readOnly}"
							requiered="true" value="david@gmail.com" />
						<c:set var="etiquetaNumero"><fmt:message key="formulario.campo.numero" /></c:set>
						<dbp:campoBasico id="numero" type="number" 
							label="${etiquetaNumero}" readonly="${readOnly}"
							requiered="true" value="23" />
						<c:set var="etiquetaTelefono"><fmt:message key="formulario.campo.telefono" /></c:set>
						<dbp:campoBasico id="telefono" type="tel" 
							label="${etiquetaTelefono}" readonly="${readOnly}"
							requiered="true" value="123" />
						<c:set var="etiquetaUrl"><fmt:message key="formulario.campo.url" /></c:set>
						<dbp:campoBasico id="url" type="url" 
							label="${etiquetaUrl}" readonly="${readOnly}"
							requiered="true" value="http://www.google.es" />
						<c:set var="etiquetaPruebaFecha"><fmt:message key="formulario.campo.pruebaFecha" /></c:set>
						<dbp:campoBasico id="pruebaFecha"	type="date"
							label="${etiquetaPruebaFecha}" readonly="${readOnly}" 
							requiered="false" />
					</dbp:grupoBasico>
					<div align="center">
						<p><jsp:include page="/WEB-INF/jsp/includes/botonEnviar.jsp"/></p>
					</div>
				</form>
			</p>
		</section>
		<footer>
			<font><font><fmt:message key="general.seccion.publico" /></font></font><span><font><font>18	de marzo 2011</font></font></span>
		</footer>
	</article>
	
</fmt:bundle>