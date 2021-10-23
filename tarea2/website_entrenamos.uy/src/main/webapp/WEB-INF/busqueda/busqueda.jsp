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
		<div class="row my-4">
			<div class="col-12 col-md-9 my-4">
				<div class="list-group">
  					<a href="#" class="list-group-item list-group-item-action flex-column align-items-start active">
    					<div class="d-flex w-100 justify-content-between">
      						<h5 class="mb-1">List group item heading</h5>
      						<small>3 days ago</small>
    					</div>
    				<p class="mb-1">Donec id elit non mi porta gravida at eget metus. Maecenas sed diam eget risus varius blandit.</p>
    				<small>Donec id elit non mi porta.</small>
 					 </a>
                </div>
			</div>
			<div id="filtros" class="col-6 col-md-3 my-4">
			 <div class="form-inline">
                        <label for="ordenarPor">Orden:</label>
                        <select class="form-control-sm" id="ordenarPor">
                              <option>Alfabeticamente (a-z)</option>
                              <option>Alfabeticamente (z-a)</option>
                              <option>Año (ascendente)</option>
                              <option>Año (descendente)</option>
                         </select>
                    </div>
			     <div class="accordion" id="accordionExample">
					  <div>
					    <div id="headingOne">
					      <h2 class="mb-0">
					        <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					          Filtrar por Instituciones
					        </button>
					      </h2>
					    </div>
					
					    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
					        <div class="form-group">
							    <select multiple class="form-control" id="exampleFormControlSelect2">
							      <option>1</option>
							      <option>2</option>
							      <option>3</option>
							      <option>4</option>
							      <option>5</option>
							    </select>
							 </div>
					    </div>
					  </div>
					  <div>
					    <div id="headingTwo">
					      <h2 class="mb-0">
					        <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
					          Filtrar por Categorias
					        </button>
					      </h2>
					    </div>
					    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
					      <div class="form-group">
                                <select multiple class="form-control" id="exampleFormControlSelect2">
                                  <option>1</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                </select>
                             </div>
					    </div>
					  </div>
				</div>
				<button type="button" class="btn btn-block btn-secondary">Aplicar</button>
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