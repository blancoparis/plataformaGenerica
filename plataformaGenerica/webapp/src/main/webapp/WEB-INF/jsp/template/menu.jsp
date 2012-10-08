<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<aside>
    	<nav>
    	<plantilla:menu nodo="${menuDbp}"/>
   		</nav>
	</aside>
</fmt:bundle>    		
 		
    		
    		
