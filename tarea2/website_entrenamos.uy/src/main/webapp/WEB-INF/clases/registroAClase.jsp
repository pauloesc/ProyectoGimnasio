<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaClase"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	String nomC = (String)request.getAttribute("nomC");
	String fecha = (String)request.getAttribute("fecha");
	Set<String> cups = (Set<String>)request.getAttribute("nomCups");

%>
</head>

<%  %>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
		<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
			<h1>Registro a Dictado de Clases</h1>
					
					<div class="container" style="margin-top: 14px; margin-bottom: 14px;">
						<div class="row">
							<h1>Nombre: <%= nomC  %> </h1>
							<h1>Fecha y Hora: <%= fecha  %> </h1>
							<div class="col-4">
								<label><input type="checkbox" id="cbox1"
									value="first_checkbox"> Cuponera</label><br>
							</div>

							<div class="col-4">
								<select id="cuponeras" name="cuponeras"
									class="custom-select" required="required">
									<% 
									for(String nomcup :cups) {
									%>	
			   						
										<option value=<%= nomcup  %>><%= nomcup  %></option>
									<%
									} 
									%>
			    		
								</select>
								
								
								
							</div>

						</div>
					</div>

					<div class="form-group row">
						<div class="offset-4 col-8">
							<button name="submit" type="submit" class="btn btn-primary">Confirmar</button>
						</div>
					</div>

			</div>
		</div>
	</main>

	<footer class="footer">
		<div class="container">
			<span class="text-muted">Copyright 2021 - Entrenamos.uy</span>
		</div>
	</footer>

	<script>
	  $(function () {
	    $('#myTab li:last-child a').tab('show')
	  })
	</script>

	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>