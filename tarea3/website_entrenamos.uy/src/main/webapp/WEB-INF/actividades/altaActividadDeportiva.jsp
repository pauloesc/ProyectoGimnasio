<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%


	String insti = (String) request.getAttribute("institucion");

	List<String> listCat = (List<String>) request.getAttribute("categorias");
	
	String msjAlta = (String) request.getAttribute("msjAlta");
	Boolean estadoAlta = (Boolean) request.getAttribute("estadoAlta");
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<% if (request.getAttribute("estadoAlta") != null) { %>
		<% if (estadoAlta == false) { %>
		<div class="alert alert-danger alert-dismissible fade show  my-4" role="alert">
		  <%= msjAlta %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% if (estadoAlta == true) { %>
		<div class="alert alert-success alert-dismissible fade show  my-4" role="alert">
		  <%= msjAlta %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% } %>
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
				<h1>Alta de Actividad Deportiva</h1>
				<form class="my-4" method="post" action="altaActividad" enctype="multipart/form-data">
					<div class="form-group row">
						<label  class="col-4 col-form-label">Institucion Deportiva:</label>
						<div class="col-8">
							<input readonly type="text" class="form-control" id="institucionDeportiva" name="institucionDeportiva" value="<%= insti %>" >
						</div>
					</div>
					
					
					<div class="form-group row">
						<label class="col-4 col-form-label" for="nombreActividad">Nombre</label>
						<div class="col-8">
							<input id="nombreActividad" name="nombreActividad"
								placeholder="Ingrese un nombre para la actividad" type="text"
								class="form-control" required="required">
						</div>
					</div>
					<div class="form-group row">
						<label for="descripcionActividad" class="col-4 col-form-label">Descripción</label>
						<div class="col-8">
							<textarea id="descripcionActividad" name="descripcionActividad"
								cols="40" rows="3" class="form-control" required="required"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<label for="duracionActividad" class="col-4 col-form-label">Duración</label>
						<div class="col-8">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-clock-o"></i>
									</div>
								</div>
								<input id="duracionActividad" name="duracionActividad"
									placeholder="Ingrese la duración en minutos" type="number"
									required="required" class="form-control" min="0" oninput="validity.valid||(value='');">
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="costoActividad" class="col-4 col-form-label">Costo</label>
						<div class="col-8">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-money"></i>
									</div>
								</div>
								<input id="costoActividad" name="costoActividad"
									placeholder="Ingrese el costo en pesos." type="number"
									required="required" class="form-control" min="0" oninput="validity.valid||(value='');">
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="imagenActividad" class="col-4 col-form-label">Imagen</label>
						<div class="col-8">
							<input type="file" class="form-control-file" accept="image/*" name="imagenActividad">
						</div>
					</div>
					<div class="form-group row">
						<label for="categoriasActividad" class="col-4 col-form-label">Categori­as</label>
						<div class="col-8">
							<select id="categoriasActividad" name="categoriasActividad"
								class="custom-select" required="required" multiple="multiple">
								<% 
								for(String nomcat :listCat) {
								%>
								<option value="<%= nomcat  %>"><%= nomcat  %></option>
								<% } %>	
							</select>
						</div>
					</div>
					<div class="form-group row">
						<div class="offset-4 col-8">
							<button name="submit" type="submit" class="btn btn-primary">Confirmar</button>
						</div>
					</div>
				</form>
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