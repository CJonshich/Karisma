<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Paciente</title>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="css/div.css">
</head>
<body bgcolor="#6666FF">

	
	

<%@ page import="pe.AA.com.Bean.*" %>
<%BeanPaciente paciente = (BeanPaciente) request.getAttribute("BPacienteobj"); %>
<%String sexo; %>
<div style="overflow:auto">
<table width="600" border="1" class="TBuscar">

  <tr>
    <th>DNI</th>
    <th>Nombre</th>
    <th>Apellido Paterno</th>
    <th>Apellido Materno</th>
   
   
    <th>Acción</th>
  </tr>
 
  
  	<tr>
  		<td><%=paciente.getPersona().getDni()%></td>
  		<td><%=paciente.getPersona().getNom()%></td>
  		<td><%=paciente.getPersona().getApePat()%></td>
  		<td><%=paciente.getPersona().getApeMat()%></td>
  		<%if(paciente.getPersona().getSexo().equals("M")){ %>
  		<%sexo="Masculino"; %>
  		<%}else if(paciente.getPersona().getSexo().equals("F")){ %>
  		<%sexo="Femenino"; %>
  		<%}else{ %>
  		<%sexo="null";%>
  		<%} %>
  		<td><a href="#" class="linkCSS" onClick="window.opener.document.all.txtnombre.value='<%=paciente.getPersona().getNom()%>';
  								window.opener.document.all.txtapepat.value='<%=paciente.getPersona().getApePat() %>';
  								window.opener.document.all.txtapemat.value='<%=paciente.getPersona().getApeMat() %>';
  								window.opener.document.all.dni.value='<%=paciente.getPersona().getDni() %>';
  								window.opener.document.all.txtsexo.value='<%=sexo%>';
  								window.opener.document.all.txtfecNac.value='<%=paciente.getPersona().getFecNac()%>';
  								window.opener.document.all.txtpeso.value='<%=paciente.getPeso() %>';
  								window.opener.document.all.txttalla.value='<%=paciente.getTalla() %>';
  								window.opener.document.all.txtGSanguineo.value='<%=paciente.getTipoSangre() %>';
  								window.opener.document.all.idpaciente.value='<%=paciente.getIdpaciente() %>';window.close()">Agregar</a></td>
  	</tr>
  
</table>
</div>

</body>
</html>