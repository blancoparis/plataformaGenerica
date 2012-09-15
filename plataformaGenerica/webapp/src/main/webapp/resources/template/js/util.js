var userAgent = navigator.userAgent.toLowerCase();
jQuery.browser = {
	version: (userAgent.match( /.+(?:rv|it|ra|ie|me)[\/: ]([\d.]+)/ ) || [])[1],
	chrome: /chrome/.test( userAgent ),
	safari: /webkit/.test( userAgent ) && !/chrome/.test( userAgent ),
	opera: /opera/.test( userAgent ),
	msie: /msie/.test( userAgent ) && !/opera/.test( userAgent ),
	mozilla: /mozilla/.test( userAgent ) && !/(compatible|webkit)/.test( userAgent )
};
function initMenu() {
          $('#menu ul').hide(); // Hide the submenu
          if ($('#menu li').has('ul')) $('#menu ul').prev().addClass('expandable'); // Expand/collapse a submenu when it exists  
          $('.expandable').click(
            function() {
                $(this).next().slideToggle();
                $(this).toggleClass('expanded');
              }
            );
          }
        
function establecerBotonSubmit(nombreBoton,mensajeTitulo,mensajeConfirmacion){
	$("#dialog-confirm").attr("title",mensajeTitulo);
	$("#textoConfirmacion").html(mensajeConfirmacion);
	$("#_eventId").data("confirmacionSubmit","inicio");
	$("#dialog-confirm").dialog({
		resizable: false,
		height:200,
		modal: true,
		autoOpen: false,
		buttons: {
			Ok:function() {
				$(this).dialog("close");
				$("#_eventId").data("confirmacionSubmit","ok");
				$("form").submit();
			},
			Cancel: function() {
				$(this).dialog( "close" );
			}
		}
	});
	
	$("#"+nombreBoton).button();


	if(!$.browser.msie){
	    $('form').submit(function(){	
	    		var confirmacionSubmit= $("#_eventId").data("confirmacionSubmit");
	    		if(jQuery.type(confirmacionSubmit) === "undefined" || confirmacionSubmit == 'inicio' ){
			    var b=true;
			    $('input', this).each(function(){
			      if(!this.checkValidity()) b = false;
			    });
			    if(b){
			    	$("#dialog-confirm").dialog("open");
			    }
			    return false;
	    		}else{
	    			if(confirmacionSubmit == 'ok'){
	    				$("#_eventId").data("confirmacionSubmit","inicio");
	    				return true;
	    			}else{
	    				return false;
	    			}
	    		}
		  });
	}
	// TODO falta por montar lo del explorer
}
function procesarEvent(id,eventId){
	if($("#"+id).html()!=null){
		$("#"+id).button();
		$("#"+id).click(function (){
			$("#_eventId").val(eventId);
		});
	}
}

/**
 * Se encarga de la gestion de eliminar de un registro
 * @param id
 * @param mensaje
 * @param table
 */
function configurarVentanaAceptacionEliminarRegistro(id,table){
	var idDialogo=id;
	var idOperacion="resultado"+id;
	$("#"+idDialogo).dialog({
	resizable: false,
	height:200,
	modal: true,
	autoOpen: false,
	buttons:
			{
			Ok:function() {
				$(this).dialog("close");
				$("#"+idOperacion+" .modalEspera").show();
				$("#"+idOperacion).dialog("open");
				$.getJSON($("#"+id).data("href"),
						  function(data) {
							 $("#"+idOperacion+" .modalEspera").hide();
							  if(data.operacion=='ok'){
								  var idFilaTabla='fila'+$("#"+idDialogo).data("id");
								  var anSelected =table.$('#'+idFilaTabla);
								  if ( anSelected.length !== 0 ) {
									  oTable.fnDeleteRow( anSelected[0] );
								  }
								  $("#"+idOperacion).dialog("close");
							  }else{
								  $("#"+idOperacion+"textoConfirmacion").html("Error:"+data.descripcion);				  
							  }
						  });
			},
			Cancel: function() {
				$(this).dialog( "close" );
			}
		}
	});
	$("#"+idOperacion).dialog({
		resizable: false,
		height:200,
		modal: true,
		autoOpen: false,
	});
	$(".eliminarRegistro").click(function (){
		$("#"+idDialogo).dialog("open");
		var href=$(this).attr("href");
		var idEtiqueta=$(this).attr("id");
		$("#"+idDialogo).data("href",href);
		$("#"+idDialogo).data("id",idEtiqueta);
		return false;
	});
}

        // When document ready, call initMenu() function 
        $(document).ready(function() {
        	initMenu();
        	
        });    