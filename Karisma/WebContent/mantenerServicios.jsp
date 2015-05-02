<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@ page import="java.util.List" %>
<%@ page import="pe.AA.com.Bean.*" %>
<% List<BeanServicio> lista = (List<BeanServicio>) request.getAttribute("listaServicios"); %>

<%@ include file="header.jsp" %>

    
<div class="container">
    <div class="contenidos"><div class="botonContainer"> 
          <a class="botonCSS" href="<%=request.getContextPath()%>/servicio?opcion=agregar">
          <span class="icon-plus"></span>Agregar Nuevo Servicio
          </a>
      </div>
        
      <div class="col-md-12" style="margin-top:20px;">
        <table id="DataTable" class="stripe display" cellspacing="0" width="100%">
          <thead>
            <tr>
              <th>Acción</th>
              <th>Código</th>
              <th>Nombre</th>
              <th>Descripción</th>
              <th>Costo</th>
            </tr>
          </thead>
          <tbody>
            <%if(lista.size()>0){ %>
            <%for(BeanServicio servicio:lista){ %>
              <tr>
                <td> <a class="linkIcon edit" href='<%=request.getContextPath()%>/servicio?opcion=editar&id=<%=servicio.getIdservicio()%>'><span class="icon-edit"></span></a> 
                  <a class="linkIcon delete" href='<%=request.getContextPath()%>/servicio?opcion=eliminar&id=<%=servicio.getIdservicio() %>' onClick="return confirm('¿Desea eliminar este servicio: <%=servicio.getNomservicio()%>?')"><span class="icon-cross"></span></a></td>
                <td><%=servicio.getIdservicio() %></td>
                <td><%=servicio.getNomservicio() %></td>
                <td><%=servicio.getDescripcion() %></td>
                <td><%=servicio.getCosto() %></td>
              </tr>
            <%} %>
            <%} %>
          </tbody>
      
        </table>
      
      </div>   </div>
    
  
</div>

<%@ include file="footer.jsp" %>



</body>
</html>