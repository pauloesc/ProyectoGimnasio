<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>


<%
	Set<String> instituciones= (Set<String>) request.getSession().getAttribute("Instituciones");
	Set<String> categorias= (Set<String>) request.getSession().getAttribute("Categorias");
	
%>
<div id="sidebar" class="col-12 col-md-4">
	<ul id="listaInstituciones" class="list-group my-4">
		<li class="list-group-item"><strong>Instituciones Deportivas</strong></li>
		<% 
		for(String nominst :instituciones) {
		%>	
		<li class="list-group-item"><a class="nombreInst" href="consultaInstitucion?institucion=<%= nominst  %>"><%= nominst %></a></li>
		<% } %>	
	</ul>
	<ul id="listaCategorias" class="list-group my-4">
		<li class="list-group-item"><strong>Categorías</strong></li>
		<% 
		for(String nomcat :categorias) {
		%>
		<li class="list-group-item"><a class="nombreCat" href="consultaCategoria?categoria=<%= nomcat  %>"><%= nomcat %></a></li>
		<% } %>	
	</ul>
</div>