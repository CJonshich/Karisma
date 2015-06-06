<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>



	<%@ include file="header.jsp" %>
    

    <div class="container" style="margin-top:20px;">
    	<div class="contenidos">
    	  <!-- <div class="col-md-12 text-center"><h2>Agregar Servicios</h2></div>-->
    		
            <div class="col-md-10 col-md-offset-1 col-sm-12">

                <div class="panel panel-info">
                    
                    <div class="panel-heading">
                        <div class="panel-title">
                            Agregar Nuevo Servicio
                        </div><!--Fin Title-->
                    </div><!--Fin Head-->
    
                    
                    <div class="panel-body" style="padding:30px">
                        <form action="servicio" method="post" class="form-horizontal">
                              <!--Hidden para mandar según opción al servlet-->
                            <input type="hidden" value="agregar" name="opcion" id="opcion"> 
                            
                        
                        
                              <div class="form-group">
                                       <label for="txtNombre" class="control-label col-md-3">Nombre del Servicio </label>
                                      <div class="col-md-9 ">
                                          <input name="txtNombre" id="txtNombre" type="text"class="form-control"> 
                                      </div>
                                      
                              </div>
                                <div id="mensajeNom" class="error"><span class="icon-cross2"></span>Debe ingresar un nombre para el Servicio</div>
                                <div class="form-group">
                                    <label for="txaDescripcion" class="control-label col-md-3">Descripcion</label>
                                    <div class="col-md-9 ">
                                        <textarea name="txaDescripcion" id="txaDescripcion" cols="" rows=""class="form-control"></textarea>
                                    </div>
                                </div>
                        
                        
                                <div class="form-group">
                                    <label for="txtCosto" class="control-label col-md-3">Costo del Servicio</label>
                                    <div class="col-md-9">
                                        <div class="input-group">
                                            <span class="input-group-addon">S/.</span>
                                            <input type="text" name="txtCosto" id="txtCosto" maxlength="3" class="form-control">
                                            <span class="input-group-addon">.00</span>
                                        </div>
                                    </div>
                                    <div id="mensajeCosto" class="error"><span class="icon-cross2"></span>Debe ingresar un costo del servicio</div> 
                                </div>
                        
                           
                            <!--Botones-->
                            <div class="form-group">
                                    <div class="col-md-2 col-md-offset-7">
                                        <input name="btn_Guardar" type="submit" id="btn_Guardar" value="Registrar" class="btn btn-info" style="width:100%;margin-top:10px;">
                                    </div>
                                    <div class="col-md-2 col-md-offset-1">
                                        <input type="button" name="btn_Cancelar" id="btn_Cancelar" value ="Cancelar" class="btn btn-info" style="width:100%;margin-top:10px;">
                                    </div>
                            </div>
                        
                        </form>
                    </div>
    
                </div><!--Panel-->
            </div><!--Columnas-->
    	</div><!--Contenidos-->
    </div><!--Container-->
    
   
    <%@ include file="footer.jsp"%>


<!--  <script>
$(document).ready(function(){
	 //Expresión para validar un correo electrónico
        var expr = /^[a-zA-Z0-9_\.\-]+@[a-zA-Z0-9\-]+\.[a-zA-Z0-9\-\.]+$/;
		//función click
            $("#btn_Guardar").click(function(){
				//Guardar en variables el valor que tengan las cajas de texto
                //Por medio de los id's
                //Y tener mejor manipulación de dichos valores
				var nombre=$("#txtNombre").val();
				var costo=$("#txtCosto").val();
				// --- Condicionales anidados ----
                //Si nombre está vacío
                //Muestra el mensaje
                //Con false sale de los if's y espera a que sea pulsado de nuevo 
				if(nombre==""){
					$("#mensajeNom").fadeIn("slow");
					return false;
				}else{
					$("#mensajeNom").fadeOut();	
					if(costo==""){
						$("#mensajeCosto").fadeIn("slow");
						return false;
					}else{
						$("#mensajeCosto").fadeOut();
							return false;
					}
				}
			});
	
	});
</script> -->

<script>
	$(document).ready(function(){
		$("#btn_Cancelar").click(function(){
			
			var response = confirm("¿Desea cancelar la operación?")
			if(response==true){
				window.location.href='<%=request.getContextPath()%>/servicio?opcion=listar';
			}else{
			return false;	
			}
			
			});
		});
</script>

<script>
$(document).ready(function() {
    $('#txtCosto').validCampoFranz('0123456789');
    $('#txtNombre').validCampoFranz('abcdefghijklmnñopqrstuvwxyz');
});

</script>

</body>
</html>