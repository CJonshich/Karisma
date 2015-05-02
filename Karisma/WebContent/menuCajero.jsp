<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menú Cajero</title>
<link rel="stylesheet" href="css/div.css">
<link rel="stylesheet" href="css/estilos.css">
</head>
<body>
<div id="Contenedor" >
	<div id="Headprimero"></div> 
    <div id="Contenido">
    <div id="bienvenida"><p class="label">Bievenido: <%=request.getSession().getAttribute("usuario") %></p></div>
    <div id="MenuOpciones"><p style="margin-top:100px;"class="label" align="center"><strong>¿Qué desea realizar?</strong></p> 
    <table width="200" border="0" align="center" cellspacing="10" style="margin-top:50px;"> 
     <tr>
     	<td><img src="images/boton-RegistraCPago.fw.png">
        </td>
     </tr>
    <tr>
     	<td><img src="images/boton-ActCPago.fw.png">
        </td>
     </tr>
      <tr>
     	<td><img src="images/boton-CSesion.fw.png">
        </td>
     </tr>
    </table>
    </div>
    </div>
    <footer>
    </footer>
</div>
</body>
</html>