<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>LogIn - entrenamos.uy</title>
     <!-- Bootstrap CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" >
    <link href="./resources/css/signin.css" rel="stylesheet">
</head>
  <body class="text-center">
    <form class="form-signin" method="post" action="LoginController">
      <img class="mb-4" src="./resources/img/login.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion</h1>
      <label for="inputEmail" class="sr-only">Email o Nickname</label>
      <input type="email" name="input_email" class="form-control" placeholder="Email o Nickname" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" name="input_password" class="form-control" placeholder="Contraseña" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Recordarme
        </label>
      </div>
      <button class="btn btn-lg btn-primary btn-block" name="btn_iniciarSesion" type="submit">Iniciar Sesion</button>
      <a href="index.html" class="btn btn-lg btn-secondary btn-block">Volver</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2021 - entrenamos.uy</p>
    </form>
  </body>
</html>