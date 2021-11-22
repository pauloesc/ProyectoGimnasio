<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaClase"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<script type="text/javascript" src="../jquer.js"></script>



<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />


<script type="text/javascript">
	window.onload = function cargaPop() {
		setTimeout('abrirPopUp()',0);
	}
	
	function abrirPopUp() {
		<% if ((String)request.getAttribute("respuesta") != null) {%>
			$("#popup").modal();
		<%}%>
		
	}
	
</script>


<script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
    </script>


<%%>

</head>
<%
	
	String inst = (String)request.getAttribute("institucion");
	Set<String> acts = (Set<String>)request.getAttribute("actividades");

%>
</head>

<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
		<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
			
			<form action="${pageContext.request.contextPath}/AltaClase" method="post" enctype="multipart/form-data">
				<h1>Alta Dictado de Clases</h1>
				
					<div class="form-group row">
						<label class="col-4 col-form-label" for="nombreClase">Nombre Institucion: <%=inst%></label>
						<div class="col-8">
						</div>
					</div>
					
					
			
					
					<div class="form-group row">
						<label for="actividadDeportiva" class="col-4 col-form-label">Actividad
							Deportiva</label>
						<div class="col-8">
							<select id="actividadDeportiva" name="actividadDeportiva"
								class="custom-select" required="required">
									<% 
									for(String act :acts) {
									%>	
				   						
										<option value="<%=act%>"><%= act  %></option>
									<%
									} 
									%>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-4 col-form-label" for="nombreClase">Nombre</label>
						<div class="col-8">
							<input id="nombreClase" name="nombreClase"
								placeholder="Ingrese un nombre" type="text" class="form-control"
								required="required">
						</div>
					</div>
					<div class="form-group row">
						<label for="urlClase" class="col-4 col-form-label">url</label>
						<div class="col-8">
							<input id="urlClase" name="urlClase"
								placeholder="Ingrese la url de la calse" type="text"
								class="form-control" required="required">
						</div>
					</div>
					<div class="form-group row">
						<label for="urlVideo" class="col-4 col-form-label">url video</label>
						<div class="col-8">
							<input id="urlVideo" name="urlVideo"
								placeholder="Ingrese la url del video de YouTube" type="text"
								class="form-control" required="required">
						</div>
					</div>
					<div class="form-group row">
						<label for="sociosMinimos" class="col-4 col-form-label">Socios
							mínimos</label>
						<div class="col-8">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-user" aria-hidden="true"></i>
									</div>
								</div>
								<input id="sociosMinimos" name="sociosMinimos"
									placeholder="Ingrese la cantidad mínima de socios" type="number"
									required="required" class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="sociosMaximos" class="col-4 col-form-label">Socios
							máximos</label>
						<div class="col-8">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-users" aria-hidden="true"></i>
									</div>
								</div>
								<input id="sociosMaximos" name="sociosMaximos"
									placeholder="Ingrese la cantidad máxima de socios." type="number"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group row">
						<label for="fecha" class="col-4 col-form-label">Fecha</label>
						<div class="col-8">
							<input class="form-control"
									type="date" name="datepicker" required/>
						</div>
					</div>

				
					<div class="form-group row">
						<label for="hora" class="col-4 col-form-label">Hora</label>
						<div class="col-8">
							<input type="time" readonly id="timepicker" name="timepicker" width="276" />
						</div>
					</div>
					
				
					<div class="form-group row">
						<label for="cantPremios" class="col-4 col-form-label">Cantidad de premios a sortear</label>
						<div class="col-8">
							<div class="input-group">
								<div class="input-group-prepend">
									<div class="input-group-text">
										<i class="fa fa-users" aria-hidden="true"></i>
									</div>
								</div>
								<input id="cantPremios" name="cantPremios"
									placeholder="Cantidad de premios a sortear" type="number"
									class="form-control">
							</div>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="descP" class="col-4 col-form-label">Descripcion de los premios</label>
						<div class="col-8">
							<input id="descP" name="descP"
								placeholder="Descripcion de los premios" type="text"
								class="form-control" required="required">
						</div>
					</div>
				

					<div class="form-group row">
						<label for="imagenActividad" class="col-4 col-form-label">Imagen</label>
						<div class="col-8">
							<input type="file" class="form-control-file" accept="image/*" name="imagenClase">
						</div>
					</div>


					<div class="form-group row">
						<div class="offset-4 col-8">
							<button name="submit" type="submit" class="btn btn-primary">Confirmar</button>
						</div>
					</div>
					
				
				</form>
				
			</div>
					
	   
				    <div class="modal fade" id="popup" tabindex="-1" role="dialog" aria-labelledby="comprar2Label" aria-hidden="true" show="true">
					    <div class="modal-dialog" role="document">
					        <div class="modal-content">
					         <a onclick="closeDialog('popup');" class="close"></a>
					            <form >
					                <div class="modal-header">
					                    <h5 class="modal-title" id="comprarLabel"><%= (String)request.getAttribute("respuesta")%></h5>
					                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					                        <span aria-hidden="true">&times;</span>
					                    </button>
					                </div>
					            </form>
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

	<script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4'
        });
    </script>
  
	<script>
        $('#timepicker').timepicker();
  </script>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"></script>
</body>
</html>