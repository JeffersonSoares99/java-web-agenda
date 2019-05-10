<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<title>Listagem de contatos</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.html">Menu Principal</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="adiciona-contato.html">Cadastre-se <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="busca-contatos">Lista
						de Clientes</a></li>
			
			</ul>
		</div>
	</nav>
	<div class="text-center">
		<h1>Lista de contatos</h1>
	</div>
	<br>
	<div class="container">
		<table class="table">
			<tr>
			<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Endereço</th>
				<th>Telefone</th>
				<th>Opcoes</th>
			</tr>
			<c:forEach var="pessoa" items="${contatos}">
			<tr>
				<td>${pessoa.id}</td>
				<td>${pessoa.nome}</td>
				<td>${pessoa.email}</td>
				<td>${pessoa.endereco}</td>
				<td>${pessoa.telefone}</td>
				<td> <a href="remover-contato" class="btn btn-danger"> Delete </a></td>
				
			</tr>
			</c:forEach>
		</table>
		
			<a href="index.html" class="btn btn-success"  type="submit">Home </a>
			
	</div>
</body>


</html>