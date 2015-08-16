<header> 
<%@ page import="pe.AA.com.Bean.*" %>
<%BeanUsuario usuario = (BeanUsuario) request.getSession().getAttribute("usuario"); %>
	   <div class	="container">
	   		<div class="row">
	   			<div class="col-md-10 col-sm-10 col-xs-9">
	   				<h1>Sistema de Atención Odontológica</h1>
	   				
	   			</div>
	   			<div class="col-md-2 col-sm-2 col-xs-3">
	   				<%if(usuario!=null){ %>
	   					<h4>Bienvenido: <%=usuario.getPersona().getNom() %></h4>
	   				<%}else{ %>
	   					<script type="text/javascript">
	   						window.location.href="index.jsp";
	   					</script>
	   				<%} %>
	   			</div>
	   		</div>
            
            
            <div class="row">
       			<div class="col-md-10 col-md-offset-1">
       				<%@ include file="sidebar.jsp" %>
       			</div>
				
			</div>  
      
             
       </div>
</header>