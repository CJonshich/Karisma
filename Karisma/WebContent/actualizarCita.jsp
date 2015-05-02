<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html>
<%@ include file="head.jsp"%>
<body>
<%@ include file="header.jsp" %>

  <div class="container contenidos" style="margin-top:20px">
    <div class="col-md-10 col-md-offset-1 col-sm-12">
      <div class="panel panel-info">
        <div class="panel-heading">
          <div class="panel-title">
            Actualizar Cita
          </div><!--Fin Title-->
        </div><!--Fin Head-->
        <div class="panel-body" style="padding:30px">
          <form name="Acita" action="cita" method="post" class="form-horizontal">
            
            <div class="form-group"></div>

            <div class="form-group">
              
              <label for="txtNcita" class="control-label col-md-3">Número de Cita</label>
              
              <div class="col-md-9">
               <div class="input-group">
                <input type="text" id="txtNcita" class="form-control" readonly>
                <span class="input-group-btn">
                      <button class="btn btn-info" type="button" id="BuscarCita" onClick="buscarCita()">Buscar Cita</button>
                    </span>
                </div>
              </div>

            </div>
            <div class="form-group">
              <label for="txtdni" class="control-label col-md-3">DNI</label>
                <div class="col-md-9">
                  <input type="text" id="txtdni" class="form-control" readonly>
                </div>  
            </div>

            <div class="form-group">
              <label for="txtnombre" class="control-label col-md-3">Nombres</label>

              <div class="col-md-9">
                <input type="text" name="txtnombre" id="txtnombre" class="form-control" readonly>  
              </div> 
            </div>
            
            <div class="form-group">
              <label for="txtapePat" class="control-label col-md-3">Apellido Paterno</label>
              <div class="col-md-9">
                    <input type="text" class="form-control" id="txtapePat" name="txtapePat" readonly>
              </div>    
            </div>
            
            <div class="form-group">
              <label for="txtapeMat" class="control-label col-md-3">Apellido Materno</label>
              <div class="col-md-9">
                <input type="text" class="form-control" id="txtapeMat" readonly>
              </div>
            </div>
            <div class="form-group">
              <label for="txtodontologo" class="control-label col-md-3">Odontologo</label>
              <div class="col-md-9">
                <input type="text" id="txtodontologo" class="form-control" readonly>
              </div>
            </div>
            <div class="form-group">
              <label for="txadiagnostico" class="control-label col-md-3">Diagnostico</label>
              <div class="col-md-9">
                <textarea name="txadiagnostico" id="txadiagnostico" cols="30" rows="10" class="form-control" required></textarea>
              </div>
            </div>
            <div class="form-group">
              <label for="texarecomendacion" class="control-label col-md-3">Recomendacion</label>
              <div class="col-md-9">
                <textarea name="txarecomendacion" id="txarecomendacion" cols="30" rows="10" class="form-control" required></textarea>
              </div>
            </div>
            <!--Hiddens-->
            
            <input name="opcion" type="hidden" id="opcion" value="actualizar">
            <input name="idodontologo" type="hidden" id="idodontologo" value="">
            <input type="hidden" name="ncita" id="ncita" value="">

            <!--Fin Hiddens-->

            <!--Botones-->
            <div class="form-group">
              <div class="col-md-2 col-md-offset-7">
                  <input name="btn_Actualizar" type="submit" id="btn_Actualizar" value="Actualizar" class="btn btn-info" style="width:100%;margin-top:10px;">
                </div>
                <div class="col-md-2 col-md-offset-1">
                  <input type="button" name="Cancelar" id="Cancelar" value ="Cancelar" class="btn btn-info" style="width:100%;margin-top:10px;">
                </div>
            </div>
              
  
            
          </form>

        </div><!--Panel Body--> 
      </div><!--Panel--> 
    </div><!--Columnas-->
  
  </div><!--Container-->  

    
<%@ include file="footer.jsp" %>

<script type="text/javascript">
  function buscarCita (){
    window.open('cita?opcion=buscar','Buscar Cita','toolbar=no,location=no,menubar=no,scrollbars=yes,height=300,width=600');
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