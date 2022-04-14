<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all</title>
</head>
<body>
	<h2>Svi proizvodjaci:</h2>
	<table>
		<thead>
			<tr>
				<th>PIB</th>
				<th>Naziv</th>
				<th>Adresa</th>
				<th>Mesto</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${lista}">
					<tr>
						<th>${pro.pib}</th>
						<th>${pro.maticniBroj}</th>
						<th>${pro.adresa}</th>
						<th>${pro.mesto.naziv}</th>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>