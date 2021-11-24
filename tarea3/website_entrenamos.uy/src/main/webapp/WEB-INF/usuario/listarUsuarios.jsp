<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="controladores.ListarUsuarios"%>
<%@page import="publicadores.InfoBasicaUser"%>
<%@page import="publicadores.InfoBasicaSocio"%>
<%@page import="publicadores.InfoBasicaProfesor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%
List<InfoBasicaUser> infoUsarios = (List<InfoBasicaUser>) request.getAttribute("usuarios");
Iterator<InfoBasicaUser> infoUsuariosI = infoUsarios.iterator();

//se utiliza mas abajo
int cont = 0;

%>

<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="entrenamos.uy">
<meta name="author" content="tpgr03">

<!-- Bootstrap CSS -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/bootstrap-reboot.min.css" rel="stylesheet">
<link href="./resources/css/bootstrap-grid.min.css" rel="stylesheet">
<link href="./resources/css/sticky-footer-navbar.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">

<title>entrenamos.uy</title>
</head>
<body>
<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">

		<jsp:include page="/WEB-INF/template/sidebar.jsp" />
		
		
			<div class="col-12 col-md-8 my-4">
				<h1>Usuarios</h1>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="socios-tab" data-toggle="tab"
						href="#socios" role="tab" aria-controls="socios"
						aria-selected="true">Socios</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="profesores-tab" data-toggle="tab" href="#cuponeras" role="tab"
						aria-controls="profesores" aria-selected="false">Profesores</a></li>
					
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="socios"
						role="tabpanel" aria-labelledby="socios-tab">
						<div class="m-3">
						<table class="table table-hover">
  							<thead>
    							<tr>
     							 <th scope="col">#</th>
     							 <th></th>
     							 <th scope="col">Nombre</th>
    							</tr>
  							</thead>
  							<tbody>
  							<%
  							cont = 1;
  							while( infoUsuariosI.hasNext() ){
  								InfoBasicaUser auxInfoUser = infoUsuariosI.next();
  							%>
  							<% if( auxInfoUser.getClass() ==  InfoBasicaSocio.class )
  								{
  								%>
   							 <tr>
     							<th scope="row"><%= cont %></th>
     				
     							<td> <img src="imagenes?id=<%= auxInfoUser.getImg() %>" width="30" height="30" class="rounded-circle"> </td>
      							<td> <a href="ConsultaUsuario?usuarioNick=<%= auxInfoUser.getNickname()  %>"><%= auxInfoUser.getNombre() %></a> </td>
    						</tr>
    						
    						<% 
    						cont++;
    							}
  							
  							}
    						%>
  						</tbody>
					</table>
					
					</div>
					</div>
					<div class="tab-pane fade" id="cuponeras" role="tabpanel"
						aria-labelledby="cuponeras-tab">
						<div class="m-3">
						<table class="table table-hover">
  							<thead>
    							<tr>
     							 <th scope="col">#</th>
     							 <th></th>
     							 <th scope="col">Nombre</th>
    							</tr>
  							</thead>
  							<tbody>
  							<%
  							cont = 1;
  							infoUsuariosI = infoUsarios.iterator();
  							while( infoUsuariosI.hasNext() ){
  								InfoBasicaUser auxInfoUser = infoUsuariosI.next();
  							%>
  							<% if( auxInfoUser.getClass() ==  InfoBasicaProfesor.class )
  								{
  							%>
   							 <tr>
     							<th scope="row"><%= cont %></th>
     							<td> <img src="imagenes?id=<%=auxInfoUser.getImg()%>" width="30" height="30" class="rounded-circle"> </td>
      							<td> <a href="ConsultaUsuario?usuarioNick=<%= auxInfoUser.getNickname()  %>"><%= auxInfoUser.getNombre() %></a> </td>
    						</tr>
    						
    						<% 
    						cont++;
  								}
  							}
    						%>
    					</tbody>
					</table>
					
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