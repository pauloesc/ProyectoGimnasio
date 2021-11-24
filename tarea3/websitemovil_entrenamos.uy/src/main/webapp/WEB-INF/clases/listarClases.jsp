<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicadores.DtClase"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	List<DtClase> clases = (List<DtClase>) request.getAttribute("clases");
%>

<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	
<main role="main" class="container">
<div class="row">
	<div class="col-12 col-md-8 my-4">
	<h3> <i>Clses</i></h3>
	</div>
</div>

		
		<section id="gallery">
<div class="container">
<div class="row">
  
 <% 
for( DtClase varActivv : clases  ){
	DtClase auxiliarActividad =  varActivv;
%>

<div class="col-lg-4 col-md-6 col-sm-6">
<div class="card">
<% if (auxiliarActividad.getImagen() == null) { %>
<a class="" href="consultaClase?clase=<%= auxiliarActividad.getNombre()  %>">
<img src="imagenes?id=" alt="" class="card-img-top">
</a>
<% } else { %>
<a class="" href="consultaClase?clase=<%= auxiliarActividad.getNombre()  %>">
<img src="imagenes?id=<%= auxiliarActividad.getImagen() %>" alt="" class="card-img-top">
</a>
<% } %>
<div class="card-body">
<h5 class="card-title"><a class="" href="consultaClase?clase=<%= auxiliarActividad.getNombre()  %>"><%= auxiliarActividad.getNombre()  %></a></h5>
</div>
</div>
</div>

<% } %>

</div>
</div>
</section>
		
		
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
