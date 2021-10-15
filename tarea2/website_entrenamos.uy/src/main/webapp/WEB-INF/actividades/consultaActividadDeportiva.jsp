<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="logica.DataActividad"%>
<%@page import="logica.InfoBasicaUser"%>
<%@page import="logica.InfoBasicaSocio"%>
<%@page import="controladores.Login"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	DataActividad actividad = (DataActividad) request.getAttribute("actividad");

	InfoBasicaUser usr;
	try {
		usr = Login.getUsuarioLogueado(request);
	} 
	catch(Exception ex) {
		usr = null;
	}
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">
						<div class="col-md-4">
							<img class="d-block w-100" src="./resources/img/actividades/<%= actividad.getImagen()  %>" alt="<%= actividad.getImagen()  %>">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h1 class="card-title"><%= actividad.getNombre()  %></h1>
								<p class="card-text"><%= actividad.getDescripcion()  %></p>
								<div class="categorias">
									<span class="badge badge-info">Deportes</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<% if (usr instanceof InfoBasicaSocio) { %>
				<div class="offset-3 col-8 mb-3">
					<a  class="btn btn-primary" href="consultaCuponera1.html">Comprar Cuponera</a>
					<a class="btn btn-primary" href="registroDictadoDeClases.html">Registrarse a Clase</a>
				</div>
				<% } %>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="detalles-tab" data-toggle="tab"
						href="#detalles" role="tab" aria-controls="detalles"
						aria-selected="true">Detalles</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="cuponeras-tab" data-toggle="tab" href="#cuponeras" role="tab"
						aria-controls="cuponeras" aria-selected="false">Cuponeras</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="clases-tab" data-toggle="tab" href="#clases" role="tab"
						aria-controls="clases" aria-selected="false">Clases</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="detalles"
						role="tabpanel" aria-labelledby="detalles-tab">
						<div class="m-3">
						<p>Institución Deportiva: <%= actividad.getInstitucion() %></p>
						<p>Profesor: <%= actividad.getProfesor() %></p>
						<p>Costo: $<%= actividad.getCosto()  %></p>
						<p>Duración: <%= actividad.getDuracion()  %> minutos</p>
						</div>
					</div>
					<div class="tab-pane fade" id="cuponeras" role="tabpanel"
						aria-labelledby="cuponeras-tab">
						<p class="card-text m-3"><a href="consultaCuponera.html">Pelota</a></p>
						
					</div>
					<div class="tab-pane fade" id="clases" role="tabpanel"
						aria-labelledby="clases-tab">
						<p class="card-text m-3"><a href="consultaDictadoDeClases.html">Voleibol</a></p>
						<p class="card-text m-3"><a href="#">Braza</a></p>
						<p class="card-text m-3"><a href="#">Mariposa</a></p>
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