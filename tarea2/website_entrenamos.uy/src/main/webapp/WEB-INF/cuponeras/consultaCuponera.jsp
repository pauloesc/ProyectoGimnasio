<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaActividad"%>
<%@page import="controladores.ConsultaCategoria"%>
<%@page import="controladores.ComprarCuponera"%>

<%@page import="logica.DataCuponera"%>
<%@page import="logica.ParActividad"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<script type="text/javascript" src="../jquer.js"></script>

</head>
<%
	DataCuponera dtcuponera = (DataCuponera) request.getAttribute("cuponera");
	Date date = null;  
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");  
	Boolean socio= (Boolean) request.getAttribute ("socio");
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
	<% if (request.getAttribute("compra") != null) { %>
		<% String msje=(String) request.getAttribute("msjcompra");
		Boolean compra =(Boolean) request.getAttribute("compra");
			if (compra==false) { %>
		<div class="alert alert-danger alert-dismissible fade show  my-4" role="alert">
		  <%= msje %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% if (compra == true) { %>
		<div class="alert alert-success alert-dismissible fade show  my-4" role="alert">
		  <%= msje %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% } %>
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8">
				<h2 class="text-dark mb-4">Consulta Cuponeras de Actividad Deportiva</h2>
					<div class="row no-gutters">
						<div class="col-md-5 text-center">
							<img src="./resources/img/b1.jpg" class="img-fluid" alt="...">
						</div>
					<div class="col-md-7">	
					<div class="card mb-3 shadow" style="max-width:auto;">
 						<h5 class="card-header text-primary"> <b><%= dtcuponera.getNombre() %></b></h5>
  						<div class="card-body text-dark">
    						<p class="card-text"><%= dtcuponera.getDescripcion() %></p>
    						<p class="card-text"> Periodo de vigencia: <%= dateFormat.format(dtcuponera.getFechaIni())%> - <%= dateFormat.format(dtcuponera.getFechaFin())%> </p>
    						<p class="card-text">Descuento aplicar: <%= dtcuponera.getDescuento() %>% </p>
    						<p class="card-text"> <b> Costo Total: <%= dtcuponera.getCosto() %>$</b> </p>
    						<p class="card-text text-secondary"> Fecha de alta: <%= dateFormat.format(dtcuponera.getFechaAlta())%> </p>
  					</div>
  						 <div class="d-md-flex justify-content-md-end col-12 mb-3">
  							<% if (socio){%>
  							<a href=# class="btn btn-primary" data-toggle="modal" data-target="#comprar2">Comprar Cuponera</a>	
  							<%}%>
  						<!-- Modal -->
<div class="modal fade" id="comprar2" tabindex="-1" role="dialog" aria-labelledby="comprar2Label" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form method="post" > 
                <div class="modal-header">
                    <h5 class="modal-title" id="comprarLabel">Confirmar la compra de la cuponera</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
              <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                    <button type="button" name="submit" type="submit" class="btn btn-primary" data-dismiss="modal">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</div>
		
  						
  						
  						
  						
  						</div> 
					</div>
					</div>
				</div>
			
				<br>
				<br>
				
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="ActividadesDeportivas-tab" data-toggle="tab"
						href="#ActividadesDeportivas" role="tab" aria-controls="ActividadesDeportivas"
						aria-selected="true">Actividades Deportivas</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="categorias-tab" data-toggle="tab" href="#categorias" role="tab"
						aria-controls="categorias" aria-selected="false">Categorias</a></li>
					
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="ActividadesDeportivas"
						role="tabpanel" aria-labelledby="ActividadesDeportivas-tab">
						<div class="m-3">
						<table class="table table-hover">
  							<thead>
    							<tr>
     							 <th scope="col">#</th>
     							 <th scope="col">Nombre</th>
      							 <th scope="col">Número de clases</th>
    							</tr>
  							</thead>
  							<tbody>
  							<% 
  							int i = 1;
  							Set<ParActividad> act=dtcuponera.getClases();
							for(ParActividad paract :act) {
								String aa=paract.getNombre();
								int    n1=paract.getNumclase();
							%>	
   							 <tr>
     						 <th scope="row"><%= i  %></th>
      							<td> <a href="consultaActividad?actividad=<%= aa%>"><%= aa%></a> </td>
     							 <td><%= n1%></td>
    						</tr>
    						<%
    						i++;
							} 
							%>	
  						</tbody>
					</table>
					
					</div>
					</div>
					<div class="tab-pane fade" id="categorias" role="tabpanel"
						aria-labelledby="categorias-tab">
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
  							Set<String> cat=dtcuponera.getCategorias();
							for(String categoria :cat) {
							%>	
   							 <tr>
     						 <th scope="row"><%= i2  %></th>
      							<td><a href="consultaCategoria?categoria=<%= categoria  %>"><%= categoria %></a></td> 
    						</tr>
    						<%
    						i2++;
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