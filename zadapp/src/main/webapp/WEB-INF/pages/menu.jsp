<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	nav{
            background-color: rgba(55, 28, 92, 0.8);
            border: solid black 0.5px;
            position: fixed;
            top: 0;
            width: 100vw;
    }

    nav > a{
            text-decoration: none;
			font-size: larger;
            margin-left: 2rem;
            padding-right: 1rem;
            color: rgba(6, 159, 247, 0.8);
    }
</style>
</head>
<body>
	<nav>
		<a href="/zadapp/app/home">Pocetna</a>
		<a href="/zadapp/app/createpro">Dodaj proizvodjaca</a>
		<a href="/zadapp/app/viewall">Prikazi sve proizvodjace</a>
		<a href="/zadapp/app/findpro">Prikazi proizvodjaca</a>
		<a href="/zadapp/app/logout">Log out</a>
	</nav>
</body>
</html>