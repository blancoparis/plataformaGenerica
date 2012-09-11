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
		<tr>
			<td>${elemento.id}</td>
			<td>${elemento.descripcion}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>	