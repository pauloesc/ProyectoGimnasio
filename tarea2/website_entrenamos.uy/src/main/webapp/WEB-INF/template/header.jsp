<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="logica.InfoBasicaUser"%>
<%@page import="controladores.Login"%>
<div id="header">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="#">Entrenamos.uy</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarEntrenamos" aria-controls="navbarEntrenamos"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarEntrenamos">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="index.html">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenu" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Menu</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenu">
							<a class="dropdown-item" href="altaActividadDeportiva.html">Usuarios</a> 
						</div>
					</li>
				</ul>
				<form class="form-inline my-2 my-md-0">
					<input class="form-control" type="text" placeholder="Buscar"
						aria-label="Search">
				</form>
			</div>
		</div>
		<%
		InfoBasicaUser usr;
		try 
		{
			usr = Login.getUsuarioLogueado(request);
		} 
		catch(Exception ex)
		{
			usr = null;
		}
		
		if(usr == null) {
	  %>

		<div class="btn-group">
			<a href=${pageContext.request.contextPath}/login
				class="btn btn-light btn-sm">Iniciar Sesion</a> <a href="#"
				class="btn btn-light btn-sm">Registrarse</a>
		</div>
		<% }
		else
		{ %>
		<div class="btn-group">
				<a class="btn btn-light btn-sm dropdown-toggle" href="#"
					id="navbarDropdownUsuario" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"><%= usr.getNombre() %></a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="navbarDropdownUsuario">
					<a class="dropdown-item" href="#">Ver mi perfil</a> <a
						class="dropdown-item" href="#">Modificar mis datos</a> <a
						class="dropdown-item" href="#">Cerrar sesion</a>
				</div>
			</div>
		<% } %>
	</nav>

</div>

<div id="body-container">