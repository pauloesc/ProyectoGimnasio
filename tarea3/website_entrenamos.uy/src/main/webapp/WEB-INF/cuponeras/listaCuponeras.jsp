<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="publicadores.DataCuponera"%>

<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />
</head>
<%
	Integer total= (Integer) request.getAttribute("totalcups");
	List<DataCuponera> cups=(List<DataCuponera>) request.getAttribute("cups");
	DataCuponera[] cupsar= cups.toArray (new DataCuponera[total]);
    Integer pagnum= (Integer) request.getAttribute("pag");
    Boolean socio= (Boolean) request.getAttribute ("socio");
    
%>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">
			<jsp:include page="/WEB-INF/template/sidebar.jsp" />
					<div class="col-12 col-md-8">
				<h2>Cuponeras de actividades deportivas</h2>
				
				<% int i=1;
				if (i<4 && (((pagnum-1)*3)+i)<=total){ %>
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">					
						<div class="col-md-4 text-center">
							<img src="imagenes?id=<%= cupsar[i+((pagnum-1)*3)-1].getImagen()  %>" alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><%= cupsar[i+((pagnum-1)*3)-1].getNombre()%></h5>
								<p class="card-text"><%= cupsar[i+((pagnum-1)*3)-1].getDescripcion()%></p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href="consultaCuponera?cuponera=<%= cupsar[i+((pagnum-1)*3)-1].getNombre()%>" class="btn btn-primary">Detalles</a>
									
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%}%>
				<%i=i+1; 
				if (i<4 && (((pagnum-1)*3)+i)<=total){ %>
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">					
						<div class="col-md-4 text-center">
							<img src="imagenes?id=<%= cupsar[i+((pagnum-1)*3)-1].getImagen()  %>" alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><%= cupsar[i+((pagnum-1)*3)-1].getNombre()%></h5>
								<p class="card-text"><%= cupsar[i+((pagnum-1)*3)-1].getDescripcion()%></p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href="consultaCuponera?cuponera=<%= cupsar[i+((pagnum-1)*3)-1].getNombre()%>" class="btn btn-primary">Detalles</a>
									
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			   <%}%>
			   <%i=i+1; 
				if (i<4 && (((pagnum-1)*3)+i)<=total){ %>
				<div class="card mb-3" style="max-width: auto;">
					<div class="row no-gutters">					
						<div class="col-md-4 text-center">
							<img src="imagenes?id=<%= cupsar[i+((pagnum-1)*3)-1].getImagen()  %>" alt="..." width="242" height="200">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title"><%= cupsar[i+((pagnum-1)*3)-1].getNombre()%></h5>
								<p class="card-text"><%= cupsar[i+((pagnum-1)*3)-1].getDescripcion()%></p>
								<div class="d-md-flex justify-content-md-end">
									<div class="d-flex flex-column">
									<a href="consultaCuponera?cuponera=<%= cupsar[i+((pagnum-1)*3)-1].getNombre()%>" class="btn btn-primary">Detalles</a>
									
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<%}%>
				
				
				<div class="d-md-flex justify-content-md-center">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							</a></li>
							<% int i2=1; 
							float b = (float) total/3;
						
							int totalpag= (total/3);
						
							if (b >totalpag) {
								totalpag=totalpag+1;
							}
							
							while (i2<= (totalpag)) { 
							%>
							<li class="page-item"><a class="page-link" href="listaCuponeras?n=<%=i2 %>"><%=i2%></a></li>
							<%i2++;}%>
							<li class="page-item"><a class="page-link" href="#"
								aria-label="Next"> <span aria-hidden="true">&raquo;</span>
							</a></li>
						</ul>
					</nav>
				</div>
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