<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Satisfy&display=swap');
	*{
        font-family: 'Satisfy', cursive;
        /* color: white; */
        }
	body{
		margin: 0;
		background-image: url("https://images4.alphacoders.com/936/thumb-1920-936378.jpg");
	}
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

	h2{
		font-size: 100px;
		text-align: center;
		margin-top: 40vh;
		color: white;
	}
		
</style>
</head>
<body>
	<nav>
		<a href="/zadapp/app/createpro">Dodaj proizvodjaca</a>
		<a href="/zadapp/app/viewall">Prikazi sve proizvodjace</a>
		<a href="/zadapp/app/findpro">Prikazi proizvodjaca</a>
		<a href="/zadapp/app/logout">Log out</a>
	</nav>
	<h2>Dobro dosli!!!</h2>
</body>
</html>