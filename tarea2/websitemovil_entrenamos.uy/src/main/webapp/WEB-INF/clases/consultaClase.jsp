<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.ConsultaClase"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	String nom = (String)request.getAttribute("nom");
	String nomP = (String)request.getAttribute("nomP");
	String act = (String)request.getAttribute("act");
	String fecha = (String)request.getAttribute("fecha");
	String hor = (String)request.getAttribute("hor");
	String min = (String)request.getAttribute("min");
	String url = (String)request.getAttribute("url");
	String img = (String)request.getAttribute("img");
	String socio = (String)request.getAttribute("socio");
	String profe = (String)request.getAttribute("profe");
	String costo = (String)request.getAttribute("costoClase");
	int cantPremios = (int)request.getAttribute("cantP");
	boolean sort = (boolean)request.getAttribute("sort");
	List<String> ganadores = (List<String>)request.getAttribute("ganadores");
	int cantP = (int)request.getAttribute("cantP");
	String descP = (String)request.getAttribute("descP");
	
	
	//paulo
	int minS  = (int) request.getAttribute("minS");
	int actS = (int) request.getAttribute("actuS");
	int maxS = (int) request.getAttribute("maxS");
	String fechaReg = (String) request.getAttribute("fechaReg");
	//paulo
	
%>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-12 col-md-8 my-4">
			
			
<div class="card" style="max-width: auto;">
    <div class="row g-0">
        <div class="col-sm-5">
            <img src="imagenes?id=<%= img  %>" class="card-img-top h-100" alt="...">
        </div>
        <div class="col-sm-7">
            <div class="card-body">
                <h2 class="card-title"><%= nom %></h2>
                <p class="card-text"> <p class="card-text m-0"><a href="consultaActividad?actividad=<%= act%>">Ver información de la actividad deportiva</a></p>
            </div>
        </div>
    </div>
</div>
			
			<br>

					<div class="card mb-3" style="max-width: auto;">
						<div class="row no-gutters">
							
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">Información Adicional</h5>
									
									<!-- agregar que te mande a la pagina de consultar usuario con el profesor cuando este lista -->
									<p class="card-text"> <p class="card-text m-0">Dictada por: <%= nomP %></p> 
									
									<p class="card-text"> <p class="card-text m-0">Fecha y hora: <%= fecha %></p> 
									<p class="card-text"> <p class="card-text m-0">Costo: <%= "$" + costo %></p>
									<p class="card-text"> <p class="card-text m-0">URL:: <%= url %></p> 
									<p class="card-text"> <p class="card-text m-0">Socios:: Min: <%=minS%>, Actual: <%=actS%>, Max: <%=maxS%> </p> 
									<p class="card-text"> <p class="card-text m-0">Fecha Registro clase: <%=fechaReg%></p>
									<p class="card-text"> <p class="card-text m-0">premios: <%=cantP%></p>
									<p class="card-text"> <p class="card-text m-0">descripcion de los premios: <%=descP%></p>
									
									<% if (sort) {	%>
									<p class="card-text"> <p class="card-text m-0">Ganadores del sorteo: <%=ganadores%></p>
									<% }%>
								</div>
							</div>
						</div>
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