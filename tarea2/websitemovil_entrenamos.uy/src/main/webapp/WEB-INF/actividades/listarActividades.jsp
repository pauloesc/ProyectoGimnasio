<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicadores.DataActividad"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	List<DataActividad> acts = (List<DataActividad>) request.getAttribute("actividades");
%>

<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-12 col-md-8 my-4">
				<div class="card-group">
				<% 
				Iterator<DataActividad> iterac = acts.iterator();
				for (int i = 1; i < acts.size(); i++) {
					DataActividad acti = iterac.next();
				%>	
					<div class="card">
					<% if (acti.getImagen() == null) { %>
						<img src="imagenes?id=sinimagen.jpg" alt="No tiene imagen.">
					<% } else {  %>
						<img src="imagenes?id=<%= acti.getImagen() %>" class="card-img-top" alt="<%= acti.getNombre() %>">
					<% } %>
						<div class="card-body">
							<h5 class="card-title">
								<a href="consultaActividad?actividad=<%= acti.getNombre() %>" class=""><%= acti.getNombre() %></a>
							</h5>
							<p class="card-text"><%= acti.getDescripcion() %></p>
						</div>
					</div>
				<% 
					}
				%>
				</div>
			</div>
		</div>
	</main>

	<footer class="footer">
		<div class="container">
			<span class="text-muted">Copyright 2021 - Entrenamos.uy</span>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
