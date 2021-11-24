<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="controladores.ListarUsuarios"%>
<%@page import="publicadores.InfoBasicaUser"%>
<%@page import="publicadores.InfoBasicaSocio"%>
<%@page import="publicadores.InfoBasicaProfesor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>

<%

List<String> instituciones = (List<String>) request.getAttribute("instituciones");
Iterator<String> institucionesI = instituciones.iterator();

%>

<!doctype html>
<html lang="en">
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<meta charset="UTF-8"/>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="entrenamos.uy">
<meta name="author" content="mbarrera">
<!-- Bootstrap CSS -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/sticky-footer-navbar.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<title>entrenamos.uy</title>
</head>
<body>


<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">

		<jsp:include page="/WEB-INF/template/sidebar.jsp" />

         <div class="col-12 col-md-8 my-4">
				<section class="clean-block clean-form dark">
					<div class="container">
					
					
		<% if ( request.getAttribute("altaUsuarioEstado") != null ) {
			boolean estadoAlta =  (boolean) request.getAttribute("altaUsuarioEstado");
			//si hay estado, entonces hay mensaje
			String msn = (String) request.getAttribute("MensajeRespuesta"); 
			
		%>
		<% if (estadoAlta == false) { %>
		<div class="alert alert-danger alert-dismissible fade show  my-4" role="alert">
		  <%= msn %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% if (estadoAlta == true) { %>
		<div class="alert alert-success alert-dismissible fade show  my-4" role="alert">
		  <%= msn %>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		<% } %>
		<% } %>
					
					
						<div class="block-heading">
							<h2 class="text-info">Alta Usuario</h2>
						</div>
						<form action="${pageContext.request.contextPath}/altaUsuario" accept-charset="character_set" method="post" enctype="multipart/form-data">
							<div class="form-group">
								<label>Nickname</label>
								<input class="form-control item"
									name="nickname" required minlength="1" maxlength="100" />
							</div>
							<div class="form-group">
								<label>Nombre</label>
								<input class="form-control item" required
									name="nombre" minlength="1" maxlength="100" />
							</div>
							<div class="form-group">
								<label>Apellido</label>
								<input class="form-control item"
									name="apellido" required minlength="1" maxlength="100" />
							</div>
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" name="email" class="form-control item" id="email" inputmode="email" />
							</div>
							<div class="form-group">
								<label>Fecha Nacimiento</label> <input class="form-control"
									type="date" name="fecha" required/>
							</div>
							<div class="form-group">
								<label>Contrasenia</label> <input id="pass" type="password"
									name="pass" class="form-control" required minlength="1" maxlength="100" />
							</div>
							<div class="form-group">
								<label>Confirmar contrasenia</label> <input id="confpass"
									name="passVerificacion" type="password" class="form-control" required minlength="1"
									maxlength="100" />
							</div>
							
							<div class="form-group">
								
								<label >Imagen</label>
									<input type="file" class="form-control-file" accept="image/*" name="imagenUsuario">
								</div>
							
							</div>
							
							<div class="form-group">
								<div class="form-check">
									<input type="checkbox" class="form-check-input"
										name="esProfesor" id="formCheck-1" />
										<label class="form-check-label"
										for="formCheck-1">Profesor</label>
								</div>
							</div>
							<div class="form-group">
								<label>Institucion</label> <select id="institucionSelec"
									name="institucion" class="form-control soloProfesor " required>
									<option value="" selected>Seleccione institucion</option>
									
									<% 
									while(institucionesI.hasNext()){
										String auxInst = institucionesI.next();
									%>
									<option value="<%=auxInst%>"><%=auxInst%></option>
									<% } %>
								</select>
							</div>
							<div class="form-group">
								<label for="email">Descripcion</label><input
									name="descripcion" class="form-control item soloProfesor" id="email-7" />
							</div>
							<div class="form-group">
								<label for="email">Bibliografia</label><input
									name="bibliografia" class="form-control item soloProfesor" id="email-6" />
							</div>
							<div class="form-group">
								<label for="email">Sitio web</label><input
									name="web" class="form-control soloProfesor" />
							</div>
							<button id="boton-1" class="btn btn-primary btn-block"
								style="width: 40%;" type="submit">Alta usuario</button>
						</form>
					</div>
				</section>
		</div>
		</div>
	</main>
	<br />
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

	<script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>


	<script>
   		$(function() {
            enable_cb();
            $("#formCheck-1").click(enable_cb);
         });

         function enable_cb() {
           if (this.checked) {
             $(".soloProfesor").removeAttr("disabled");
           } else {
             $(".soloProfesor").attr("disabled", true);
           }
         }
      </script>

	<script>
            $("form").submit(function(e){

            	//Compruebo si al seleccionar profesor tambien selecciono una inst dep
            	if( $("#formCheck-1").prop('checked') ) {
					if (  $( "#institucionSelec" ).val()  == "" ){
					   alert ("Seleccione una institucion");
					   e.preventDefault(e);
					}
            	}
            	
				//compruebo que las password sean iguales
				var pass = $("#pass").val();
				var confpass = $("#confpass").val();
				if (  !(pass  === confpass) ){
				
				   alert ("Las contrasenias no coinciden");
				   e.preventDefault(e);
				}
            	
                
            });
      </script>

</body>
</html>