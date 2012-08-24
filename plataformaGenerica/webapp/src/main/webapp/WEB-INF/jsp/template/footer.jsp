<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}" />
<fmt:bundle basename="app">
	<footer class="clearfix">
		<font><font><fmt:message key="general.tfc.siglas" /></font></font> 
		<font><font><fmt:message key="general.autor.nombre" /></font></font>
		<br>
		<div id="tw">A</div>
		<div id="fb">B</div>
	</footer>
</fmt:bundle>