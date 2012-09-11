<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<a href='${fn:replace(fn:split(flowExecutionUrl,"?")[0],".htm","Buscador.htm")}'>[Buscador]</a>
<a href="${fn:split(flowExecutionUrl,"?")[0]}">[Alta]</a>