<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="head.jsp"%>
<body>
<%@ page import="java.util.List" %> 
<%@ page import="pe.AA.com.Bean.*" %>
<%List<BeanOdontologo> lista = (List<BeanOdontologo>)request.getAttribute("listaFiltrada");%>
<%String horario = (String) request.getAttribute("horarioReserva"); %>
<%String fecha = (String) request.getAttribute("fechaReserva"); %>

<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>Acción</th>
			<th>Odontologo</th>
		</tr>
	</thead>
	<%if(lista.size()>0){ %>
	<%String horarioReserva = horario; %>
	<%String fechaReserva = fecha; %>
	<tbody>
		<%for(BeanOdontologo odonto : lista){ %>
			<tr>
			<%String odontologo ="Dr. "+odonto.getPersona().getNom()+" "+odonto.getPersona().getApePat()+" "+odonto.getPersona().getApeMat(); %>
				
				<td><%int idodo=odonto.getIdodontologo();%>
				<a href=# class="linkIcon add" 
				onClick="window.opener.document.all.idodontologo.value='<%=idodo%>';
				window.opener.document.all.txtodontologo.value='<%=odontologo %>';
				window.opener.document.all.idhorario.value='<%=horarioReserva %>';
				window.opener.document.all.fecha.value='<%=fechaReserva %>';
				window.close()	"
				>
				<span class="icon-plus"></span>Agregar Odontologo
				</a></td>
				<td><%=odontologo%></td>
			</tr>
		<%} %>
	</tbody>
	<%}%>
</table>


</body>
</html>