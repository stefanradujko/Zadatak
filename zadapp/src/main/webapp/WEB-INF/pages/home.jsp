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
	
	h2{
		font-size: 100px;
		text-align: center;
		margin-top: 40vh;
		color: rgba(79, 84, 105, 0.8);
	}
	h1{
		font-size: 40px;
		text-align: center;
		color: rgba(79, 84, 105, 0.8);
	}
		
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/backandfont.jsp" flush="true"/>
	<jsp:include page="/WEB-INF/pages/menu.jsp" flush="true"/>
	<h2>Dobro dosli ${korisnik.username}!!!</h2>
	<h1>${message}</h1>
</body>
</html>