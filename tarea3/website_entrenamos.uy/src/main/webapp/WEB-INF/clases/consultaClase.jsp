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
	String urlvideo = (String)request.getAttribute("urlvid");
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
	
	List<publicadores.InfoBasicaSocio> ganadoresPorOtroMetodo = (List<publicadores.InfoBasicaSocio>)request.getAttribute("ganadoresPorOtroMetodo");
	
	
%>
</head>
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
<% 	%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
		<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
					<div class="card mb-3" style="max-width: auto;">
						<div class="row no-gutters">
							<div class="col-md-4">
								<img src="imagenes?id=<%=img%>" width="240"
									height="160" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title"><%= nom %></h5>
									<p class="card-text"> <p class="card-text m-0"><a href="consultaActividad?actividad=<%= act%>">Ver información de la actividad deportiva</a></p> 
									
									<% if (socio == "T") {%>
									<p class="card-text"> <p class="card-text m-0"><a href="registroAClase?clase=<%= nom%>">Registrarme a la clase</a></p> 
									<%}%>
									

								</div>
							</div>
						</div>
					</div>
					
					<div class="card mb-3" style="max-width: auto;">
						<div class="row no-gutters">
							
							<div class="col-md-7">
								<div class="card-body">
									<h5 class="card-title">Información Adicional</h5>
									
									<p class="card-text"> <p class="card-text m-0"><a href="consultaUsuario?usuarioNick=<%= nomP %> ">Dictada por: <%= nomP %></a></p> 
									
									<p class="card-text"> <p class="card-text m-0">Fecha y hora: <%= fecha %></p> 
									<p class="card-text"> <p class="card-text m-0">Costo: <%= "$" + costo %></p>
									<p class="card-text"> <p class="card-text m-0">URL:: <%= url %></p> 
									<p class="card-text"> <p class="card-text m-0">Socios:: Min: <%=minS%>, Actual: <%=actS%>, Max: <%=maxS%> </p> 
									<p class="card-text"> <p class="card-text m-0">Fecha Registro clase: <%=fechaReg%></p>
									<p class="card-text"> <p class="card-text m-0">premios: <%=cantP%></p>
									<p class="card-text"> <p class="card-text m-0">descripcion de los premios: <%=descP%></p>
									
									<% if (sort) {
									
										for( publicadores.InfoBasicaSocio infoS : ganadoresPorOtroMetodo ){
											publicadores.InfoBasicaSocio auxInfoS = infoS;
									%>
									
									<a href="ConsultaUsuario?usuarioNick=<%= auxInfoS.getNickname()  %>"><%= auxInfoS.getNombre() %>,</a>
									
									<% }%>
									<% }%>
									
								</div>
							</div>
							



							<div class="col-md-5">
								<div class="card-body">
								
								<% if (profe == "T" && cantPremios>0 && !sort) {%>
										<form action="${pageContext.request.contextPath}/SortearPremios" method="post" >
									
											<input type="hidden" id="clase" name="clase" value="<%= nom %>" >
											<div class="form-group row">
												<div class="offset-12 col-12">
													<button name="submit" type="submit" class="btn btn-primary" >Sortear premios</button>
												</div>
											</div>
										</form>
									<%}%>
								

								
									<% if (profe == "T" && cantPremios>0 && !sort) {
									List<publicadores.InfoBasicaSocio> listaParticipantes = (List<publicadores.InfoBasicaSocio>)request.getAttribute("sociosEnClase");
									%>
									
									<h5 class="card-title">Socios en clase</h5>
									<table class="table table-hover">
									<tbody>
									
									<%
									for( publicadores.InfoBasicaSocio NomVar: listaParticipantes ){
										publicadores.InfoBasicaSocio aux = NomVar;
									%>
									
									
									
									<tr>
		     							<th scope="row"></th>
		     							<td> <img src="imagenes?id=<%= aux.getImg() %>" width="30" height="30" class="rounded-circle"> </td>
		      							<td> <a href="ConsultaUsuario?usuarioNick=<%= aux.getNickname()  %>"><%= aux.getNombre() %></a> </td>
		    						</tr>
									
									<% }%>
									</tbody>
									</table>
									<% }%>
									
									

									
								</div>
							</div>



						</div>
					</div>
					
					<% if (!urlvideo.equals("")) {%>
					<div class="card mb-3" style="max-width: auto;">
						<div class="row no-gutters">
							
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">Video de la clase</h5>							
									<iframe id="player" type="text/html" width="640" height="390"
 									 src=" <%= urlvideo %>" frameborder="0"></iframe>
								</div>
							</div>
						</div>
					</div>
					<%}%>
					
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