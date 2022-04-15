<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	h2{
		font-size: 100px;
		text-align: center;
		margin-top: 40vh;
		color: white;
	}
	h1{
		font-size: 40px;
		text-align: center;
		color: white;
	}
		
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/menu.jsp" flush="true"/>
	<h2>Dobro dosli ${korisnik.username}!!!</h2>
	<h1>${message}</h1>
</body>
</html>