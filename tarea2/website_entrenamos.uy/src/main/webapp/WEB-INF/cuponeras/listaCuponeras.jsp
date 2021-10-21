<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="logica.DataCuponera"%>

<%@page import="java.util.Set"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	Integer total= (Integer) request.getAttribute("totalcups");
	Set<DataCuponera> cups=(Set<DataCuponera>) request.getAttribute("cups");
	DataCuponera[]  cupsar= cups.toArray(new DataCuponera[total]);
    Integer pagnum= (Integer) request.getAttribute("pag");
    
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
								<h5 class="card-title">Pelotas</h5>
								<p class="card-text">Deportes con Pelota.</p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href="consultaCuponera.html" class="btn btn-primary">Detalles</a>
									<a href=# class="btn btn-primary mt-2" data-toggle="modal" data-target="#comprar">Comprar</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">
						<div class="col-md-4 text-center">
							<img src="./resources/img/b2.jpg"  alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Gimnasia</h5>
								<p class="card-text">Aeróbica y aparatos.</p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href=# class="btn btn-primary">Detalles</a>
									<a href=# class="btn btn-primary mt-2" data-toggle="modal" data-target="#comprar">Comprar</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">
						<div class="col-md-4 text-center">
							<img src="./resources/img/b2.jpg"  alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Gimnasia</h5>
								<p class="card-text">Aeróbica y aparatos.</p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href=# class="btn btn-primary">Detalles</a>
									<a href=# class="btn btn-primary mt-2" data-toggle="modal" data-target="#comprar">Comprar</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">
						<div class="col-md-4 text-center">
							<img src="./resources/img/b2.jpg"  alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">Gimnasia</h5>
								<p class="card-text">Aeróbica y aparatos.</p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href=# class="btn btn-primary">Detalles</a>
									<a href=# class="btn btn-primary mt-2" data-toggle="modal" data-target="#comprar">Comprar</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="d-md-flex justify-content-md-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<% for (int i2=1; i2<5;i2++) { 
							%>
							<li class="page-item"><a class="page-link" href="#"><%=i2%></a></li>
							<%}%>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>

		<!-- Modal -->
<div class="modal fade" id="comprar" tabindex="-1" role="dialog" aria-labelledby="comprarLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form >
                <div class="modal-header">
                    <h5 class="modal-title" id="comprarLabel">Confirmar la compra de la cuponera</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
              <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="button" data-dismiss="modal" class="btn btn-primary" data-toggle="modal" data-target="#exito">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</div>
		<div class="modal fade" id="exito" tabindex="-1" role="dialog" aria-labelledby="exitoLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form >
                <div class="modal-header">
                    <h5 class="modal-title text-success" id="comprarLabel">La compra fue exitosa</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
              <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                </div>
            </form>
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