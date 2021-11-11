<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaClase"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	String nom = (String)request.getAttribute("nom");
	String nomP = (String)request.getAttribute("nomP");
	String act = (String)request.getAttribute("act");
	String fecha = (String)request.getAttribute("fecha");
	String hor = (String)request.getAttribute("hor");
	String min = (String)request.getAttribute("min");
	String url = (String)request.getAttribute("url");
	String img = (String)request.getAttribute("img");
	String socio = (String)request.getAttribute("socio");
	String costo = (String)request.getAttribute("costoClase");

	//paulo
	int minS  = (int) request.getAttribute("minS");
	int actS = (int) request.getAttribute("actuS");
	int maxS = (int) request.getAttribute("maxS");
	String fechaReg = (String) request.getAttribute("fechaReg");
	//paulo
	
%>
</head>

<% 	%>
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
								<img src="./resources/img/clases/<%=img%>" width="240"
									height="160" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title"><%= nom %></h5>
									<p class="card-text"> <p class="card-text m-0"><a href="consultaActividad?actividad=<%= act%>">Ver información de la actividad deportiva</a></p> 
									
									<% if (socio == "T") {%>
									<p class="card-text"> <p class="card-text m-0"><a href="registroAClase?clase=<%= nom%>">Registrarme a la clase</a></p> 
									<%}%>
									
									
								</div>
							</div>
						</div>
					</div>
					
					<div class="card mb-3" style="max-width: auto;">
						<div class="row no-gutters">
							
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">Información Adicional</h5>
									
									<!-- agregar que te mande a la pagina de consultar usuario con el profesor cuando este lista -->
									<p class="card-text"> <p class="card-text m-0"><a href="consultaUsuario?usuarioNick=<%= nomP %> ">Dictada por: <%= nomP %></a></p> 
									
									<p class="card-text"> <p class="card-text m-0">Fecha y hora: <%= fecha %></p> 
									<p class="card-text"> <p class="card-text m-0">Costo: <%= "$" + costo %></p>
									<p class="card-text"> <p class="card-text m-0">URL:: <%= url %></p> 
									<p class="card-text"> <p class="card-text m-0">Socios:: Min: <%=minS%>, Actual: <%=actS%>, Max: <%=maxS%> </p> 
									<p class="card-text"> <p class="card-text m-0">Fecha Registro clase: <%=fechaReg%></p>
								</div>
							</div>
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