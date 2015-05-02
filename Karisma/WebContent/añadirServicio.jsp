<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/div.css">
<link rel="stylesheet" href="css/estilos.css">
<title>Clínica Karisma</title>
<%@page import="pe.AA.com.Bean.*" %>
<%@page import="java.util.List" %>

<%--Recojo los valores que mande desde el servlet anterior --%>
<%List<BeanServicio> listaS=(List<BeanServicio>) request.getAttribute("listaS"); %>
</head>
<body>
<div id="Contenedor">
<%@ include file="header.jsp" %>
<div id="Contenido">
<div id="ListadoCrud" style="margin-left:250px">
<table width="1160" border="1" class="tableM">
  <tr>
    <th colspan="5"><h1>Listado de Servicios</h1></th>
    </tr>
  <tr>
    <td>Código del servicio</td>
    <td>Nombre</td>
    <td>Descripción</td>
    <td>Costo</td>
    <td>Acción</td>
  </tr>
  <%if(listaS.size()>0){ %>
  	<%for(BeanServicio servicio: listaS){ %>
  	<tr>
  	<td><%=servicio.getIdservicio() %></td>
  	<td><%=servicio.getNomservicio() %></td>
  	<td><%=servicio.getDescripcion() %></td>
  	<td><%=servicio.getCosto() %></td>
  	<td><a href="#" class="linkCSS"><font color="#000000">Agregar</font></a></td>
  	</tr>
  	<%} %>
  <%} %>
</table>

</div>

</div>
 <%@ include file="footer.jsp" %>
</div>
</body>
</html>