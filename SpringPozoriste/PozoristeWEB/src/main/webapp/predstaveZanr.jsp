<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pregled predstava</title>
</head>
<body>
	<h1>Pregled predstava po zanru</h1>
	<form action="/Pozoriste/predstave/getPredstave" method="get">
		Zanrovi: <select name="zanr">
			<c:forEach items="${zanrovi}" var="z">
				<option value="${z.idZanr}">${z.naziv}</option>
			</c:forEach>
		</select>
		<button type="submit">Prikazi predstave</button>
	</form>
	<br>
	<c:if test="${!empty predstaveMapa}">
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Naziv</th>
			</tr>
			<c:forEach items="${predstaveMapa}" var="p">
				<tr>
					<td>${p.key}</td>
					<td>${p.value}</td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<form action="/Pozoriste/predstave/refreshPage" method="post">
			<button type="submit">Osvezi</button>
	</c:if>
</body>
</html>