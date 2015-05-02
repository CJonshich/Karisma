<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>
<%@page import="pe.AA.com.Bean.*" %>
<%@ page import="java.util.List" %>
<%List<BeanDistrito>lista = (List<BeanDistrito>) request.getAttribute("listadistrito"); %>
<%BeanPaciente paciente = (BeanPaciente) request.getAttribute("pacienteEdit"); %>

  <%@ include file="header.jsp" %>
   
   <div class="container"> 


            <div class="col-md-12 text-center" style="margin-bottom:20px;"><h3>Editar Paciente</h3></div>
    
            
                <form name="APaciente" id="FormEPaciente" method="post" action="paciente" class="form-horizontal" >
               <!--Hidden para mandar según opción al servlet-->
                  <input type="hidden" value="editar" name="opcion" id="opcion">
                  <input type="hidden" id="id" name="id" value="<%=paciente.getPersona().getIdpersona()%>"> 
                 <!-- Uso un div para cada celda, experimento n°1--> 
                  <div class="form-group">
                    <label for="txtnombres" class="control-label col-md-2">Nombres</label>
                      <div class="col-md-10">
                        <input type="text" id="txtnombres" name="txtnombres" class="form-control"  value="<%=paciente.getPersona().getNom()%>">
                      </div>
                  </div>
                  
                  <div class="form-group">
                    <label for="txtapePat" class="control-label col-md-2">Apellido Paterno</label>
                      <div class="col-md-10">
                        <input type="text" id="txtapePat" name="txtapePat" class="form-control" value="<%=paciente.getPersona().getApePat()%>">
                      </div>
                  </div>
                  
                  <div class="form-group">
                    <label for="txtapeMat" class="control-label col-md-2">Apellido Materno</label>
                      <div class="col-md-10">
                        <input type="text" id="txtapeMat" name="txtapeMat" class="form-control" value="<%=paciente.getPersona().getApeMat()%>">
                      </div>
                  </div>
                   
                  <div class="form-group">
                    <label for="txtdni" class="control-label col-md-2">DNI</label>
                      <div class="col-md-10">
                        <input type="text" id="txtdni" name="txtdni" maxlength="8" class="form-control" value="<%=paciente.getPersona().getDni()%>">
                      </div>
                  </div>
                    
                    
                  <div class="form-group">
                    <label for="txtfecha" class="control-label col-md-2">Fecha de Nacimiento</label>
                    <div class="col-md-10">
                      <div class="input-group">
                        <input type="text" id="txtfecha" name="txtfecha" readonly  class="form-control date-picker" value="<%=paciente.getPersona().getFecNac()%>">
                        <label for="txtfecha" class="input-group-addon btn"><span class="glyphicon glyphicon-calendar"></span>
                      </div>
                    </div>
                  </div>
                    

                  <div class="form-group">
                    <label class="control-label col-md-2"> Sexo</label>
                      <div class="col-md-2">
                         <label class="radio-inline">
                          <input name="rdbsexo" id="rdbsexo" type="radio" value="M" <%="M".equals(paciente.getPersona().getSexo())?"checked":""%> >Masculino
                         </label>
                       </div> 
                       <div class="col-md-2"> 
                         <label class="radio-inline">
                          <input name="rdbsexo" id="rdbsexo"type="radio" value="F" <%="F".equals(paciente.getPersona().getSexo())?"checked":""%> >Femenino
                         </label>
                        </div>      
                  </div> 

                  <div class="form-group">
                    <label for="txtdomicilio" class="control-label col-md-2">Domicilio</label>
                    <div class="col-md-10">
                      <input type="text" id="txtdomicilio" name="txtdomicilio" class="form-control" value="<%=paciente.getPersona().getDomicilio()%>" >  
                    </div>
                  </div>

                  <div class="form-group"> 
                    <label class="control-label col-md-2">Distrito</label>
                    <div class="col-md-10">
                      <select name="sel_distrito" class="form-control">
                        <%for(BeanDistrito distrito:lista) {%>
                    	<%int distritoCad=distrito.getIddistrito(); %>
                    	<%if(distritoCad==paciente.getPersona().getDistrito().getIddistrito()) {%>
                          	<option value=<%=distrito.getIddistrito()%> selected ><%=distrito.getNomdistrito() %></option>
                       <%} else{%>
                       		<option value=<%=distrito.getIddistrito()%>  ><%=distrito.getNomdistrito() %></option>
                       <%} %>
                       <%} %>
                      </select>
                    </div>
                  </div>   

                  <div class="form-group">
                    <label for="txttelefono" class="control-label col-md-2">Telefono</label>
                    <div class="col-md-10">
                      <input type="text" id="txttelefono" name="txttelefono" class="form-control" maxlength="9" value="<%=paciente.getPersona().getTelefono() %>" >
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="txtemail" class="control-label col-md-2">E-mail</label>
                    <div class="col-md-10">
                      <input type="email" id="txtemail" name="txtemail" required class="form-control" value="<%=paciente.getPersona().getEmail()%>">
                    </div>
                  </div>  

                  <div class="form-group">
                    <label for="txttalla" class="control-label col-md-2">Talla</label>
                    <div class="col-md-10">
                      
                     <div class="input-group">
                        <input type="text" id="txttalla" name="txttalla" maxlength="4" class="form-control" value="<%=paciente.getTalla()%>">
                        <span class="input-group-addon">m.</span>
                      </div>
                    </div>
                  </div>  

                  <div class="form-group">  
                    <label for="txtpeso" class="control-label col-md-2">Peso</label>
                    <div class="col-md-10">

                     <div class="input-group">
                        <input type="txtpeso" id="txtpeso" name="txtpeso" maxlength="6" class="form-control" value="<%=paciente.getPeso()%>">
                        <span class="input-group-addon">Kg.</span>
                     </div>
                    
                    </div>
                  </div>

                  <div class="form-group">
                    <label class="control-label col-md-2">Grupo Sanguíneo</label>
                    <div class="col-md-10">
                      <select name="sel_GSangre" class="form-control">
                      <option value="A+" <%="A+".equals(paciente.getTipoSangre())?"selected":""%> >A+</option>
                      <option value="A-"<%="A-".equals(paciente.getTipoSangre())?"selected":""%> >A-</option>
                      <option value="B+"<%="B+".equals(paciente.getTipoSangre())?"selected":""%> >B+</option>
                      <option value="B-"<%="B-".equals(paciente.getTipoSangre())?"selected":""%> >B-</option>
                      <option value="AB+"<%="AB+".equals(paciente.getTipoSangre())?"selected":""%> >AB+</option>
                      <option value="AB-"<%="AB-".equals(paciente.getTipoSangre())?"selected":""%>>AB-</option>
                      <option value="O+"<%="O+".equals(paciente.getTipoSangre())?"selected":""%>>O+</option>
                      <option value="O-"<%="O-".equals(paciente.getTipoSangre())?"selected":""%>>O-</option>
                    <select>
                    </div>
                  </div>    
                  
                    
                  <div class="form-group">
                    <div class="col-md-2 col-md-offset-7">
                      <input type="submit" name="Editar" id="Editar" value="Editar" class="btn btn-info" style="width:100%;margin-top:10px;">
                    </div>
                    <div class="col-md-2 col-md-offset-1">
                      <input type="button" name="Cancelar" id="Cancelar" value="Cancelar" class="btn btn-info" style="width:100%;margin-top:10px;">
                    </div>
                  </div>

                
                </form>
            

    
   </div>    


 
   <%@ include file="footer.jsp" %>


<script> 
$(function(){  
        
        $('#txtdni').validCampoFranz('0123456789');
        $('#txtnombres').validCampoFranz('qwertyuiopasdfghjklñzxcvbnm ');
        $('#txtapePat').validCampoFranz('qwertyuiopasdfghjklñzxcvbnm');
        $('#txtapeMat').validCampoFranz('qwertyuiopasdfghjklñzxcvbnm');
        $('#txtpeso').validCampoFranz('1234567890.');
        $('#txttelefono').validCampoFranz('1234567890');
        $('#txttalla').validCampoFranz('1234567890.');
        
            });
</script>

<script>
  $(document).ready(function(){
    $("#Cancelar").click(function(){
      
      var response = confirm("¿Desea cancelar la operación?")
      if(response==true){
        window.location.href='<%=request.getContextPath()%>/paciente?opcion=listar';
      }else{
      return false; 
      } 
      
      });
    });
</script>


</body>
</html>