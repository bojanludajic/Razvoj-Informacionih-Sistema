<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Prikaz karata</title>
</head>
<body>
	<h1>Prikaz karata</h1>
	<table border="1">
		<tr>
			<td>ID</td>
			<td>Cena</td>
			<td>Datum</td>
			<td>Posetilac</td>
		</tr>
		<c:forEach items="${karte}" var="k">
			<tr>
				<th>${k.idKarta}</th>
				<th>${k.cena}</th>
				<th>${k.datumRezervacije}</th>
				<th>${k.posetilac.ime} ${k.posetilac.prezime}</th>
			</tr>
		</c:forEach>
	</table><br>
	<form action="/Pozoriste/karte/kartePoDatumu" method="get">
		<label for="datum">Datum:</label>
		<input type="date" id="datum" name="datum" />
		<button type="submit">Filtriraj karte po datumu</button>
	</form>
</body>
</html>