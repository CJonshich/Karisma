<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>

<%@ include file="header.jsp" %>

<div class="container contenidos">
  <div class="col-md-10 col-md-offset-1 col-sm-12" style="margin-top:20px;">
    <div class="panel panel-info">
      <div class="panel-heading">
        <div class="panel-title">
          Generar Historial Clinico
        </div>
      </div>
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
        </form> <!--Fin Form Buscar Paciente x DNI-->
        <form action="historialC" method="post" name="GHClinico" id="GHClinico" class="form-horizontal" role="form">

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

          <div class="form-group">
            <label for="txtfecNac" class="control-label col-md-3">Fecha de Nacimiento</label>
            <div class="col-md-9">
              <input type="text" id="txtfecNac" class="form-control" readonly>
            </div>
          </div>

          <div class="form-group">
            <label for="txtpeso" class="control-label col-md-3">Peso</label>
            <div class="col-md-9">
              <div class="input-group">
                  <input type="txtpeso" id="txtpeso" maxlength="6" class="form-control" readonly>
                  <span class="input-group-addon">Kg.</span>
              </div>
            </div>
          </div>

          <div class="form-group">
            <label for="txttalla" class="control-label col-md-3">Talla</label>
            <div class="col-md-9">
              <div class="input-group">
                <input type="text" id="txttalla" maxlength="4" class="form-control" readonly>
                <span class="input-group-addon">m.</span>
              </div>
            </div>  
          </div>

          <div class="form-group">
            <label for="txtsexo" class="control-label col-md-3">Sexo</label>
            <div class="col-md-9">
              <input type="text" id="txtsexo" class="form-control" readonly>
            </div>
          </div>

          <div class="form-group">
            <label for="txtGSanguineo" class="control-label col-md-3">Grupo Sanguíneo</label>
            <div class="col-md-9">
              <input type="text" id="txtGSanguineo" class="form-control" readonly></div>
          </div>

          <div class="form-group">
            <label for="txaAlergia" class="control-label col-md-3">Alergias</label>
            <div class="col-md-9">
              <textarea name="txaAlergia" id="txaAlergia" cols="30" rows="10" class="form-control"></textarea>
            </div>
          </div>

          <div class="form-group">
            <label for="txaObservacion" class="control-label col-md-3">Otras Observaciones</label>
            <div class="col-md-9">
              <textarea name="txaObservacion" id="txaObservacion" cols="30" rows="10" class="form-control"></textarea>
            </div>
          </div>

          <div class="form-group">
            
            <div class="col-md-2 col-md-offset-7">
              <input name="btn_Generar" type="submit" id="btn_Generar" value="Generar" class="btn btn-info" style="width:100%;margin-top:10px;">
            </div>
            <div class="col-md-2 col-md-offset-1">
              <input type="button" name="Cancelar" id="Cancelar" value ="Cancelar" class="btn btn-info" style="width:100%;margin-top:10px;">
            </div>

          </div>
          
          <!--Hiddens con opciones y mÃ¡s-->
          <input type="hidden" name="idpaciente" id="idpaciente">
          <input type="hidden" name="dni" id="dni">
          <input type="hidden" name="opcion" id="opcion" value="generar">
          <!---->

        </form><!--Fin Form Generar Historial Clinico-->
      </div><!--Fin panel body-->
    </div><!--Fin panel-->
  </div><!--Fin Cols-->
</div><!--Fin Container-->
<%@ include file="footer.jsp" %>


<!--Scripts-->

<script> 
$(function(){  
        
                $('#txtdni').validCampoFranz('0123456789');
        
            });
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