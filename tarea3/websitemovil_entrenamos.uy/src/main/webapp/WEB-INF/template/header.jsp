<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicadores.InfoBasicaUser"%>
<%@page import="publicadores.InfoBasicaProfesor"%>
<%@page import="controladores.Login"%>
<%@page import="java.util.Set"%>
<div id="header">
	<%
		publicadores.InfoBasicaUser usr;
		try 
		{
			usr = Login.getUsuarioLogueado(request);
		} 
		catch(Exception ex)
		{
			usr = null;
		}
		Set<String> instituciones= (Set<String>) request.getSession().getAttribute("Instituciones");
		Set<String> categorias= (Set<String>) request.getSession().getAttribute("Categorias");
	%>
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
						href="home">Home <span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenu" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">Menu</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenu">
							<a class="dropdown-item" href="listarActividades">Ver Actividades Deportivas</a>
							<a class="dropdown-item" href="listarClases">Ver Clases</a>
						</div>
					</li>
					<li class="nav-item dropdown"><a
                        class="nav-link dropdown-toggle" href="#"
                        id="navbarDropdownInst" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Instituciones</a>
                        <div class="dropdown-menu"
                            aria-labelledby="navbarDropdownInst">
                            <% 
                             for(String nominst :instituciones) {
                             %>  
                            <a class="dropdown-item"  href="consultaInstitucion?institucion=<%= nominst  %>"><%= nominst %></a>
                            <% } %> 
                        </div>
                    </li>
                    <li class="nav-item dropdown"><a
                        class="nav-link dropdown-toggle" href="#"
                        id="navbarDropdownCats" data-toggle="dropdown"
                        aria-haspopup="true" aria-expanded="false">Categorias</a>
                        <div class="dropdown-menu"
                            aria-labelledby="navbarDropdownCats">
                            <% 
                             for(String nomcat :categorias) {
                             %>  
                            <a class="dropdown-item"  href="consultaCategoria?categoria=<%= nomcat  %>"><%= nomcat %></a>
                            <% } %> 
                        </div>
                    </li>
				</ul>
			</div>
		</div>
		<% if (usr == null) { %>
		<div class="btn-group btn-group-sm">
			<a class="btn btn-dark" style="font-size: 13px; font-weight: 500"
				href=${pageContext.request.contextPath}/login >
				Iniciar Sesion
			</a>
		</div>
		<% }
		else
		{ %>
		<div class="btn-group btn-group-sm">
				<a class="btn btn-dark dropdown-toggle" style="font-size: 13px; font-weight: 500" href="#"
					id="navbarDropdownUsuario" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					
					
					<img src="imagenes?id=<%=usr.getImg()%>" width="30" height="30" class="rounded-circle">
					<span style="font-size: 13px; font-weight: 700"> &nbsp <%=usr.getNombre() + " " + usr.getApellido() %></span>
				</a>
				<div class="dropdown-menu dropdown-menu-right"
					aria-labelledby="navbarDropdownUsuario">
					<a class="btn btn-primary dropdown-item" style="font-size: 13px;" href=${pageContext.request.contextPath}/logout>Cerrar sesion</a>
				</div>
			</div>
		<% } %>
	</nav>

</div>