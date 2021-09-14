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
      <%
      	Cookie[] cookies = request.getCookies();
      	String email = "", nickname = "", pass = "", recordarme = "0";
      	for (Cookie c : cookies)
      	{
      		if (c.getName().equals("password"))
      		{
      			pass = c.getValue();
      		}
      		else if (c.getName().equals("email"))
      		{
      			email = c.getValue();
      		}
      		else if (c.getName().equals("nickname"))
      		{
      			nickname = c.getValue();
      		}
      		else if (c.getName().equals("cRecordarme"))
      		{
      			recordarme = c.getValue();
      		}
      	}
      	Boolean errorLogin = request.getSession().getAttribute("error") != null ? true : false;
      	String errorMsje = errorLogin == true ? (String)request.getSession().getAttribute("error") : "";
      %>
    <form class="form-signin" method="post" action="LoginController">
      <img class="mb-4" src="./resources/img/login.png" alt="" width="72" height="72">
      <h1 class="h3 mb-3 font-weight-normal">Iniciar Sesion</h1>
      <label for="inputEmail" class="sr-only">Email o Nickname</label>
      <input type="text" name="input_email" class="form-control" placeholder="Email o nickname" 
      value="<%= email != "" ? email : nickname %>" required autofocus>
      <label for="inputPassword" class="sr-only">Contraseña</label>
      <input type="password" name="input_password" class="form-control" placeholder="Contraseña" value="<%= pass %>" required>
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" name="recordarme" value="1"
          	<%= "1".equals(recordarme.trim()) ? "checked" : "" %> 
          /> Recordarme
        </label>
      </div>
      <>
      <button class="btn btn-lg btn-primary btn-block" name="btn_iniciarSesion" type="submit">Iniciar Sesion</button>
      <a href="index.html" class="btn btn-lg btn-secondary btn-block">Volver</a>
      <p class="mt-5 mb-3 text-muted">&copy; 2021 - entrenamos.uy</p>
    </form>
  </body>
</html>