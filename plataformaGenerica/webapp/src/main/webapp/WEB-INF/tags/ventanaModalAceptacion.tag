<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="id" required="true" %>
<div id="${id}" title="Empty the recycle bin?" style="display:none">
		<p>
			<span class="ui-icon ui-icon-alert" style="float:left; margin:0 7px 20px 0;"></span >
			<span id="${id}textoConfirmacion"></span>
			<div class="modalEspera" style="display:none"><img src="<c:url value="/resources/img/cargando.gif"/>" /></div>
		</p>
</div>