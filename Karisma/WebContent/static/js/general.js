$(document).ready(function(){
	/*Login*/
	$('#btnLogin').click(function(){
		var user = $('#user').val();
		var pass = $('#pass').val();
		var okUser = true;
		var okPass = true;
		
		if(!$('#user').val()){
			okUser = false;
		}
		if(!$('#pass').val()){
			okPass = false;
		}
		
		if(okUser&&okPass){
			$.ajax({
				url:'empleado',
				type:'POST',
				dataType: 'JSON',
				data : {"user":""+user+"" ,"pass":""+pass+""},
		//		contentType:'application/json',
	            success:function(data){
	            	if(data.success){
	            		window.location.href="http://localhost:8085/Karisma"+data.url;
	            	}else{
	            		$('#login-wrong').fadeIn();
	            	}
	            },
	            error:function(){
	            	
	            }
			});
		}else{
			$('#login-empty').fadeIn();
			if(!okUser){
				$('#user').parent().addClass('has-error');
			}
			if(!okPass){
				$('#pass').parent().addClass('has-error');
			}
		}
	});
	/*Fin Login*/
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
				$('#codservicio').val(data.idservicio);
				$('#nombre').val(data.nomservicio);
				$('#descripcion').val(data.descripcion);
				$('#costo').val(data.costo);
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