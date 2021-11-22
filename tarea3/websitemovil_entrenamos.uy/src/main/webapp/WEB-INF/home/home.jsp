<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="publicadores.DataCuponera"%>
<%@page import="publicadores.DataActividad"%>
<%@page import="java.util.Iterator"%>


<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/template/head.jsp" />

<style>
p {
box-sizing: border-box;
box-shadow: 0 2px 4px 0 rgba(0,0,0,.3);
padding: 20px 55px;
font-family: Georgia,serif;
font-size: 1.5em;
font-style: italic;
line-height: 1.4 !important;
color: gray;
text-shadow: 0 1px #fff;
background-color: #f5f7f5;
position: relative;
}

</style>

</head>
<%
	List<DataCuponera> cuponeras= (List<DataCuponera>) request.getAttribute("cuponeras");
	
	Set<DataActividad> actividades = (Set<DataActividad>) request.getAttribute("actividades");
%>


<body>
	<jsp:include page="/WEB-INF/template/header.jsp" />
	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-12 col-md-12">
				<br>
				<br>

					
				<h3 style="text-align: center; color:blue" ><i>Frases de deportistas</i></h3>
				<br>
				
		<div>
<p>La diferencia entre lo imposible y lo posible depende de la voluntad de un hombre. Tommy Lasorda</p><p>Un atleta no puede correr con el dinero en sus bolsillos. Debe trabajar con la esperanza en su corazón y los sueños en su cabeza. Emil Zapotek</p><p>Trata a una persona como es, y permanecerá como está. Trátala como podría ser, y se convertirá en lo que debería ser. Jimmy Johnson</p><p>Ganadores nunca se rinden y los que se rinden nunca ganan. Vince Lombardi</p><p>Se puede motivar con el miedo, se puede motivar con la recompensa. Pero esos dos métodos son sólo temporales. La única cosa duradera es la auto motivación. Homer Rice</p><p>No te midas por lo que has logrado, sino por lo que deberías haber logrado con tu capacidad. John Wooden</p><p>El dolor es temporal. Puede durar un minuto o una hora o un día, o un año, pero con el tiempo va a disminuir y algo más tomará su lugar. Sin embargo, si abandono, eso durará para siempre. Lance Armstrong</p><p>No preguntes lo que tus compañeros de equipo pueden hacer por ti. Pregúntate qué puedes hacer tú por tus compañeros de equipo. Magic Johnson</p><p>La excelencia no es un acto de un día, sino un hábito. Tú eres lo que repites en muchas ocasiones. Shaquille O’Neal</p><p>Un hombre muy ocupado para cuidar de su salud es como un mecánico muy ocupado por cuidar sus herramientas. Proverbio español</p>				
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