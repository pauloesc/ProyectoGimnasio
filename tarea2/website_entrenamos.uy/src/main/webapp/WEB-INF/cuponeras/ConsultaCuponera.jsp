<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaActividad"%>
<%@page import="controladores.ConsultaCategoria"%>
<%@page import="logica.DataCuponera"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	DataCuponera dtcuponera = (DataCuponera) request.getAttribute("cuponera");
	
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
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
 						<h5 class="card-header text-primary"> <b>Pelotas</b></h5>
  						<div class="card-body text-dark">
    						<p class="card-text">Deportes con pelota</p>
    						<p class="card-text">Periodo de vigencia: 01/05/2021 - 31/07/2021</p>
    						<p class="card-text">Descuento aplicar: 20% </p>
    						<p class="card-text"> <b> Costo Total: 10680$</b> </p>
    						<p class="card-text text-secondary"> Fecha de alta: 30/04/2021 </p>
  					</div>
  						<div class="d-md-flex justify-content-md-end col-12 mb-3">
  							<a href=# class="btn btn-primary" data-toggle="modal" data-target="#comprar2">Comprar Cuponera</a>	
  						
  						<!-- Modal -->
<div class="modal fade" id="comprar2" tabindex="-1" role="dialog" aria-labelledby="comprar2Label" aria-hidden="true">
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
                    <button type="button" data-dismiss="modal" class="btn btn-primary" data-toggle="modal" data-target="#exito2">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</div>
		<div class="modal fade" id="exito2" tabindex="-1" role="dialog" aria-labelledby="exito2Label" aria-hidden="true">
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
   							 <tr>
     						 <th scope="row">1</th>
      							<td> <a href="consultaActividadDeportiva.html">Voleibol</a> </td>
     							 <td>7</td>
    						</tr>
    						<tr>
      							<th scope="row">2</th>
      							<td>Basquetbol </td>
      							<td>18</td>
    						</tr>  
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
   							 <tr>
     						 <th scope="row">1</th>
      							<td><a href="consultaCategoria.html">Deportes</a></td> 
    						</tr>
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