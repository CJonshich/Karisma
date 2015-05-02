<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Clinica Karisma</title>
<link rel="stylesheet" href="css/estilos.css">
<link rel="stylesheet" href="css/div.css">
</head>
<body>
<%request.getSession().getAttribute("errobPaciente");%>
	<script type="text/javascript">
		alert('<%=request.getSession().getAttribute("errobPaciente")%>');
	</script>
	
	
	
	<%request.getSession().removeAttribute("errobPaciente"); %>
    <div style="width:30%; margin-left:0px;">
<a class="linkBuscar" onclick="window.opener.location.href='<%=request.getContextPath()%>/paciente?opcion=agregar'; window.close();">Agregar Nuevo Paciente</a>
</div>
</body>
</html>