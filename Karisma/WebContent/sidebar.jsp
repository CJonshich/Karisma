<nav>
<ul>
	
    <li class="submenu">
    <a href="#">Citas<span class="caretCSS icon-chevron-small-down"></span></a>
    	
        <ul class="children"> 
        	<li><a href="<%=request.getContextPath()%>/cita?opcion=agregar">Generar Cita</a></li>
    		<li><a href="<%=request.getContextPath()%>/cita?opcion=actualizar">Actualizar Cita</a></li>
     	</ul>
        
     </li>
     
    <li class="submenu">
    <a href="#">Historial Clinico<span class="caretCSS icon-chevron-small-down"></span></a>
     	<ul class="children">
        	<li><a href="<%=request.getContextPath()%>/historialC?opcion=generar">Generar Historial Cl�nico</a></li>
            <li><a href="<%=request.getContextPath()%>/historialC?opcion=mostrar">A�adir Historia Cl�nica</a></li>
        </ul>
    </li>
        
    <li class="submenu">
    <a href="#">Orden de Pago<span class="caretCSS icon-chevron-small-down"></span></a>
     	<ul class="children">
        	<li><a href="<%=request.getContextPath()%>/ordenP?opcion=generar">Generar Orden de Pago</a></li>
        </ul>
    </li>
        
    <li class="submenu"><a href="#">Mantenimiento<span class="caretCSS icon-chevron-small-down"></span></a>
     	<ul class="children">
       	  <li><a href="<%=request.getContextPath()%>/paciente?opcion=listar">Pacientes</a></li>
          <li><a href="<%=request.getContextPath()%>/odontologo?opcion=listar">Odontologos</a></li>
          <li><a href="<%=request.getContextPath()%>/servicio?opcion=listar">Servicios 
        Odontol�gicos</a></li>
    	</ul>
    </li>
    
     <li><a href="<%=request.getContextPath()%>/empleado">Cerrar Sesi�n</a></li>

</ul>

</nav>
