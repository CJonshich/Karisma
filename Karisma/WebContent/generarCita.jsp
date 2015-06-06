<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<%@ include file="head.jsp"%>
<body>
<%@page import="pe.AA.com.Bean.*" %>
<%@ page import="java.util.List" %>
<%List<BeanHorario> lista = (List<BeanHorario>) request.getAttribute("listahorario"); %>
	
	<%@ include file="header.jsp" %>
    
    <div class="container contenidos"style="margin-top:20px">
       
      <div class="col-md-10 col-md-offset-1 col-sm-12">
        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title">
              Generar Cita

            </div><!--Fin Title-->
          </div><!--Fin Head-->
          <div class="panel-body" style="padding:30px">
            
              
            <form action="paciente" method="post" class="form-horizontal" target="Buscar Paciente" onSubmit="window.open('','Buscar Paciente','toolbar=no,location=no,menubar=no,scrollbars=yes,height=400,width=600')"> 
              <div class="form-group">
                <input type="hidden" value="buscar" id="opcion" name="opcion">
                <label for="txtdni" class="control-label col-md-3">DNI</label>
                <div class="col-md-9">
                  <div class="input-group">
                    <input type="text" class="form-control" id="txtdni" name="txtdni" required maxlength="8">
                    <span class="input-group-btn">
                      <button class="btn btn-info" type="submit" id="BuscarPaciente" value="BuscarPaciente">Buscar Paciente</button>
                    </span>
                  </div><!--Fin Input Group-->
                </div>
              </div>

              <div class="form-group">
                <label for="txtnombre" class="control-label col-md-3">Nombres</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" id="txtnombre" name="txtnombre" readonly>
                </div>
              </div>

              <div class="form-group">
                <label for="txtapepat" class="control-label col-md-3">Apellido Paterno</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" id="txtapepat" name="txtapepat" readonly>
                </div>
              </div>

              <div class="form-group">
                <label for="txtapemat" class="control-label col-md-3">Apellido Materno</label>
                <div class="col-md-9">
                  <input type="text" class="form-control" id="txtapemat" name="txtapemat" readonly>
                </div>
              </div>

             </form> <!--Fin Form Buscar Paciente-->


               <form action="odontologo" method="post" class="form-horizontal" target="Buscar Odontologo" onSubmit="window.open('','Buscar Odontologo','toolbar=no,location=no,menubar=no,scrollbars=yes,height=400,width=600')"> 
              <input type="hidden" value="buscar" id="opcion" name="opcion">
              <div class="form-group">
                <label for="txtfechaCita" class="control-label col-md-3">Fecha de la Cita</label>
                 <div class="col-md-9">
                    <div class="input-group">
                      <input type="text" id="txtfechaCita" name="txtfechaCita" readonly  class="form-control date-picker">
                      <label for="txtfechaCita" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>
                    </div>
                  </div>
              </div>

              <div class="form-group">
                <label for="sel_horario" class="control-label col-md-3">Horario</label>
                <div class="col-md-9">
                  <select name="sel_horario" class="form-control" id="sel_horario">
                  <%for(BeanHorario horario : lista){ %>
                  	<option value=<%=horario.getIdhorario() %>> <%=horario.getHoraInicio() %> - <%=horario.getHoraFin() %></option>
                  <%} %>
                  </select>
              </div>
              </div>

               <div class="form-group">
                <label for="txtodontologo" class="control-label col-md-3">Odontologo</label>
                <div class="col-md-9">
                  <div class="input-group">
                    <input type="text" class="form-control" id="txtodontologo" name="txtodontologo" readonly>
                    <span class="input-group-btn">
                      <button class="btn btn-info" type="submit" id="BuscarOdontologo" value="BuscarOdontologo">Buscar Odontologo</button>
                    </span>
                  </div><!--Fin Input Group-->
                </div>
              </div>

            </form> 
            <!--Fin form buscar Odontologo por Disponibilidad-->
            <form action="cita" method="post" class="form-horizontal" role="form">
              <div class="form-group">
                <label for="txtmotivo" class="control-label col-md-3">Motivo</label>
                <div class="col-md-9">
                  <textarea id="txtmotivo" cols="30" rows="10" class="form-control" name="txtmotivo" required></textarea>
                </div>
              </div>

              <!--Botones-->
              <div class="form-group">
                <div class="col-md-2 col-md-offset-7">
                  <input name="btn_Guardar" type="submit" id="btn_Guardar" value="Registrar" class="btn btn-info" style="width:100%;margin-top:10px;">
                </div>
                <div class="col-md-2 col-md-offset-1">
                  <input type="button" name="Cancelar" id="Cancelar" value ="Cancelar" class="btn btn-info" style="width:100%;margin-top:10px;">
                </div>
              </div>

              <!--Hiddens de los Id's y la Opción, estos manejan los datos que serán enviados al servlet-->
              <input type="hidden" name="idpaciente" id="idpaciente" value="" >
              <input type="hidden" name="idodontologo" id="idodontologo" value="">

              <input type="hidden" value="registrar" name="opcion" id="opcion"> 
              <input type="hidden" name="txtfecNac" id="txtfecNac">
              <input type="hidden" name="txtsexo" id="txtsexo">
              <input type="hidden" name="txtpeso" id="txtpeso">
              <input type="hidden" name="txttalla" id="txttalla">
              <input type="hidden" name="txtGSanguineo" id="txtGSanguineo">
              <input type="hidden" name="dni" id="dni">

              <input type="hidden" name="idhorario" id="idhorario">
              <input type="hidden" id="fecha" name="fecha">
              <!--Fin hiddens-->

            </form><!--Fin form agregar cita-->
          </div><!--Panel Body-->  
        </div><!--Panel-->  
      </div><!--Columnas-->  

    </div> <!--Container-->     
   
  <%@ include file="footer.jsp" %>

<!--JAVASCRIPTS LUEGO DE QUE CARGA EL BODY-->
<script> 
$(function(){  
				
                $('#txtdni').validCampoFranz('0123456789');
				
            });</script>

<script type="text/javascript">
	
	function buscarOdontologo(){
		window.open('odontologo?opcion=buscar','Buscar Odontologo','toolbar=no,location=no,menubar=no,scrollbars=yes,height=300,width=600')
		
		}
</script>

<script>
  $(document).ready(function(){
    $("#Cancelar").click(function(){
      
      var response = confirm("¿Desea cancelar la operación?")
      if(response==true){
        window.location.href='<%=request.getContextPath()%>/menuAuxiliar.jsp';
      }else{
      return false; 
      }
      
      });
    });
</script>


</body>
</html>