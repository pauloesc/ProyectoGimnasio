<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicadores.DataActividad"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="controladores.Login"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	DataActividad actividad = (DataActividad) request.getAttribute("actividad");
	List<String> cup = (List<String>) request.getAttribute("cup");
	Set<String> clases = (Set<String>) request.getAttribute("clases");
	publicadores.InfoBasicaUser usr;
	try {
		usr = Login.getUsuarioLogueado(request);
	} 
	catch(Exception ex) {
		usr = null;
	}
	
%>

<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-12 col-md-8 my-4">
			
			
							<div class="card" style="max-width: auto;">
    <div class="row g-0">
        <div class="col-sm-5">
            <img src="imagenes?id=<%= actividad.getImagen()  %>" class="card-img-top h-100" alt="...">
        </div>
        <div class="col-sm-7">
            <div class="card-body">
                <h2 class="card-title"><%= actividad.getNombre()  %></h2>
                <p class="card-text"><%= actividad.getDescripcion()  %></p>
                
                
                
                								<% 
								Iterator<String> iter2 = actividad.getCategorias().iterator();
								while (iter2.hasNext()) {
									String ncat = iter2.next();
								%>								
									<a href="consultaCategoria?categoria=<%= ncat  %>"><span class="badge badge-info"><%= ncat  %></span></a>
								<% 
								}
								%>
            </div>
        </div>
    </div>
</div>
			
			<br>
			
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="detalles-tab" data-toggle="tab"
						href="#detalles" role="tab" aria-controls="detalles"
						aria-selected="true">Detalles</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="cuponeras-tab" data-toggle="tab" href="#cuponeras" role="tab"
						aria-controls="cuponeras" aria-selected="false">Cuponeras</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="clases-tab" data-toggle="tab" href="#clases" role="tab"
						aria-controls="clases" aria-selected="false">Clases</a></li>
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="detalles"
						role="tabpanel" aria-labelledby="detalles-tab">
						<div class="m-3">
						  <p><i class="fa fa-building"></i> &nbsp &nbsp Institución Deportiva: <a href="consultaInstitucion?institucion=<%= actividad.getInstitucion() %>"><%= actividad.getInstitucion() %></a></p>
						  <p><i class="fa fa-user-circle-o"></i> &nbsp &nbsp Profesor: <%= actividad.getProfesor() %></p>
						  <p><i class="fa fa-usd"></i> &nbsp &nbsp Costo: $<%= actividad.getCosto()  %></p>
						  <p><i class="fa fa-clock-o"></i> &nbsp &nbsp Duración: <%= actividad.getDuracion()  %> minutos</p>
						</div>
					</div>	
					<div class="tab-pane fade" id="cuponeras" role="tabpanel"
						aria-labelledby="cuponeras-tab">
						<div class="m-3">
						<table class="table table-hover">
						<thead>
    							<tr>
     							 <th scope="col">#</th>
     							 <th scope="col">Nombre</th>
    							</tr>
  							</thead>
  							<tbody>
  							<% 
  							int i2 = 1;
							for(String nomcup:cup) {
							%>	
   							 <tr>
     						 <th scope="row"><%= i2%></th>
      							<td><%= nomcup %></td> 
    						</tr>
    						<%
    						i2++;
							} 
							%>	
    					</tbody>
					</table>
					</div>
					</div>
					<div class="tab-pane fade" id="clases" role="tabpanel"
						aria-labelledby="clases-tab">
							<div class="m-3">
							<table class="table table-hover">
							<thead>
	    							<tr>
	     							 <th scope="col">#</th>
	     							 <th scope="col">Nombre</th>
	    							</tr>
	  							</thead>
	  							<tbody>
	  							<% 
	  							if (clases != null) {
	  							int ic = 1;
								for(String nomClas:clases) {
								%>	
	   							 <tr>
	     						 <th <%= ic%> scope="row"><%= ic%></th>
	      							<td><a href="consultaClase?clase=<%= nomClas %>"> <%= nomClas %></a></td> 
	    						</tr>
	    						<%
	    						ic++;
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
