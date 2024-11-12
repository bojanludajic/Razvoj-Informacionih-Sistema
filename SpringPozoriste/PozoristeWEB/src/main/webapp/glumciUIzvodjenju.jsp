<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Glumci u izvodjenju</title>
</head>
<body>
	<h1>Glumci u izvodjenju</h1>
	<c:if test="${!empty glumci}">
		<table border="1">
			<tr>
				<th>Ime</th>
				<th>Prezime</th>
			</tr>
			<c:forEach items="${glumci}" var="g">
				<tr>
					<td>${g.ime}</td>
					<td>${g.prezime}</td>
				</tr>
			</c:forEach>
		</table>
		<p>Broj glumaca u izvodjenju: ${glumci.size()}</p>
	</c:if>
	<c:if test="${!empty prouka }">
		<p>${poruka}</p>
	</c:if>
</body>
</html>