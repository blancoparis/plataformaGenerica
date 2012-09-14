<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<article>
		<section class="articuloDefecto">
			<h1><font><font></font></font></h1>
			<p>
			<table id="mensajeResultado" >
				<thead>
					<tr>
						<th><fmt:message key="general.operacion.operacion" /></th>
						<th><fmt:message key="general.operacion.mensaje" /></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><fmt:message key="${form.textoTipoOperacion}"/></td>
						<td><fmt:message key="${form.mensajeTipoOperacion}"/></td>
					</tr>
				</tbody>
			</table>
			<table id="enlaces">
				<thead>
					<th>Operacion</th>
					<th>Enlace (${form.operacionCrud}) Url Base(${fn:split(flowExecutionUrl,"?")[0]}) Url (${flowExecutionUrl})</th>
				</thead>
				<tbody>
					<tr>
						<td>Alta</td>
						<td><a autofocus="autofocus" href="${fn:split(flowExecutionUrl,"?")[0]}">Alta</a></td>
					</tr>
					<tr>
						<td>Buscador</td>
						<td><a href='${fn:replace(fn:split(flowExecutionUrl,"?")[0],".htm","Buscador.htm")}'>Buscador</a></td>
					</tr>
					<c:if test="${form.operacionCrud != 'ELIMINAR'}">
						<tr>
							<td>Consultar</td>
							<td><a href="${fn:split(flowExecutionUrl,"?")[0]}?id=${form.id}&operacionCrud=CONSULTA">Consultar el registro (${form.id})</a></td>
						</tr>
						<tr>
							<td>Modificar</td>
							<td><a href="${fn:split(flowExecutionUrl,"?")[0]}?id=${form.id}&operacionCrud=MODIFICAR">Modificar el registro (${form.id})</a></td>
						</tr>
					</c:if>
				</tbody>
			</table>
			</p>
		</section>
	</article>
</fmt:bundle>