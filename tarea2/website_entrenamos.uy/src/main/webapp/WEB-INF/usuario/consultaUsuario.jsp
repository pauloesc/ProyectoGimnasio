<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="publicadores.InfoBasicaUser"%>
<%@page import="publicadores.InfoBasicaSocio"%>
<%@page import="publicadores.InfoBasicaProfesor"%>

<%@page import="publicadores.DataCuponera"%>
<%@page import="publicadores.DtActividadesDeportivas"%>
<%@page import="publicadores.DtClase"%>
<%@page import="publicadores.DtPremio"%>
<%@page import="publicadores.EstadoActi"%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.text.SimpleDateFormat"%>



<!doctype html>
<html lang="en">

<% 

boolean esSocio = (boolean) request.getAttribute("esSocio");
InfoBasicaUser informacionUusario = (InfoBasicaUser) request.getAttribute("infoUsuario");
List<String> usuariosSeguidores = (List<String>) request.getAttribute("usersSeguidores");
List<String> usuariosSiguiendo = (List<String>) request.getAttribute("usersSiguiendo");
List<DataCuponera> cuponerasSocio = (List<DataCuponera>) request.getAttribute("cuponeras");
List<DtPremio> premios = (List<DtPremio>) request.getAttribute("premios");
List<DtActividadesDeportivas> actDepIR = (List<DtActividadesDeportivas>) request.getAttribute("actDepIngRech");

List<DtClase> informacionSocio = (List<DtClase>) request.getAttribute("infoSocio");
List<DtActividadesDeportivas> informacionProfesor = (List<DtActividadesDeportivas>) request.getAttribute("infoProfe");

boolean propioUsuario = (boolean) request.getAttribute("userPropio");

SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
String dateString = formato.format(informacionUusario.getFechaNac().toGregorianCalendar().getTime());


boolean haySesion = (boolean) request.getAttribute("haySesion");

boolean siguiendoUsuario = (boolean) request.getAttribute("siguiendoUsuario");

List<DtActividadesDeportivas> ListaActividadesDepProfesor = (List<DtActividadesDeportivas>) request.getAttribute("infoActivvProfe");

