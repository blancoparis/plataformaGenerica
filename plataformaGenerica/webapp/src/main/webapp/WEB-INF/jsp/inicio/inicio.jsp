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
			<plantilla:combo etiqueta="Prueba" entidad="flujo" id="prueba"/>
			<plantilla:datalist etiqueta="Prueba DataList" entidad="flujo" id="prueba" valor="2"/>
			</p>
		</section>
		<footer>
			<font><font><fmt:message key="general.seccion.publico" /></font></font><span><font><font>18	de marzo 2011</font></font></span>
		</footer>
	</article>
	
</fmt:bundle>

