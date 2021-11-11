<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
	
	<div class="page-wrap d-flex flex-row align-items-center">
    	<div class="container">
	        <div class="row justify-content-center">
	            <div class="col-md-12 text-center">
	                <span class="display-1 d-block">500 Internal Server Error</span>
	                <div class="mb-4 lead">El servidor tuvo un problema para procesar tu solicitud.</div>
	                <a href=${pageContext.request.contextPath}/home class="btn btn-link">Volver a Home</a>
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