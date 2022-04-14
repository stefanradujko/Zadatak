<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dodaj proizvodjaca</title>
</head>
<body>
	<form action="/zadapp/app/addpro">
		<label>PIB:</label>
		<input type="text" name="pib">
		<br>
		<label>Maticni broj:</label>
		<input type="text" name="maticni">
		<br>
		<label>Adresa:</label>
		<input type="text" name="adresa">
		<br>
		<label>Mesto:</label>
		<input type="text" name="mesto">
		<br>
		<input type="submit" value="Sacuvaj">
	</form>
</body>
</html>