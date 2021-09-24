<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<title>entrenamos.uy</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-6 col-md-4">
				<ul id="listaActividades" class="list-group my-4">
					<li class="list-group-item"><strong>Instituciones
							Deportivas</strong></li>
					<li class="list-group-item"><a
						href="consultaInstitucionDeportiva.html" class="">Telon</a></li>
					<li class="list-group-item"><a
						href="consultaInstitucionDeportiva.html" class="">Instituto
							Natural</a></li>
					<li class="list-group-item"><a
						href="consultaInstitucionDeportiva.html" class="">Olympic</a></li>
					<li class="list-group-item"><a
						href="consultaInstitucionDeportiva.html" class="">Fuerza Bruta</a></li>
				</ul>
				<ul id="listaCategorias" class="list-group my-4">
					<li class="list-group-item"><strong>Categorías</strong></li>
					<li class="list-group-item">Al aire libre</li>
					<li class="list-group-item">Fitness</li>
					<li class="list-group-item">Football</li>
					<li class="list-group-item">Artes Marciales</li>
				</ul>
			</div>
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
								<img src="./resources/img/3.jpg" class="d-block w-100" alt="...">
							</div>
							<div class="carousel-item">
								<img src="./resources/img/1.jpg" class="d-block w-100"
									alt="Jiu-Jitsu">
							</div>
							<div class="carousel-item">
								<img src="./resources/img/2.jpg" class="d-block w-100" alt="...">
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
								<h5 class="card-title">Cuponera 1</h5>
								<p class="card-text">With supporting text below as a natural
									lead-in to additional content.</p>
								<a href="#" class="btn btn-primary">Ver mas</a>
							</div>
						</div>
					</div>
					<div class="col-sm-6">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Cuponera 2</h5>
								<p class="card-text">With supporting text below as a natural
									lead-in to additional content.</p>
								<a href="#" class="btn btn-primary">Ver mas</a>
							</div>
						</div>
					</div>
				</div>
				<div class="card-group my-4">
					<div class="card">
						<img src="./resources/img/a1.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								<a href="consultaActividadDeportiva.html" class="">Actividad
									1</a>
							</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This
								content is a little bit longer.</p>
						</div>
					</div>
					<div class="card">
						<img src="./resources/img/a2.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								<a href="consultaActividadDeportiva.html" class="">Actividad
									2</a>
							</h5>
							<p class="card-text">This card has supporting text below as a
								natural lead-in to additional content.</p>
						</div>
					</div>
					<div class="card">
						<img src="./resources/img/a3.jpg" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">
								<a href="consultaActividadDeportiva.html" class="">Actividad
									3</a>
							</h5>
							<p class="card-text">This is a wider card with supporting
								text below as a natural lead-in to additional content. This card
								has even longer content than the first to show that equal height
								action.</p>
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

	<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
	<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
</body>
</html>