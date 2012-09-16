<script type="text/javascript" charset="utf-8">
	var oTable;
	$(document).ready(function() {
		oTable = $('#tablaResultado').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
		});
		establecerBotonSubmit("botonSubmit","Operación","Desea realizar la busqueda");
		procesarEventMensajeValidar("botonSubmit","buscar","¿Desea realizar la busqueda?","false");
		procesarEventMensajeValidar("botonAlta","alta","¿Desea dar de alta el registro?","false");
		
	} );
</script>