<script type="text/javascript" charset="utf-8">
	var oTable;
	$(document).ready(function() {
		oTable = $('#tablaResultado').dataTable({
			"bJQueryUI": true,
			"sPaginationType": "full_numbers"
		});
		establecerBotonSubmit("botonSubmit","Operaci�n","Desea realizar la busqueda");
		procesarEvent("botonSubmit","buscar");
		procesarEvent("botonAlta","alta");
		
	} );
</script>