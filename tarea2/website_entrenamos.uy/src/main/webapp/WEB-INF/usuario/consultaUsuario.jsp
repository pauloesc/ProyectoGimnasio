<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="controladores.ConsultaUsuario"%>
<%@page import="logica.InfoBasicaUser"%>
<%@page import="logica.*"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>



<!doctype html>
<html lang="en">

<% 

boolean esSocio = (boolean) request.getAttribute("esSocio");
InfoBasicaUser informacionUusario = (InfoBasicaUser) request.getAttribute("infoUsuario");
InformacionActividad informacioActividad = (InformacionActividad) request.getAttribute("infoActividad");
Vector<String> usuariosSeguidores = (Vector<String>) request.getAttribute("usersSeguidores");
Vector<String> usuariosSiguiendo = (Vector<String>) request.getAttribute("usersSiguiendo");
Vector<DataCuponera> cuponerasSocio = (Vector<DataCuponera>) request.getAttribute("cuponeras");
InfoActividadProfe actDepsIngRech = (InfoActividadProfe) request.getAttribute("actDepIngRech");

%>

<% 
boolean aa = (boolean) request.getAttribute("esSocio");
if( aa == true ){ %><a>Its February</a><% }else{ %><a>Any month other than February</a><% } %>

<head>
   <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
   <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
   <meta name="description" content="entrenamos.uy">
   <meta name="author" content="mbarrera">
   <!-- Bootstrap CSS -->
   <link href="./resources/css/bootstrap.min.css" rel="stylesheet">
   <link href="./resources/css/sticky-footer-navbar.css" rel="stylesheet">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
   <title>entrenamos.uy</title>
   
</head>

