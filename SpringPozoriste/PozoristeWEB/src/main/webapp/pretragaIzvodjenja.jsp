<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pretraga izvodjenja</title>
</head>
<body>
	<form action="/Pozoriste/izvodjenje/getIzvodjenja" method="get">
		Naziv predstave: <input type="text" name="naziv"> <input
			type="submit" value="Pretrazi">
	</form>
	<br>
	<c:if test="${!empty izvodjenja}">
		<table border="1">
			<tr>
				<th>Datum izvodjenja</th>
				<th>Naziv scene</th>
				<th>Glumci</th>
			</tr>
			<c:forEach items="${izvodjenja}" var="i">
				<tr>
					<td>${i.datum}</td>
					<td>${i.scena.naziv}</td>
					<td><a
						href="/Pozoriste/izvodjenje/getGlumci?idIzvodjenja=${i.idIzvodjenje}">Glumci</a></td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
	<c:if test="${!empty poruka}">
		<p>${poruka}</p>
	</c:if>
</body>
</html>