<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE >
<html>
<%@ include file="head.jsp"%>
<body>
<%String mensaje = (String) request.getAttribute("mensaje"); %>
<%@ include file="header.jsp" %>

   <div class="container contenidos">
   	<div class="col-md-12 col-sm-12 text-center" style="margin-top:10%">
   			<div>
   				<h1> <%=mensaje %></h1>
   			</div>
   	</div>
   
   </div>
   	
    

<%@include file="footer.jsp"%>
</div>
</body>
</html>