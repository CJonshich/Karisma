$(document).ready(function(){
	
	$('#btn_guardar_ser').click(function(){
		$('#form_servicio').submit();
	});
	
	$('.botonCSS').click(function(){
		$('#opcion').val('agregar');
	});
	
	$('.editServicio').click(function(){
		var id = $(this).data("id");
		var opcion = 'editar';
		$.ajax({
			url:'servicio?opcion='+opcion+'&id='+id,
			type:'GET',
			contentType:'application/json',
			success: function(data){
				$('#opcion').val('editar');
				$('#txtCodservicio').val(data.idservicio);
				$('#txtNombre').val(data.nomservicio);
				$('#txaDescripcion').val(data.descripcion);
				$('#txtCosto').val(data.costo);
			},
			error: function(){
				alert('Ocurrio un error');
			}
		});
	});
	
	$('.deleteServicio').click(function(event){
		var name = $(this).data('name');
		event.preventDefault();
		alertify.defaults.glossary.title='Eliminar Servicio';
		alertify.defaults.glossary.cancel = 'Cancelar';
		alertify.defaults.theme.ok = "btn btn-success";
		alertify.defaults.theme.cancel = "btn btn-danger";
		alertify.confirm('¿Desea eliminar el servicio '+name+' ?',function(){
			window.location.href=event.currentTarget.getAttribute('href');
		});
	});
	
});