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

<title>Cadastro de Veículos</title>
</head>
<body>
	<header>
		<h1>Cadastro de Veículos</h1>
	</header>

	<div class="container w-50 form">

		<form method="post" action="ServletIPVA">
			<div class="container">
				<h1 class=" col mt-4 mb-4 form-tittle">Cadastrar Veículo</h1>
			</div>
			<input type="hidden" name="id" value="${id}">
			<div class="col mb-4 mt-4">
				<label for="exampleInputNome1" class="form-label">Modelo
					Veículo</label> <input type="text" class="form-control" name="modelo"
					value="${modelo}">
			</div>
			<div class="col mb-4 mt-4">
				<label for="exampleInputEmail1" class="form-label">Ano</label> <input
					type="text" class="form-control" name="ano" value="${ano}">
			</div>
			<div class="col mb-4 mt-4">
				<input type="hidden" class="form-control" name="ipva"> <a
					href="index.jsp"><button type="submit"
						class="btn btn-primary col-6 mb-3">Salvar</button></a>
			</div>
		</form>
	</div>
</body>
</html>