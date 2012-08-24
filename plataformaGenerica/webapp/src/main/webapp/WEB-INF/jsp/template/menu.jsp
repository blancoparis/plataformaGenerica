<%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${param.locale}"  />
<fmt:bundle basename="app">
	<aside>
    	<nav>
       		<ul id="menu">
           		<li><a href="#"><font><font><fmt:message  key="menu.inicio.titulo" /></font></font></a></li>
       			<li>
           			<a href="#" class="expandable expanded"><font><font><fmt:message  key="menu.plantilla.titulo" /></font></font></a>
	                    <ul style="display: block; ">
	                        <li><a href="<c:url value="inicioAction.htm" />"><font><font><fmt:message  key="menu.plantilla.basico" /> </font></font></a></li>
	                        <li><a href="<c:url value="plantillaBuscadorAction.htm" />"><font><font><fmt:message  key="menu.plantilla.buscador" /></font></font></a></li>
	                        <li><a href="<c:url value="plantillaFormularioAction.htm" />"><font><font><fmt:message  key="menu.plantilla.formulario" /></font></font></a></li>
	                        <li><a href="<c:url value="plantillaFormularioConsultaAction.htm" />"><font><font><fmt:message  key="menu.plantilla.formulario" /><font><font><fmt:message  key="menu.plantilla.consulta" /></font></font></a></li>                      
	                    </ul>        
		        </li>
                <li><a href="#"><font><font><fmt:message  key="menu.contacto.titulo" /></font></font></a></li>                   
            </ul>
   		</nav>
	</aside>
</fmt:bundle>    		
 		
    		
    		
