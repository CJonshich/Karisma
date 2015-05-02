<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>


 <%@ include file="headerLogin.jsp" %>    
    <!-- -->
<div class="container contenidos index">
  
    
  
      <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2" style="margin-top:12%;">
        
        <div class="panel panel-info">
          <div class="panel-heading">
            <div class="panel-title">
              Inicie Sesión 
            </div>
          </div> 

          <div class="panel-body" style="padding:30px">
            <!--Nivel para alert--> 
            <div style="display:none;" id="login-alert" class="alert alert-danger col-sm-12">
              <span class="icon-cross2" style="margin-right:10px;"></span>Debe completar los campos Usuario y Contraseña.
            </div>
            <div id="loginerror"></div>
            <!--Fin alert-->
              <form id="loginForm" class="form-horizontal" method="post" action="empleado">
                
                <input type="hidden" value="acceder" name="opcion" id="opcion">
                
                <div class="input-group" style="margin-bottom:20px">
                   <span class="input-group-addon"><span class="icon-user"></span></span>
                   <input type="text" class="form-control" placeholder="Ingrese su nombre de Usuario" id="txtUsuario" name="txtUsuario"> 
                </div>    
               
                <div class="input-group">
                  <span class="input-group-addon"><span class="icon-lock"></span></span>
                  <input type="password" class="form-control" placeholder="Ingrese su Contraseña" id="txtClave" name="txtClave">
                </div>
                
                <div class="form-group" style="margin-top:10px">
                  <div class="col-sm-12 controls">
                    <input type="submit" class="btn btn-info btn-block" value="Enviar" id="btnLogin" name="btnLogin">
                  </div>
                </div>

              </form>

          </div><!--Panel Body-->
          
        </div><!--Panel-->
      </div><!--columnas-->
 

 

</div><!--Container-->
        
 <%@ include file="footer.jsp" %>
    


</body>
</html>