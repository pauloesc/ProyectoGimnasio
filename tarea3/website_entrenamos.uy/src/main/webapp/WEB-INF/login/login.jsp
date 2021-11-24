<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LogIn - entrenamos.uy</title>
<!-- Bootstrap CSS -->
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<link href="./resources/css/signin.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body class="text-center">
	<%
      	Boolean errorLogin = request.getSession().getAttribute("login-error") != null ? true : false;
      	String errorMsje = errorLogin == true ? (String)request.getSession().getAttribute("login-error") : "";
      %>
	<form class="form-signin" method="post" action="login">
		<img class="mb-4" src="imagenes?id=login.png" alt="" width="72"
			height="72">
		<h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion</h1>
		<label for="inputEmail" class="sr-only">Email o Nickname</label> <input
			type="text" name="input_email" class="form-control"
			placeholder="Email o nickname" value="" required autofocus> <label
			for="inputPassword" class="sr-only">Contraseña</label> <input
			type="password" name="input_password" class="form-control"
			placeholder="Contraseña" value="" required>
		<div class="checkbox mb-3">
			<label> <input type="checkbox" name="recordarme" value="1" />
				Recordarme
			</label>
		</div>
		<%= errorLogin ? 
	  		"<div class=\"alert alert-danger\" role=\"alert\">"
	  			+ errorMsje + 
	  		"</div>" 
	  	: 
	  		""
	  %>
		<button class="btn btn-lg btn-primary btn-block"
			name="btn_iniciarSesion" type="submit">Iniciar Sesion</button>
		<a href="home" class="btn btn-lg btn-secondary btn-block">Volver</a>
		<p class="mt-5 mb-3 text-muted">&copy; 2021 - entrenamos.uy</p>
	</form>
</body>
</html>