<body>
 	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div class="container">
				<a class="navbar-brand" href="#">Entrenamos.uy</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarEntrenamos" aria-controls="navbarEntrenamos"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarEntrenamos">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link"
							href="home.html">Home <span class="sr-only">(current)</span></a>
						</li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#"
							id="navbarDropdownMenu" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Menu</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdownMenu">
								<a class="dropdown-item" href=consultaUsuario.html">Usuarios</a>
							</div>
						</li>
					</ul>
					<form class="form-inline my-2 my-md-0">
						<input class="form-control" type="text" placeholder="Buscar"
							aria-label="Search">
					</form>
				</div>
			</div>
			<div class="btn-group">
				<a href="login.html" class="btn btn-light btn-sm">Iniciar Sesion</a>
				<a href="altaUsuario.html" class="btn btn-light btn-sm">Registrarse</a>
			</div>
		</nav>

	</header>

	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row">
			<div class="col-6 col-md-4">
				<ul id="listaInstituciones" class="list-group my-4">
					<li class="list-group-item"><strong>Instituciones
							Deportivas</strong></li>
					<li class="list-group-item"><a
						href="consultaInstitucion.html" class="">Telon</a></li>
					<li class="list-group-item">Instituto Natural</li>
					<li class="list-group-item">Olympic</li>
					<li class="list-group-item">Fuerza Bruta</li>
				</ul>
				<ul id="listaCategorias" class="list-group my-4">
					<li class="list-group-item"><strong>Categorías</strong></li>
					<li class="list-group-item">Al aire libre</li>
					<li class="list-group-item"><a href="consultaCategoria.html" class="">Deportes</a></li>
					<li class="list-group-item">Fintess</li>
					<li class="list-group-item">Gimnasia</li>
				</ul>
			</div>
         <div class="col-12 col-md-8">
            <div id="content">
               <div class="container-fluid">
                  <h3 class="text-dark mb-4">Perfil</h3>
                  <form>
                     <select class="form-control" required>
                            <option value="12" selected>Usuario 1</option>
                            <option value="13">Usuario 2</option>
                            <option value="14">Usuario 3</option>
                    </select>
                  </form>
                  <br />
                  <div class="row mb-3">
                     <div class="col-lg-4">
                        <div class="card mb-3">
                           <div class="card-body text-center shadow">
                              <img class="rounded-circle mb-3 mt-4" src="./resources/img/user.png" width="160"
                                 height="160" />
                           </div>
                        </div>
                        <div class="card mb-3">
                           <div class="card-body text-center shadow">
                              <button type="button" class="btn btn-success" style="font-size: smaller;">Seguir / Dejar de seguir</button>
                           </div>
                        </div>
                     </div>
                     <div class="col-lg-8">
                        <div class="row mb-3 d-none">
                           <div class="col">
                              <div class="card text-white bg-primary shadow">
                                 <div class="card-body">
                                    <div class="row mb-2">
                                       <div class="col">
                                          <p class="m-0">Peformance</p>
                                          <p class="m-0"><strong>65.2%</strong></p>
                                       </div>
                                       <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                    </div>
                                    <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i> 5% since last
                                       month
                                    </p>
                                 </div>
                              </div>
                           </div>
                           <div class="col">
                              <div class="card text-white bg-success shadow">
                                 <div class="card-body">
                                    <div class="row mb-2">
                                       <div class="col">
                                          <p class="m-0">Peformance</p>
                                          <p class="m-0"><strong>65.2%</strong></p>
                                       </div>
                                       <div class="col-auto"><i class="fas fa-rocket fa-2x"></i></div>
                                    </div>
                                    <p class="text-white-50 small m-0"><i class="fas fa-arrow-up"></i> 5% since last
                                       month
                                    </p>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <div class="row">
                           <div class="col">
                              <div class="card shadow mb-3">
                                 <div class="card-header py-3">
                                    <p class="text-primary m-0 font-weight-bold">Informacion Basica</p>
                                 </div>
                                 <div class="card-body">
                                    <div class="form-row">
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="username">
                                                <strong>Nombre</strong>
                                             </label>
                                             <input value="<%= informacionUusario.getNombre() %>" readonly type="text" class="form-control" id="username" name="username" />
                                          </div>
                                       </div>
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="email">
                                                <strong>Email</strong>
                                             </label>
                                             <input value=<%= informacionUusario.getCorreo() %>"" readonly type="email" class="form-control" id="email" name="email" />
                                          </div>
                                       </div>
                                    </div>
                                    <div class="form-row">
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="first_name">
                                                <strong>Apellido</strong>
                                             </label>
                                             <input value="<%= informacionUusario.getApellido() %>" readonly type="text" class="form-control" id="first_name"
                                                name="first_name" />
                                          </div>
                                       </div>
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="last_name">
                                                <strong>Fecha nacimiento</strong>
                                             </label>
                                             <input value="<%= informacionUusario.getFechaNac() %>" readonly type="text" class="form-control" id="last_name" name="last_name" />
                                          </div>
                                       </div>
                                    </div>

									<% 
									if( !esSocio ){
										InfoBasicaProfesor infoBasicaP = (InfoBasicaProfesor) informacionUusario;
									%>
                                    <div class="form-row soloProfesor">
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="first_name">
                                                <strong>Institucion</strong>
                                             </label>
                                             <input value="<%= infoBasicaP.getInstitucion() %>" readonly type="text" class="form-control" id="first_name"
                                                name="first_name" />
                                          </div>
                                       </div>
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="last_name">
                                                <strong>Descripcion</strong>
                                             </label>
                                             <textarea  rows="1" readonly type="text" class="form-control"><%= infoBasicaP.getInstitucion() %></textarea>
                                          </div>
                                       </div>
                                    </div>
									
                                    
                                    <div class="form-row soloProfesor">
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="first_name">
                                                <strong>Bibliografia</strong>
                                             </label>
                                             <textarea rows="1" readonly type="text" class="form-control"><%= infoBasicaP.getBibliografia() %></textarea>
                                          </div>
                                       </div>
                                       <div class="col">
                                          <div class="form-group">
                                             <label for="last_name">
                                                <strong>Url</strong>
                                             </label>
                                             <textarea rows="1" readonly type="text" class="form-control"><%= infoBasicaP.getUrl() %></textarea>
                                          </div>
                                       </div>
                                    </div>
                                 
                                 <% } %>

                                 </div>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>

                  <!-- inicio bloque ** Actividades deportivas ingresadas (Aceptada) -->
                  	<% 
					if( !esSocio ){
					%>
                  <div class="card shadow mb-5 soloProfesor">
                     <div id="act-dep" class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Actividades deportivas ingresadas (Aceptada)</p>
                     </div>
                     <div id="act-dep-cont" class="card-body">
                        <div class="row">
                           <table class="table table-hover">
                              <thead>
                                 <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Descripcion</th>
                                 </tr>
                              </thead>
                              <tbody>
                              <% 
                              
	          					InfoActividadProfe oo = (InfoActividadProfe) informacioActividad;
	          					Vector<DtActividadesDeportivas> vec = new Vector<DtActividadesDeportivas>();
	          					Vector<Object> vecGenerico = oo.obtenerVector();
	          					Iterator<Object> iterat = vecGenerico.iterator();
	          					while( iterat.hasNext() ) {
	          						Object aux =  iterat.next( );
	          						vec.add( (DtActividadesDeportivas) aux );
	          					}
          						
	        					Iterator<DtActividadesDeportivas> iterat2 = vec.iterator();
	        					while( iterat2.hasNext() ) {
	        						
	        					DtActividadesDeportivas mier = iterat2.next();
	          					
                              %>
                                 <tr>
                                    <th scope="row"></th>
                                    <td> <a href="consultaActividadDeportiva.html"><%= mier.getNombre() %></a></td>
                                    <td><%= mier.getDescripcion() %></td>
                                 </tr>
                                 
                                <% } %>
                                
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
                  <% } %>
                  <!-- fin bloque ** Actividades deportivas ingresadas (Aceptada) -->


                  <div class="card shadow mb-5">
                     <div id="clases" class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Clases</p>
                     </div>
                     <div id="clases-cont" class="card-body">
                        <div class="row">
                           <table class="table table-hover">
                              <thead>
                                 <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Actividad deportiva</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <th scope="row">1</th>
                                    <td> <a href="consultaDictadoDeClases.html">Voleibol</a></td>
                                    <td>10/06/21</td>
                                    <td>Voleibol</td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>

                  <div class="card shadow mb-5 soloProfesor propioProfesor">
                     <div id="act-dep-ing" class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Actividades deportivas ingresadas (Ingresada,
                           Rechazada)</p>
                     </div>
                     <div id="act-dep-ing-cont" class="card-body">
                        <div class="row">
                           <table class="table table-hover">
                              <thead>
                                 <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Descripcion</th>
                                    <th scope="col">Estado</th>
                                 </tr>
                              </thead>
                              <tbody>
                                 <tr>
                                    <th scope="row">1</th>
                                    <td>Voleibol II</td>
                                    <td>Voleibol avanzado.</td>
                                    <td>Rechazada</td>
                                 </tr>
                                 <tr>
                                    <th scope="row">2</th>
                                    <td>Basquetbol II</td>
                                    <td>Basequetbol avanzado.</td>
                                    <td>Ingresada</td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>

						<div class="card shadow mb-5">
							<div id="cuponeras" class="card-header py-3">
								<p class="text-primary m-0 font-weight-bold">Cuponeras del
									socio</p>
							</div>
							<div id="cuponeras-cont" class="card-body">
								<div class="row">
									<table class="table table-hover">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">Nombre</th>
												<th scope="col">Descripcion</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row">1</th>
												<td><a href="consultaCuponera.html">Pelota</a></td>
												<td>Deportes con pelota</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

                  <div class="card shadow mb-5">
                     <div id="seguidos-siguiendo" class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Seguidores y Sigue</p>
                     </div>
                     <div id="seguidos-siguiendo-cont" class="product-info">
                        <div>
                            <ul class="nav nav-tabs" role="tablist" id="myTab">
                                <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab" id="specifications-tabs" href="#specifications">Seguidores</a></li>
                                <li class="nav-item" role="presentation"><a class="nav-link" role="tab" data-toggle="tab" id="reviews-tab" href="#reviews">Sigue</a></li>
                            </ul>
                            <div class="tab-content" id="myTabContent">
                                <div class="tab-pane fade specifications" role="tabpanel" id="specifications">
                                    <div class="table-responsive table-bordered">
                                        <table class="table table-bordered">
                                            <tbody>
                                                <tr>
                                                    <td class="stat">Nickname</td>
                                                    <td>.</td>
                                                </tr>
                                                <tr>
                                                    <td class="stat"></td>
                                                    <td>.</td>
                                                </tr>
                                                <tr>
                                                    <td class="stat"></td>
                                                    <td>.</td>
                                                </tr>
                                                <tr>
                                                    <td class="stat"></td>
                                                    <td>.</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="tab-pane fade" role="tabpanel" id="reviews">
                                 <div class="table-responsive table-bordered">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <tr>
                                                <td class="stat">Nickname</td>
                                                <td>.</td>
                                            </tr>
                                            <tr>
                                                <td class="stat">Camera</td>
                                                <td>.</td>
                                            </tr>
                                            <tr>
                                                <td class="stat">RAM</td>
                                                <td>.</td>
                                            </tr>
                                            <tr>
                                                <td class="stat">OS</td>
                                                <td>.</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                  </div>


               </div>
            </div>
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
   <script>
      $(document).ready(function () {
         $('.menuContainer').load('./menu.html');
         
         profesor = 1;
         profesorPerfilPropio = 1;
         FuncionMostrarDependiendoProfSocio(profesor);
         EsElPropioProfesor( (profesorPerfilPropio*profesor) );

         //ocultar info

      });
   </script>
   <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
      integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
      crossorigin="anonymous"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
      integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
      crossorigin="anonymous"></script>

   <script>
         
   function FuncionMostrarDependiendoProfSocio(esProf) {
      if ( esProf === 1 ) {
         $(".soloProfesor").show();
      }
      else{
         $(".soloProfesor").hide();
         $(".propioProfesor").hide();
      }
   }

   function EsElPropioProfesor(profesorPerfilPropio) {
         if ( profesorPerfilPropio === 1 ) {
            $(".propioProfesor").show();
      }
      else{
         $(".propioProfesor").hide();
      }
   }

   </script>

   <script>
      var visible = true;
      $("#act-dep").click(function () {

         if (visible) {
            $("#act-dep-cont").hide();
            visible = false;
         } else {
            $("#act-dep-cont").show();
            visible = true;
         }
      });
   </script>

