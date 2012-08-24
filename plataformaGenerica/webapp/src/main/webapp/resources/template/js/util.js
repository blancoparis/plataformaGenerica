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
	$("#"+nombreBoton).data("confirmacionSubmit","inicio");
	$("#dialog-confirm").dialog({
		resizable: false,
		height:200,
		modal: true,
		autoOpen: false,
		buttons: {
			Ok:function() {
				$(this).dialog("close");
				$("#"+nombreBoton).data("confirmacionSubmit","ok");
				$("form").submit();
			},
			Cancel: function() {
				$(this).dialog( "close" );
			}
		}
	});
	
	$("#"+nombreBoton).button();
	    $('form').submit(function(){
	    		var confirmacionSubmit= $("#"+nombreBoton).data("confirmacionSubmit");
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
	    				$("#"+nombreBoton).data("confirmacionSubmit","inicio");
	    				return true;
	    			}else{
	    				return false;
	    			}
	    		}
		  });

}

        // When document ready, call initMenu() function 
        $(document).ready(function() {
        	initMenu();
        	
        });    