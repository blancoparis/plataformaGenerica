  <%@ include file="/WEB-INF/jsp/includes/taglibs.jsp" %>
  <!-- noty -->
  <script type="text/javascript" src="<c:url value='/resources/noty/jquery.noty.js'/>"></script> 
  
  <!-- layouts -->
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/bottom.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/bottomCenter.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/bottomLeft.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/bottomRight.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/center.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/centerLeft.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/centerRight.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/inline.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/top.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/topCenter.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/topLeft.js'/>"></script>
  <script type="text/javascript" src="<c:url value='/resources/noty/layouts/topRight.js'/>"></script>

  <!-- themes -->
  <script type="text/javascript" src="<c:url value='/resources/noty/themes/default.js'/>"></script>
<jsp:include page="/WEB-INF/jsp/includes/head/cabeceraEstandarFormulario.jsp"/> 
<script type="text/javascript" charset="utf-8">

	/**
	* Pintar los mensajes de error.
	**/

	function pintarError(error){
		var n = noty({
	  		text: error,
	  		type: 'error',
	      	dismissQueue: true,
	      	modal: true,
	  		layout: 'top',
	  		theme: 'default',
	  		timeout:'10000'
	  	});
	}
	
	function pintarErroresDesplegable(elementos){
		var textoError='<table>';
		textoError+='<tr>';
		$.each(elementos, function(index, value) { 
			  textoError+='<td><font size="3">'+$('#'+value.id.replace("error_", "etiqueta_")).text()+'</font></td><td>'+value.innerHTML+'</td>';
			  
			});			
		textoError+'</tr>';
		pintarError(textoError);
	}
	
	function pintarMensajeEnLosCampos(elementos){
		$.each(elementos, function(index, value) {
			  $('#'+value.id.replace("error_", "eror_vista_")).html(value.innerHTML);
		});
	}

	$(document).ready(function() {
		var elementos =$(".errorCampo");
		if(elementos.size()>0){
			pintarMensajeEnLosCampos(elementos);
		}
	} );
</script>