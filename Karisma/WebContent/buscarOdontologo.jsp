<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Odontologo</title>
<link rel="stylesheet" href="css/estilos.css">
</head>
<%@ page import="java.util.List" %>
<%@ page import="pe.AA.com.Bean.*" %>
<% List<BeanOdontologo> listaO = (List<BeanOdontologo>)request.getAttribute("listaO"); %>
<body bgcolor="#6666FF">

<table width="600" border="1" bgcolor="#99FFE5" class="TBuscar">
 
  <tr>
    <th><p class="label">Odontologo</p></td>
    <th><p class="label">Acción</p></td>
  </tr>
  	<% if(listaO.size()>0){ %>
  		<%for(BeanOdontologo odontologo : listaO ) {%>
  			<tr>
  				<td><%=odontologo.getNombreOdontologo()%> <%int idodo=odontologo.getIdodontologo(); %></td>
  				<td><a href="#" onClick="window.opener.document.all.txtodontologo.value='<%=odontologo.getNombreOdontologo()%>';
  											window.opener.document.all.idodontologo.value='<%=idodo %>';
  											window.close()"class="linkCSS"><font color="black">Asignar</font></a> </td>
  			</tr>
  		<% }%>
  	<%}else{ %>
  		<script>
  			alert('No hay odontologos disponibles');
  			window.close();
  		</script>
  	<%} %>
</table>
</body>
</html>