<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View proizvodjac</title>
<style>
	
	.form-container{
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }

        form{
            background-color: rgba(79, 84, 105, 0.8);
            border-color: transparent;
            height: 20rem;
            width: 20rem;
			margin-left: 42vw;
			margin-top: 30vh;
            display: flex;
            justify-content: start;
            flex-direction: column;
            text-align: center;
			font-size: 30px;
        }

        form>* {
            margin: auto;
            padding: auto;
        }
		input{
            background: transparent;
            border: none;
            border-bottom: 1px solid rgba(162, 174, 224, 0.8);
            height: 1.7rem;
            padding-left: 0.5rem;    
            font-size: 20px;
        }
        
        h2{
        	font-size: 20px;
        }
		
		[type=submit]{
        border-color: transparent;
        background-color: rgba(34, 35, 37, 0.8);
        margin-left: 6rem;
        margin-right: 6rem;
        height: 2.3rem;
        transition: 1s;
        }

        [type=submit]:hover{
            background-color: rgba(59, 62, 73, 0.8);
            box-shadow: 0.5em;
            transform: scale(1.1);
        }

        [type=submit]:active{
            background-color: rgba(116, 81, 183, 0.8);
        }
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/backandfont.jsp" flush="true"/>
	<jsp:include page="/WEB-INF/pages/menu.jsp" flush="true"/>
	<form action="/zadapp/app/viewpro">
		<label>Maticni broj :</label>
		<input type="text" name="maticni">
		<br>
		<input type="submit" value="Pronadji">
		<h2>${message}</h2>
	</form>
</body>
</html>