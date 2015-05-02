<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp"%>
<body>

  <%@ include file="header.jsp" %>
    <div class="container contenidos" style="margin-top:20px">

    <table width="1000" border="0" class="TCita">
    <tr>
    <td colspan="4"><h1 class="titulo">A&ntilde;adir Historia Clinica</h1></td>
    </tr>
  <tr>
    <td colspan="4"><span class="label">Datos del Paciente </span> <hr color="#000000"></td>
    </tr>
  <form name="BPaciente" id="BPaciente" action="paciente" method="post" target="Buscar Paciente" onSubmit="window.open('','Buscar Paciente','toolbar=no,location=no,menubar=no,scrollbars=yes,height=300,width=600')">
  <tr>
    <td width="204"><span class="label">DNI</span></td>
    <td width="332" bgcolor="#A5EAFB"><label for="txtdni"></label>
      <input name="txtdni" type="text" id="txtdni" maxlength="8"  required></td>
    <td width="227"><input name="btnBuscarP" type="submit" class="boton" id="btnBuscarP" value="Buscar Paciente"></td>
    <td width="219" bgcolor="#A5EAFB"><input type="hidden" name="opcion" id="opcion" value="buscar"></td>
  </tr>
  </form>
  <form name="ActHClinico" id="ActHclinico" method="post" action="historialC">
  <tr>
    <td><span class="label">Nombres</span></td>
    <td bgcolor="#A5EAFB"><label for="txtnombre"></label>
      <input type="text" name="txtnombre" id="txtnombre" readonly></td>
    <td><p class="label">Fecha</p></td>
    <td bgcolor="#A5EAFB"><label for="txtfecha"></label>
      <input name="txtfecha" type="text" class="textfield" id="txtfecha"  required></td>
  </tr>
  <tr>
    <td><span class="label">Apellido Paterno</span></td>
    <td bgcolor="#A5EAFB"><label for="txtapePat"></label>
      <input type="text" name="txtapepat" id="txtapePat"readonly></td>
    <td><p class="label">Hora </p></td>
    <td bgcolor="#A5EAFB"><label for="tm_Hora"></label>
      <input name="tm_Hora" type="time" class="textfield" id="tm_Hora" required min="09:00:00" max="21:00:00" step="1"></td>
  </tr>
  <tr>
    <td><span class="label">Apellido Materno</span></td>
    <td bgcolor="#A5EAFB"><label for="txtapeMat"></label>
      <input type="text" name="txtapemat" id="txtapeMat" readonly></td>
    <td>&nbsp;</td>
    <td bgcolor="#A5EAFB">&nbsp;</td>
  </tr>
  <tr>
    <td><span class="label">Odontologo</span></td>
    <td bgcolor="#A5EAFB"><label for="txtodontologo"></label>
      <input name="txtodontologo" type="text" class="textfield" id="txtodontologo" readonly></td>
    <td><input name="btnBOdontologo" type="button" class="boton" id="btnBOdontologo" value="Buscar Odontologo" onClick="buscarOdontologo()"></td>
    <td bgcolor="#A5EAFB">&nbsp;</td>
  </tr>
  
  <tr>
    <td><span class="label">Servicio</span></td>
    <td bgcolor="#A5EAFB"><label for="txtservicio"></label>
      <input type="text" name="txtservicio" id="txtservicio" class="textfield" readonly></td>
    <td align="center"><input type="submit" name="btnBServicio" id="btnBServicio" value="Buscar Servicio" onClick="buscarServicio()" class="boton"></td>
    <td align="center" bgcolor="#A5EAFB">&nbsp;</td>
  </tr>
  <tr>
    <td><span class="label">Cantidad</span></td>
    <td bgcolor="#A5EAFB"><label for="txtcantidad"></label>
      <input type="text" name="txtcantidad" id="txtcantidad" class="textfield"></td>
    <td align="center">&nbsp;</td>
    <td align="center" bgcolor="#A5EAFB">&nbsp;</td>
  </tr>
  <tr>
    <td><span class="label">Observaci&oacute;n</span></td>
    <td bgcolor="#A5EAFB"><label for="txaObservacion"></label>
      <textarea name="txaObservacion" cols="50" rows="5" id="txaObservacion"></textarea></td>
    <td colspan="2" align="center">&nbsp;</td>
  </tr>
  <tr>
    <td>
   	<input type="hidden" name="idpaciente" id="idpaciente">
    <input type="hidden" name="idodontologo" id="idodontologo"></td>
    <td bgcolor="#A5EAFB"><input type="hidden" name="txtfecNac" id="txtfecNac"><input type="hidden" name="txttalla" id="txttalla">

<input type="hidden" name="txtGSanguineo" id="txtGSanguineo">      
<input type="hidden" name="txtpeso" id="txtpeso">			
<input type="hidden" name="txtsexo" id="txtsexo">
<input name="dni" type="hidden" value="" id="dni">
<input type="hidden" name="opcion" id="opcion" value="mostrar">
      </td>
    <td colspan="2" align="center"><input name="btnActualizar" type="submit" class="boton" id="btnActualizar" value="Siguiente">
      <input name="btnLimpiar" type="reset" class="boton" id="btnLimpiar" value="Limpiar">
      <input name="btnCancelar" type="button" class="boton" id="btnCancelar" value="Cancelar"></td>
    </tr>
  </form>
</table>

    </div>
    <%@ include file="footer.jsp" %>




<!--Scripts-->
<script> 
$(function(){  
        
                $('#txtdni').validCampoFranz('0123456789');
        $('#txtcantidad').validCampoFranz('123456789');
        
            });</script>
            
<script type="text/javascript" src="js/calendario.js"> </script>

<script type="text/javascript">
  
  function buscarOdontologo(){
    window.open('odontologo?opcion=buscar','Buscar Odontologo','toolbar=no,location=no,menubar=no,scrollbars=yes,height=300,width=600')
    
    }
</script>
<script type="text/javascript">
  
  function buscarServicio(){
    window.open('servicio?opcion=buscar','Buscar Servicio','toolbar=no,location=no,menubar=no,scrollbars=yes,height=300,width=600')
    
    }
</script>
</body>
</html>