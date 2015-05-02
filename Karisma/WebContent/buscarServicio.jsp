<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/estilos.css">
<title>Buscar Servicios</title>
</head>
<%@ page import="java.util.List" %>
<%@ page import="pe.AA.com.Bean.*" %>
<body bgcolor="#6666FF">
<% List<BeanServicio> lista = (List<BeanServicio>) request.getAttribute("listaServicios"); %>
<table width="600" border="1" bgcolor="#99FFE5" class="TBuscar">

<tr>
	<th><p class="label">Nombre</p></th>
    <th><p class="label">Descripcion</p></th>
    <th><p class="label">Costo</p></th>
    <th><p class="label">Acción</p></th>
</tr>
<%if(lista.size()>0){ %>
	<%for(BeanServicio servicio:lista){ %>
	<tr>
		<td><%=servicio.getNomservicio() %><%servicio.getIdservicio(); %></td>
		<td><%=servicio.getDescripcion() %></td>
		<td><%=servicio.getCosto() %></td>
		<td><a href="#" onClick="window.opener.document.all.txtservicio.value='<%=servicio.getNomservicio() %>';
									window.opener.document.all.idservicio.value='<%=servicio.getIdservicio()%>';
									window.close()">Agregar</a></td>
	</tr>
	<%} %>
<%} %>
</table>
</body>
</html>