<script>
   var visible = true;
   $("#clases").click(function () {

      if (visible) {
         $("#clases-cont").hide();
         visible = false;
      } else {
         $("#clases-cont").show();
         visible = true;
      }
   });
</script>

<script>
   var visible = true;
   $("#act-dep-ing").click(function () {

      if (visible) {
         $("#act-dep-ing-cont").hide();
         visible = false;
      } else {
         $("#act-dep-ing-cont").show();
         visible = true;
      }
   });
</script>

<script>
   var visible = true;
   $("#cuponeras").click(function () {

      if (visible) {
         $("#cuponeras-cont").hide();
         visible = false;
      } else {
         $("#cuponeras-cont").show();
         visible = true;
      }
   });
</script>

<script>
   var visible = true;
   $("#seguidos-siguiendo").click(function () {

      if (visible) {
         $("#seguidos-siguiendo-cont").hide();
         visible = false;
      } else {
         $("#seguidos-siguiendo-cont").show();
         visible = true;
      }
   });
</script>

<style>
   #seguidos-siguiendo:hover, #cuponeras:hover, #act-dep-ing:hover, #clases:hover, #act-dep:hover  {
   background-color: rgb(232,232,232); /* (150% zoom - Note: if the zoom is too large, it will go outside of the viewport) */
}
</style>

</body>

</html>