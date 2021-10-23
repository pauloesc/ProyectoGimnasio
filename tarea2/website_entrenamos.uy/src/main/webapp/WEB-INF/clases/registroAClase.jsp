<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaClase"%>
<%@page import="java.util.Set"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<script type="text/javascript" src="../jquer.js"></script>

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


<%%>

</head>
<%
	String nomC = (String)request.getAttribute("nomC");
	String fecha = (String)request.getAttribute("fecha");
	String costo = (String)request.getAttribute("costoClase");
	Set<String> cups = (Set<String>)request.getAttribute("nomCups");

%>
</head>

<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
		<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
			<h1>Registro a Dictado de Clases</h1>
					
					<div class="card mb-3" style="max-width: auto;">
						<div class="row no-gutters">
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title"><a href="consultaClase?clase=<%= nomC%>"><%= nomC %></a> </h5>
									<p class="card-text"> <p class="card-text m-0"><a>Costo: <%= costo%></a></p> 
									<p class="card-text"> <p class="card-text m-0"><a>Fecha: <%= fecha%></a></p> 
									
									
									
								</div>
							</div>
						</div>
					</div>
					
					
					
					
					
					
					<form action="${pageContext.request.contextPath}/RegistroAClase" method="post" >
					
				
						<div class="container" style="margin-top: 14px; margin-bottom: 14px;">
							<div class="row">
								
								
								<div class="col-4">
								
									<% if ((cups == null) || (cups.size() == 0)) { %>
										<label><input type="checkbox" id="conCup" value="false" disabled> Cuponera</label><br>
									<%} else { %>
										<label><input type="checkbox" id="conCup" value="true"> Cuponera</label><br>
									<%} %>
								</div>
								

								<input type="hidden" id="clase" name="clase" value="<%= nomC %>" >
						
								
								<div class="col-4">
									<select id="cuponera" name="cuponera"
										class="custom-select">
										<% 
										for(String nomcup :cups) {
										%>	
				   						
											<option value=<%= nomcup  %>><%= nomcup  %></option>
										<%
										} 
										%>
				    		
									</select>
									
								</div>
	
							</div>
						</div>
	
						<div class="form-group row">
							<div class="offset-4 col-8">
								<button name="submit" type="submit" class="btn btn-primary" >Comprar</button>
							</div>
						</div>
					</form>
					
					
	   
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