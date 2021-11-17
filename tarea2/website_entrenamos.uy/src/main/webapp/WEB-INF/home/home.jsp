<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="publicadores.DataCuponera"%>
<%@page import="publicadores.DataActividad"%>
<%@page import="java.util.Iterator"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	List<DataCuponera> cuponeras= (List<DataCuponera>) request.getAttribute("cuponeras");
	
	Set<DataActividad> actividades = (Set<DataActividad>) request.getAttribute("actividades");
%>


<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8">
				<div class="row py-4">
				<div class="col-12 col-md-10 offset-md-1">
					<div id="carouselExampleCaptions" class="carousel slide mx-auto"
						data-ride="carousel">
						<ol class="carousel-indicators">
							<li data-target="#carouselExampleCaptions" data-slide-to="0"
								class="active"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
							<li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
						</ol>
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="imagenes?id=3.jpg" class="d-block img-responsive" alt="...">
							</div>
							<div class="carousel-item">
								<img src="imagenes?id=1.jpg" class="d-block img-responsive" alt="Jiu-Jitsu">
							</div>
							<div class="carousel-item">
								<img src="imagenes?id=2.jpg" class="d-block img-responsive" alt="...">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleCaptions"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleCaptions"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
					</div>
				</div>
				<div class="row y-4">
				<% 
				Iterator<DataCuponera> iter=cuponeras.iterator();
				DataCuponera nomcup= iter.next();
				%>	
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title"><%= nomcup.getNombre() %></h5>
								<p class="card-text"><%= nomcup.getDescripcion() %></p>
								<a class="btn btn-primary" href="consultaCuponera?cuponera=<%= nomcup.getNombre()  %>">Ver mas</a>
							</div>
						</div>
					</div>
					<% 
					nomcup=iter.next();
					%>	
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title"><%= nomcup.getNombre() %></h5>
								<p class="card-text"><%= nomcup.getDescripcion() %></p>
								<a class="btn btn-primary" href="consultaCuponera?cuponera=<%= nomcup.getNombre() %>">Ver mas</a>
							</div>
						</div>
					</div>
								
					
					
					<div class="col-sm-12">
					<table class="table table-sm mt-3 text-right" >
  							<thead>
    							<tr>
     							 <th scope="col"> <a href="listaCuponeras?n=<%=1 %>">Ver todas las cuponeras</a></th>
    							</tr>
  							</thead>  			
					</table>
					</div>
				</div>
		
				<div class="card-group my-4">
				<% 
				Iterator<DataActividad> iterac = actividades.iterator();
				for (int i = 1; i < 4; i++) {
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