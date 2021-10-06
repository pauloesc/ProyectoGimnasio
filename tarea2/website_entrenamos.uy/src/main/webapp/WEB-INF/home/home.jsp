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
		<div class="row">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8">
				<div class="row py-4">
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
								<img src="./resources/img/3.jpg" class="d-block" alt="...">
							</div>
							<div class="carousel-item">
								<img src="./resources/img/1.jpg" class="d-block"
									alt="Jiu-Jitsu">
							</div>
							<div class="carousel-item">
								<img src="./resources/img/2.jpg" class="d-block" alt="...">
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
				<div class="row y-4">
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Pelotas</h5>
								<p class="card-text">Deportes con Pelotas</p>
								<a href="consultaCuponera.html" class="btn btn-primary">Ver mas</a>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Gimnasia</h5>
								<p class="card-text">Aeróbica y aparatos</p>
								<a href="#" class="btn btn-primary">Ver mas</a>
							</div>
						</div>
					</div>
					<div class="col-sm-12">
					<table class="table table-sm mt-3 text-right" >
  							<thead>
    							<tr>
     							 <th scope="col"> <a href="consultaCuponera1.html">Ver todas las cuponeras</a></th>
    							</tr>
  							</thead>  			
					</table>
					</div>
				</div>
		
				<div class="card-group my-4">
					<div class="card">
						<img src="./resources/img/a1.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								<a href="consultaActividadDeportiva.html" class="">Voleibol</a>
							</h5>
							<p class="card-text">Voleibol en todas sus formas.</p>
						</div>
					</div>
					<div class="card">
						<img src="./resources/img/a2.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								<a href="#" class="">Atletismo</a>
							</h5>
							<p class="card-text">100m , 200m, postas y carreras con obstaculos.</p>
						</div>
					</div>
					<div class="card">
						<img src="./resources/img/a3.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								<a href="#" class="">Basquetbol</a>
							</h5>
							<p class="card-text">Basquetbol para todos.</p>
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