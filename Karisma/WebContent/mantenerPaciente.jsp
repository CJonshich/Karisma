<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html> 
<%@ include file="head.jsp"%>
<body>
<%@ page import="java.util.List" %>
<%@ page import="pe.AA.com.Bean.*" %>
<%List<BeanPaciente> lista = (List<BeanPaciente>) request.getAttribute("mantePac"); %>
	
<%@ include file="header.jsp" %>
   
<div class="container"> 
  <div class="contenidos">
    <div class="botonContainer"> 
        <a class="botonCSS" style="text-decoration:none" href="<%=request.getContextPath()%>/paciente?opcion=agregar">
          <span class="icon-plus"></span>Agregar Nuevo Paciente
        </a>
      </div>
    
    <div class="col-md-12">
      <div style="margin-top:20px;">
        <table id="DataTable" class="stripe display" cellspacing="0" width="100%">
          <thead>
            <tr>
              <th >Acción</th>
              <th >DNI</th>
              <th >Nombre</th>
              <th >Apellido Paterno</th>
              <th >Apellido Materno</th>
              <th >Direcci&oacute;n</th>
              <th >Telefono</th>
              <th >Grupo Sangu&iacute;neo</th>
              <th >Talla</th>
              <th >Peso</th>
              <th >Sexo</th>
              <th >Fecha de Nacimiento</th>
            </tr>
          </thead>
          <tbody>
            <%if(lista.size()>0){ %>
            <%for(BeanPaciente paciente : lista){ %>
            <tr>
              <td><%int idpac=paciente.getIdpaciente(); %><a href="<%=request.getContextPath()%>/paciente?opcion=editar&id=<%=idpac%>"class="linkIcon edit">
                <span class="icon-edit"></span></a> <a href="<%=request.getContextPath()%>/paciente?opcion=eliminar&id=<%=paciente.getIdpaciente() %>" class="linkIcon delete" onClick="return confirm('¿Desea eliminar a la persona con DNI: <%=paciente.getPersona().getDni()%>?')"><span class="icon-cross"></span></a> </td>
              <td><%=paciente.getPersona().getDni() %> </td>
              <td><%=paciente.getPersona().getNom() %></td>
              <td><%=paciente.getPersona().getApePat() %></td>
              <td><%=paciente.getPersona().getApeMat() %></td>
              <td><%=paciente.getPersona().getDomicilio() %></td>
              <td><%=paciente.getPersona().getTelefono() %></td>
              <td><%=paciente.getTipoSangre() %></td>
              <td><%=paciente.getTalla() %></td>
              <td><%=paciente.getPeso()%></td>
              <td><%=paciente.getPersona().getSexo() %></td>
              <td><%=paciente.getPersona().getFecNac() %></td>
            </tr>
              <%} %>
            <%}else{ %>
            <%} %>
          </tbody>
        </table>
      </div>
     </div>
  </div>

</div>

<%@ include file="footer.jsp" %>
 
</body>
</html>