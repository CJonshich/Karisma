$(document).ready(function(){
	
	$('#btn_guardar_ser').click(function(){
		$('#form_servicio').submit();
	});
	
	$('.botonCSS').click(function(){
		$('#opcion').val('agregar');
	})
});