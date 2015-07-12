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
  <div class="contenidos">
    <div class="botonContainer"> 
          <a class="botonCSS" href="#" data-toggle="modal" data-target="#modal_servicio">
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
                  <a class="linkIcon delete" href='<%=request.getContextPath()%>/servicio?opcion=eliminar&id=<%=servicio.getIdservicio() %>' onClick="return confirm('Â¿Desea eliminar este servicio: <%=servicio.getNomservicio()%>?')"><span class="icon-cross"></span></a></td>
                <td><%=servicio.getIdservicio() %></td>
                <td><%=servicio.getNomservicio() %></td>
                <td><%=servicio.getDescripcion() %></td>
                <td><%=servicio.getCosto() %></td>
              </tr>
            <%} %>
            <%} %>
        </tbody>
      
      </table>
    </div>
    <div class="modal fade" id="modal_servicio" tabindex="-1" role="dialog" aria-labelledby="modal_servicio" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal"
              aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
            <h4 class="modal-title"> Agregar Servicio</h4>

            </div>
            <div class="modal-body">
              <form id="form_servicio" action="servicio" method="post" >
                <input type="hidden" id="txtCodservicio" name="txtCodservicio">
                <input type="hidden" id="opcion" name="opcion" >
                <div class="form-group">
                  <label for="txtNombre" class="control-label">Nombre</label>
                  <input type="text" id="txtNombre" name="txtNombre" class="form-control">
                </div>

                <div class="form-group">
                  <label for="txaDescripcion" class="control-label">Descripción</label>
                  <textarea name="txaDescripcion" id="txaDescripcion" cols="" rows=""class="form-control"></textarea>
                </div>
                
                <div class="form-group">
                  <label for="txtCosto" class="contro-label">Costo</label>
                  <input type="text" class="form-control" id="txtCosto" name="txtCosto">
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
              <button type="button" class="btn btn-info" id="btn_guardar_ser">Guardar</button>
            </div>
          </div>
        </div>  
    </div>  


  </div>
</div>

<%@ include file="footer.jsp" %>



</body>
</html>