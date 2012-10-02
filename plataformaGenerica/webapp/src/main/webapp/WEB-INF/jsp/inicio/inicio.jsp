<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<script type="text/javascript">

	$(document).ready(function (){
		establecerJson();
	});
</script>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<article>
		<section>
			<h1><font><font><fmt:message key="inicio.seccion.titulo" /></font></font></h1>
			<p>
			Inicio de datos
			<label for="country_name">Flujo: </label><input id="country_name" name="country_name" type="text" list="country" />
			<datalist id="country">
			</datalist>
			<%--
			<input id="json_country" class="urlJson" type="hidden" value="/webapp/flujoJson.htm"/>
			 --%>
			<select id="flujo" name="flujo"> </select>
			<%--
			<input id="json_flujo" class="urlJson" type="hidden" value="/webapp/flujoJson.htm"/>
			--%>
			</p>
		</section>
		<footer>
			<font><font><fmt:message key="general.seccion.publico" /></font></font><span><font><font>18	de marzo 2011</font></font></span>
		</footer>
	</article>
	
</fmt:bundle>

