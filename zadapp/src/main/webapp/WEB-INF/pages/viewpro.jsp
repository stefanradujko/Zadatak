<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View proizvodjac</title>
</head>
<body>
	<form action="/zadapp/app/dosomething">
		<label>PIB:</label>
		<input type="text" name="pib" value="${proizvodjac.pib}" readonly="readonly">
		<br>
		<label>Maticni broj:</label>
		<input type="text" name="maticni" value="${proizvodjac.maticniBroj}">
		<br>
		<label>Adresa:</label>
		<input type="text" name="adresa" value="${proizvodjac.adresa}">
		<br>
		<label>Mesto:</label>
		<input type="text" name="mesto" value="${proizvodjac.mesto.naziv}">
		<br>
		<br>
		<input type="submit" name="action" value="Izmeni">
		<br>
		<br>
		<input type="submit" name="action" value="Izbrisi">
	</form>
</body>
</html>