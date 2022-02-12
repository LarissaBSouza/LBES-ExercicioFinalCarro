<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="style.css">
<!-- CSS Local -->

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<!--  CSS Bootstrap -->

<title>IPVA</title>
</head>
<body>
	<header>
		<h1>Carros</h1>
	</header>
	<table class="container table mt-3 mb-3">
		<thead>
			<tr>
				<th scope="col"><a class="btn btn-primary" href="form.jsp"
					role="button">Adicionar Veículo</a></th>
			</tr>
		</thead>
	</table>
<!--	<div class="card text-dark bg-warning mb-3" style="max-width: 18rem;">
 	<div class="card-header">IPVA</div>
		<div class="card-body">
			<h5 class="card-title">${ipva.ano}</h5>
		</div>
	</div> -->	
	<table class="container table mt-3 mb-3">
		<thead class="table-dark">
			<tr>
				<th scope="col">ID</th>
				<th scope="col">Modelo Veículo</th>
				<th scope="col">Ano</th>
				<th scope="col">IPVA</th>
				<th scope="col">Alterar</th>
				<th scope="col">Deletar</th>
			</tr>
		</thead>

		<c:forEach items="${veiculos}" var="veiculos">
			<tr>
				<td>${veiculos.id}</td>
				<td>${veiculos.modelo}</td>
				<td>${veiculos.ano}</td>
				<td><a href="?id=${veiculos.id}&alterar=1">Alterar</a></td>
				<td><a href="?id=${veiculos.id}&alterar=0">Remover</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>