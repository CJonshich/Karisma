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
            <div class="alert alert-danger alert-dismissible" role="alert" id="login-wrong">
              	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              	<strong>Error!</strong> Usuario o Contraseña equivocados.
            </div>
           <div class="alert alert-danger alert-dismissible" role="alert" id="login-empty" >
               	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              	<strong>Error!</strong> Por Favor, complete todos los campos.
            </div>
            <div id="loginerror"></div>
            <!--Fin alert-->
              <form id="loginForm" class="form-horizontal" method="post" action="empleado">
                
                
                <div class="input-group" style="margin-bottom:20px">
                   <span class="input-group-addon"><span class="icon-user"></span></span>
                   <input type="text" class="form-control" placeholder="Ingrese su nombre de Usuario" id="user" name="user"> 
                </div>    
               
                <div class="input-group">
                  <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                  <input type="password" class="form-control" placeholder="Ingrese su Contraseña" id="pass" name="pass">
                </div>
                
                <div class="form-group" style="margin-top:10px">
                  <div class="col-sm-12 controls">
                    <input type="button" class="btn btn-info btn-block" value="Enviar" id="btnLogin" name="btnLogin">
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