<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="tablaResultado">
	<thead>
		<tr>
			<th>Id</th>
			<th>Descripcion</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="elemento" items="${form.resultado}">
		<tr id="filaenlace${elemento.id}">
			<td>
			<plantilla:identificadorTabla elemento="${elemento}" etiqueta="${elemento.id}" flujo="prueba"/>
			<%--
				<a href="${flowExecutionUrl}&_eventId=registro&id=${elemento.id}&operacionCrud=CONSULTA&flow=prueba">${elemento.id}</a>
				<a href="${flowExecutionUrl}&_eventId=registro&id=${elemento.id}&operacionCrud=MODIFICAR&flow=prueba">[modificar]</a>
				--%>
			</td>
			<td>${elemento.descripcion}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>	