%>

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
<jsp:include page="/WEB-INF/template/header.jsp" />

	<!-- Begin page content -->
	<main role="main" class="container">
		<div class="row my-4">

		<jsp:include page="/WEB-INF/template/sidebar.jsp" />

         <div class="col-12 col-md-8 my-4">
            <div id="content">
               <div class="container-fluid">
                  <h3 class="text-dark mb-4">Perfil</h3>
                  <div class="row mb-3">
                     <div class="col-lg-4">
                        <div class="card mb-3">
                           <div class="card-body text-center shadow">
                        
                              <img class="rounded-circle mb-3 mt-4" src="imagenes?id=<%= informacionUusario.getImg() %>" width="160"
                                 height="160" />
                           </div>
                        </div>
                        
                        <% 
                        //voy a imprimir el voton solo cuando exista una sesion y no sea la propia
                        if ( haySesion && !propioUsuario ) {
                        %>
                        
                        	<% if (siguiendoUsuario){ %>
                        
								<div class="card mb-3">
								<div class="card-body text-center shadow">
								<a href="${pageContext.request.contextPath}/SeguirDejarDeSeguir?usuarioNick=<%=informacionUusario.getNickname() %> " ><button type="button" class="btn btn-warning" style="font-size: smaller;">Dejar de seguir</button></a>
								</div>
								</div>
                        
                        	<% 
                        	}
                        	else { 
                        	%>
                        	
								<div class="card mb-3">
								<div class="card-body text-center shadow">
								<a href="${pageContext.request.contextPath}/SeguirDejarDeSeguir?usuarioNick=<%=informacionUusario.getNickname() %> " ><button type="button" class="btn btn-success" style="font-size: smaller;"> Seguir</button></a>
								</div>
								</div>
                        	
                        	<% } %>
                        
                        <% } %>
                        
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
                                             <input value="<%= informacionUusario.getCorreo() %>" readonly type="email" class="form-control" id="email" name="email" />
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
                                             <input value="<%= dateString %>" readonly type="text" class="form-control" id="last_name" name="last_name" />
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
                                             <textarea  rows="1" readonly type="text" class="form-control"><%= infoBasicaP.getDesc() %></textarea>
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
                              	int i=1;
	          					Iterator<DtActividadesDeportivas> iterat2 = ListaActividadesDepProfesor.iterator();
	        					while( iterat2.hasNext() ) {
	        						DtActividadesDeportivas infoP = iterat2.next();
                              %>
                              
                              	<% if ( infoP.getEstado().equals(EstadoActi.ACEPTADA) ){ %>
                                 <tr>
                                    <th scope="row"><%=i%></th>
                                    <td> <a href="consultaActividad?actividad=<%= infoP.getNombre() %>  "><%= infoP.getNombre() %></a></td>
                                    <td><%= infoP.getDescripcion() %></td>
                                 </tr>
                              <% } %>
                                 
                                <% i++; } %>
                                
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
                  <% } %>
                  <!-- fin bloque ** Actividades deportivas ingresadas (Aceptada) -->


				<!-- inicio bloque ** clases ** para profesor -->
                  	<% 
					if( !esSocio ){
					%>
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
									<% int i2=1;
									Iterator<DtActividadesDeportivas> iterat2 = informacionProfesor.iterator();
									while( iterat2.hasNext() ) {
										DtActividadesDeportivas infoP = iterat2.next();
									%>
									
									<%
									List<DtClase> ListclasesInfo = infoP.getClases();
									Iterator<DtClase> iterListClases = ListclasesInfo.iterator();
									while ( iterListClases.hasNext() ){
										DtClase infoCla = iterListClases.next();
										
										String fechaFormateadaClase = formato.format(infoCla.getFecha().toGregorianCalendar().getTime());
										
									%>
                                 <tr>
                                    <th scope="row"><%=i2%></th>
                                    <td> <a href="consultaClase?clase=<%= infoCla.getNombre() %> "><%= infoCla.getNombre() %></a></td>
                                    <td><%= fechaFormateadaClase %></td>
                                    <td><a href="consultaActividad?actividad=<%= infoP.getNombre() %>" ><%= infoP.getNombre() %></a></td>
                                 </tr>
									<% 
									i2++;}}
									%>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
					<% 
					}
					%>
                  <!-- fin bloque ** clases ** para profesor -->
                  
                  
                  <!-- inicio bloque ** clases ** para socio -->
                  	<% 
					if( esSocio ){
					%>
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
									
									<% int i3=1;
									Iterator<DtClase> iterat3 = informacionSocio.iterator();
									while( iterat3.hasNext() ) {
										DtClase infoS = iterat3.next();
										
										String fechaFormateadaClase = formato.format(infoS.getFecha().toGregorianCalendar().getTime());
										
									%>
									
									<% if (infoS.getEstadoActividad().equals(EstadoActi.ACEPTADA)   ){ %>
                                 <tr>
                                    <th scope="row"><%=i3%></th>
                                    <td> <a href="consultaClase?clase=<%= infoS.getNombre() %>  "> <%= infoS.getNombre() %> </a></td>
                                    <td> <%= fechaFormateadaClase %> </td>
                                    <td><a href="consultaActividad?actividad=<%= infoS.getNomAct() %>" ><%= infoS.getNomAct() %></a></td>
                                 </tr>
                                 
                                 	<% } %>
                                 
									<% i3++;}%>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
					<% 
					}
					%>
                  <!-- fin bloque ** clases ** para socio -->
                  
                  
                 <!-- inicio bloque ** clases con activ dep finalizada ** para socio -->
                  	<% 
					if( esSocio & propioUsuario ){
					%>
                  <div class="card shadow mb-5">
                     <div id="clases" class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Clases con Actividad Dep Finalizada</p>
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
									
									<% int i3=1;
									Iterator<DtClase> iterat3 = informacionSocio.iterator();
									while( iterat3.hasNext() ) {
										DtClase infoS = iterat3.next();
										
										String fechaFormateadaClase = formato.format(infoS.getFecha().toGregorianCalendar().getTime());
										
									%>
									
									<% if (infoS.getEstadoActividad().equals(EstadoActi.FINALIZADA) ){ %>
                                 <tr>
                                    <th scope="row"><%=i3%></th>
                                    <td> <a href="consultaClase?clase=<%= infoS.getNombre() %>  "> <%= infoS.getNombre() %> </a></td>
                                    <td> <%= fechaFormateadaClase %> </td>
                                    <td><a href="consultaActividad?actividad=<%= infoS.getNomAct() %>" ><%= infoS.getNomAct() %></a></td>
                                 </tr>
                                 
                                 	<% } %>
                                 
									<% i3++;}%>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
					<% 
					}
					%>
                  <!-- fin bloque ** clases con activ dep finalizada ** para socio -->
                  
                  

					<!-- inicio bloque ** acd dep ing rech ** para profesor -->
					<% if(!esSocio & propioUsuario) { %>
                  <div class="card shadow mb-5 soloProfesor propioProfesor">
                     <div id="act-dep-ing" class="card-header py-3">
                        <p class="text-primary m-0 font-weight-bold">Actividades deportivas ingresadas (Ingresada,
                           Rechazada, Finalizada)</p>
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
                              <% int i4=1;
                              Iterator<DtActividadesDeportivas> infoAcInRecha = ListaActividadesDepProfesor.iterator();
                              while ( infoAcInRecha.hasNext() ){
                            	  DtActividadesDeportivas ii = infoAcInRecha.next();
                              
                              %>
                              <% if ( ! ii.getEstado().equals(EstadoActi.ACEPTADA) ){ %>
                                 <tr>
                                    <th scope="row"><%=i4%></th>
                                    <td> <a href="consultaActividad?actividad=<%= ii.getNombre() %>  "><%= ii.getNombre() %></a></td>
                                    <td><%= ii.getDescripcion() %></td>
                                    <td> <%= ii.getEstado() %>	 </td>
                                 </tr>
								<% } %>
								<% i4++;} %>
                                 
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </div>
                  <% } %>
				<!-- fin bloque ** acd dep ing rech ** para profesor -->


						<!-- inicio bloque ** cuponeras ** para socio -->
						<% if(esSocio & propioUsuario) { %>
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
										
										<%
										Iterator<DataCuponera> cuponeras =  cuponerasSocio.iterator();
										int cont = 1;
										while( cuponeras.hasNext() ){
											DataCuponera infoCuponera = cuponeras.next();
										%>
											<tr>
												<th scope="row"> <%= cont %> </th>
												<td><a href="ConsultaCuponera?cuponera=<%= infoCuponera.getNombre() %> "> <%= infoCuponera.getNombre()  %> </a></td>
												<td> <%= infoCuponera.getDescripcion() %> </td>
											</tr>
										<% 
										cont=cont+1;
										} %>	
										
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- fin bloque ** cuponeras ** para socio -->
						
						
						<!-- inicio pinche bloque ** premios ** para socio -->
						
						<div class="card shadow mb-5">
							<div id="premios" class="card-header py-3">
								<p class="text-primary m-0 font-weight-bold">Premios</p>
							</div>
							<div id="premios-cont" class="card-body">
								<div class="row">
									<table class="table table-hover">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">Nombre clase</th>
												<th scope="col">Nombre actividad</th>
												<th scope="col">Fecha ganado</th>
												<th scope="col">Certificado</th>
											</tr>
										</thead>
										<tbody>
										
										<%
										Iterator<DtPremio> prems =  premios.iterator();
										int contt = 1;
										while( prems.hasNext() ){
											DtPremio p = prems.next();
											String fprem = formato.format(p.getFecha().toGregorianCalendar().getTime());
											String fclas = formato.format(p.getFechaClase().toGregorianCalendar().getTime());
										%>
											<tr>
												<th scope="row"> <%= contt %> </th>
												<td><a href="consultaClase?clase=<%= p.getNomC() %>" > <%= p.getNomC()  %> </a></td>
												<td><a href="consultaActividad?actividad=<%= p.getNomA()  %>" > <%= p.getNomA() %> </a></td>
												<td> <%= fprem %> </td>
												<td> 
													<form method="post" action="generarPDF">
														<input type="hidden" id="nombreClase" name="nombreClase" value="<%= p.getNomC() %>">
														<input type="hidden" id="nombreSocio" name="nombreSocio" value="<%= informacionUusario.getNombre() %> <%= informacionUusario.getApellido() %> (<%= informacionUusario.getNickname() %>)">
														<input type="hidden" id="nombreActividad" name="nombreActividad" value="<%= p.getNomA() %>">
														<input type="hidden" id="fechaPremio" name="fechaPremio" value="<%= fprem %>"> 
														<input type="hidden" id="descrPremio" name="descrPremio" value="<%= p.getDescrPremio() %>">   
														<input type="hidden" id="fechaClase" name="fechaClase" value="<%= fclas %>">  
							     						<button type="submit" id="certificado" name="certificado" value="" class="btn">Descargar</button>
													</form>  
												</td>
											</tr>
										<% 
										contt=contt+1;
										} %>	
										
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<!-- fin bloque ** cuponeras ** para socio -->
						
						<% } %>
						
						

					<!-- inicio bloque ** seguidores sigue -->
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
                                            <%
                                            Iterator<String> uLosQuesiguen =  usuariosSeguidores.iterator();
                                            while( uLosQuesiguen.hasNext() ){
                                            	String usario = uLosQuesiguen.next();
                                            
                                            %>
                                                <tr>
                                                    <td class="stat"><a href="${pageContext.request.contextPath}/ConsultaUsuario?usuarioNick=<%= usario %>"> <%= usario %> </a></td>
                                                    <td>.</td>
                                                </tr>
                                                
											<% } %>
												
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="tab-pane fade" role="tabpanel" id="reviews">
                                 <div class="table-responsive table-bordered">
                                    <table class="table table-bordered">
                                        <tbody>
                                            <%
                                            Iterator<String> uSeg =  usuariosSiguiendo.iterator();
                                            while( uSeg.hasNext() ){
                                            	String usario2 = uSeg.next();
                                            
                                            %>
                                                <tr>
                                                    <td class="stat"> <a href="${pageContext.request.contextPath}/ConsultaUsuario?usuarioNick=<%= usario2 %>"> <%= usario2 %> </a></td>
                                                    <td>.</td>
                                                </tr>
                                                
											<% } %>
                                        </tbody>
                                    </table>
                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                  </div>
                  <!-- fin bloque ** seguidores sigue -->

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
   $("#premios").click(function () {

      if (visible) {
         $("#premios-cont").hide();
         visible = false;
      } else {
         $("#premios-cont").show();
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