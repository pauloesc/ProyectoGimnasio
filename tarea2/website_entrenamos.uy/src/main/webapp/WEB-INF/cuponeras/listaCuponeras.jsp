<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="logica.DataCuponera"%>

<%@page import="java.util.Set"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	
    String sel= (String) request.getAttribute("cu");
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8">
				<h2>Cuponeras de actividades deportivas</h2>

				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">					
						<div class="col-md-4 text-center">
							<img src="./resources/img/b1.jpg" alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><%=sel%></h5>
								<p class="card-text">Deportes con Pelota.</p>
								
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

	

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>