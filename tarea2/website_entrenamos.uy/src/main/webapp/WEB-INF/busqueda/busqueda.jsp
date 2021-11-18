<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicadores.DataCuponera"%>
<%@page import="publicadores.DataActividad"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
<script type="text/javascript" src="./resources/js/busqueda.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<%
	List<DataCuponera> cuponeras = (List<DataCuponera>) request.getAttribute("resultCup");
	List<DataActividad> actividades = (List<DataActividad>) request.getAttribute("resultAct");
	List<String> instituciones = (List<String>) request.getAttribute("instituciones");
	List<String> categorias = (List<String>) request.getAttribute("categorias");
	String consulta = (String) request.getAttribute("consulta");
	
	String resultadosJson = "{nombre: 'Fernando', num: 89875, sexo: 'masculino', inst: 'telon', categoria: 'natacion'},;";
	%>
	<main role="main" class="container">
		<div class="row my-4">
			<div class="col-12 col-md-9 my-4">
				<%
				if (cuponeras.size() != 0)
				{
				%>
				<h5>Cuponeras</h5>
				<div  id="resultadosCuponeras" class="list-group list-group-flush">
					<%
					for (DataCuponera cup : cuponeras)
					{
					%>
					<div id="<%=cup.getNombre().toLowerCase().replaceAll("\\s+","") %>" class="resultado resCup <% for ( String ncat : cup.getCategorias() ){ %><%=ncat.replaceAll("\\s+","") + " "%><%} %> <% for ( String ninsti : cup.getInstituciones() ){ %><%=ninsti.replaceAll("\\s+","") + " "%><%} %>">
  					<a href="consultaCuponera?cuponera=<%=cup.getNombre()%>" class="list-group-item list-group-item-action flex-column align-items-start">
    					<div class="d-flex w-100 justify-content-between">
      						<h5 class="mb-1"><%=cup.getNombre() %></h5>
      						<small>$<%=cup.getCosto() %></small>
    					</div>
    					<span id="<%=cup.getFechaAlta().toGregorianCalendar().getTime().toInstant()%>">Fecha publicación: <fmt:formatDate pattern = "yyyy-MM-dd" value = "<%=cup.getFechaAlta().toGregorianCalendar().getTime()%>"/> </span><br>
    					<%
    					for ( String ncat : cup.getCategorias() )
    					{
    					%>
    						<span class="badge badge-info"><%=ncat%></span>
    					<%
    					}
    					%>
 						</a>
 						</div>
 					<% 
					}
					%>
        		</div> <br>
        <% 
				}
				if (actividades.size() != 0)
				{
				%>
					<h5>Actividades Deportivas</h5>
					<div id="resultadosActividades" class="list-group list-group-flush">
					<%
					for (DataActividad act : actividades)
					{
					%>
					<div id="<%= act.getNombre().toLowerCase().replaceAll("\\s+","") %>" class="resultado resActi <% for ( String ncat : act.getCategorias() ){ %><%=ncat.replaceAll("\\s+","") + " "%><%} %> <%=act.getInstitucion().replaceAll("\\s+","")%>">
  					<a href="consultaActividad?actividad=<%=act.getNombre()%>" class="list-group-item list-group-item-action flex-column align-items-start">
    					<div class="d-flex w-100 justify-content-between">
    						<div>
    							<h5 id="nomact" class="mb-1"><%=act.getNombre() %></h5>
    							<span id="<%=act.getFechaAlta().toGregorianCalendar().getTime().toInstant() %>">Fecha publicación: <fmt:formatDate pattern = "yyyy-MM-dd" value = "<%=act.getFechaAlta().toGregorianCalendar().getTime()%>"/></span> <br>
    							<span class="badge badge-dark"><%=act.getInstitucion()%></span>
    							<br>
    							<%
    							for ( String ncat : act.getCategorias() )
    							{
    							%>
    								<span class="badge badge-info"><%=ncat%></span>
    							<%
    							}
    							%>
    						</div>
    					<% if (act.getImagen() == null) { %>
    						<img src="imagenes?id=" width="75" height="75" class="rounded-circle">
    					<% } else {  %>
      						<img src="imagenes?id=<%=act.getImagen()%>" width="75" height="75" class="rounded-circle">
      					<% } %>
    					</div>
 						</a>
 						</div>
 				 	<% 
					}
				 	%>
         	</div>
        <% 
				}
				if (actividades.size() == 0 && cuponeras.size() == 0)
				{
				%>
					<div class="alert alert-danger" role="alert">
  					No se encontraron resultados para la búsqueda <b><%=consulta%></b>
				 	</div>
				<%
				}
				%>
			</div>
			<div id="filtros" class="col-6 col-md-3 my-4">
			 <div class="form-inline">
                        <label for="ordenarPor">Orden:</label>
                        <select class="form-control-sm" id="ordenarPor">
                              <option value="az" selected="selected">Alfabeticamente (a-z)</option>
                              <option value="za">Alfabeticamente (z-a)</option>
                              <option value="new">Fecha (nuevo primero)</option>
                              <option value="old">Fecha (viejo primero)</option>
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
							    <select multiple class="form-control" id="institucionesFiltro" name="institucionesFiltro">
							    <% 
								for(String nominst :instituciones) {
								%>
							      <option value="<%= nominst.replaceAll("\\s+","")  %>"><%= nominst  %></option>
							    <% } %>	
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
                                <select multiple class="form-control" id="categoriasFiltro" name="categoriasFiltro">
                                <% 
								for(String nomcat :categorias) {
								%>
							      <option value="<%= nomcat.replaceAll("\\s+","")  %>"><%= nomcat  %></option>
							    <% } %>	
                                </select>
                             </div>
					    </div>
					  </div>
				</div>
				<button type="button" class="btn btn-block btn-secondary" onclick="aplicarFiltros()">Aplicar</button>
				<button type="button" class="btn btn-block btn-secondary" onclick="removerFiltros()">Remover filtros</button>
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