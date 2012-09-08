<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<article>
		<section class="articuloDefecto">
			<h1><font><font></font></font></h1>
			<p>
			<table>
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
			</p>
		</section>
	</article>
</fmt:bundle>