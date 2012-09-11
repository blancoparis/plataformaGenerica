<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp"%>
<%@ attribute name="form" description="" required="true" rtexprvalue="true" type="org.tfc.form.core.BaseForm" %>
<c:if test="${not empty form.erroresNegocio }">
	<div id="erroresServidor">
		Errores de servidor
		<table>
			<c:forEach var="errorNegocio" items="${form.erroresNegocio}">
				<tr>
					<td>${errorNegocio.titulo}</td>
					<td>${errorNegocio.mensaje}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</c:if>
