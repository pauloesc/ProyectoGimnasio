<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="controladores.Instituciones"%>
<%@page import="controladores.Categorias"%>
<%@page import="java.util.Set"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
	Set<String> instituciones;
	Set<String> categorias;
	try {
		instituciones = Instituciones.getInstituciones();
		categorias = Categorias.getCategorias();
	} 
	catch(Exception ex) {
		instituciones = null;
		categorias = null;
	}
%>
<div id="sidebar" class="col-6 col-md-4">
	<ul id="listaInstituciones" class="list-group my-4">
		<li class="list-group-item"><strong>Instituciones Deportivas</strong></li>
		<% 
		for(String nominst :instituciones) {
		%>	
		<li class="list-group-item"><a class="nombreInst" href="?institucion=<%= nominst  %>"><%= nominst %></a></li>
		<% } %>	
	</ul>
	<ul id="listaCategorias" class="list-group my-4">
		<li class="list-group-item"><strong>Categorías</strong></li>
		<% 
		for(String nomcat :categorias) {
		%>
		<li class="list-group-item"><a class="nombreCat" href="?categoria=<%= nomcat  %>"><%= nomcat %></a></li>
		<% } %>	
	</ul>
</div>