<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Cita</title>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="css/div.css">
</head>
<body>

<%@ page import="java.util.List" %>
<%@ page import="pe.AA.com.Bean.*" %>
<%List<BeanCita> listaC=(List<BeanCita>) request.getAttribute("BCita"); %>
<%List<String> listaO=(List<String>) request.getAttribute("BCitaodontologo"); %>


<div class="buscar">
	<table class="TBuscar" width="721" border="1">
  <tr>
    <th width="49">Acci&oacute;n</td>
    <th width="75">N&deg; de Cita</td>
    <th>DNI</th>
    <th width="91">Nombre</td>
    <th width="143">Apellido Paterno</td>
    <th width="147">Apellido Materno</td>
    <th width="49">Doctor</td>
    
  </tr>
	
  <%if(listaO.size()>0){ %>
  <%int i=0; %>
  	<%for(BeanCita cita : listaC ){ %>
  		<tr>
  			<td><a href="#" 
  			onClick="window.opener.document.all.txtnombre.value='<%=cita.getPaciente().getPersona().getNom() %>';
  					window.opener.document.all.txtapePat.value='<%=cita.getPaciente().getPersona().getApePat() %>';
  					window.opener.document.all.txtapeMat.value='<%=cita.getPaciente().getPersona().getApeMat()%>';
  					window.opener.document.all.txtdni.value='<%=cita.getPaciente().getPersona().getDni() %>';
  					window.opener.document.all.txtNcita.value='<%=cita.getIdcita() %>';
  					window.opener.document.all.ncita.value='<%=cita.getIdcita() %>';
  					window.opener.document.all.txtodontologo.value='<%=listaO.get(i) %>';
  					window.opener.document.all.idodontologo.value='<%=cita.getOdontologo().getIdodontologo()%>';
  					window.close()
  				"
  			
  			class="linkCSS"><font color="black">Agregar</font></a></td>
  			<td><%=cita.getIdcita()%></td>
  			<td><%=cita.getPaciente().getPersona().getDni() %></td>
  			<td><%=cita.getPaciente().getPersona().getNom()%></td>
  			<td><%=cita.getPaciente().getPersona().getApePat() %></td>
  			<td><%=cita.getPaciente().getPersona().getApeMat() %></td>
  			<td>
  			<%=listaO.get(i) %>
  			<%i++; %>
  			</td> 
  			
  		</tr>
  	
  	<%} %>
  	
  <%} %>
</table>

</div>
</body>
</html>