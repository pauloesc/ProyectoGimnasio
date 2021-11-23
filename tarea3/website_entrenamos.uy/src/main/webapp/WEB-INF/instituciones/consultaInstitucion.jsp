<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	String nominst = (String) request.getAttribute("institucion");
	Set<String> actividades = (Set<String>) request.getAttribute("actividades");
	List<String> cuponeras = (List<String>) request.getAttribute("cuponeras");
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
			<div class="col-12 col-md-8 my-4">
				<h1><%= nominst  %></h1>
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="actividadesdeportivas-tab" data-toggle="tab"
						href="#actividadesdeportivas" role="tab" aria-controls="actividadesdeportivas"
						aria-selected="true">Actividades Deportivas</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="cuponeras-tab" data-toggle="tab" href="#cuponeras" role="tab"
						aria-controls="cuponeras" aria-selected="false">Cuponeras</a></li>
					
				</ul>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="actividadesdeportivas"
						role="tabpanel" aria-labelledby="actividadesdeportivas-tab">
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
  						int i = 1;
  						if (actividades != null)
								for(String nomact :actividades) {
							%>	
   							<tr>
     						 <th scope="row"><%= i  %></th>
      							<td> <a href="consultaActividad?actividad=<%= nomact  %>"><%= nomact  %></a> </td>
    						</tr>
    						<%
    							i++;
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
     							 <th scope="col">Nombre</th>
    							</tr>
  							</thead>
  							<tbody>
  							<% 
  							int i2 = 1;
  							if (cuponeras != null)
									for(String nomcup :cuponeras) {
									%>	
   							 	<tr>
     						 	<th scope="row"><%= i2%></th>
      							<td><a href="consultaCuponera?cuponera=<%= nomcup%>"> <%= nomcup%></a></td> 
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