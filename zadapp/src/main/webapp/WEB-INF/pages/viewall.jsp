<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all</title>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Satisfy&display=swap');
	*{
        font-family: 'Satisfy', cursive;
        color: white;
    }
	body{
            margin: 0;
            background-image: url("https://images4.alphacoders.com/936/thumb-1920-936378.jpg");
    }
	.table-container{
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }

        table{
            background-color: rgba(55, 28, 92, 0.8);
            border-color: transparent;
            height: 20rem;
            width: 50rem;
			margin-left: 30vw;
			/* margin-top: 30vh; */
            display: flex;
            justify-content: start;
            flex-direction: column;
            text-align: center;
			font-size: 30px;
			column-gap: 20px;
        }

        table>* {
            margin: auto;
            padding: auto;
			
        }
		input{
            background: transparent;
            border: none;
            border-bottom: 1px solid rgba(74, 69, 224, 0.8);
            height: 1.7rem;
            padding-left: 0.5rem;    
            font-size: 20px;
        }
		h2{
			margin-left: 42vw;
			font-size: 60px;
		}
		
</style>
</head>
<body>
	<h2>Svi proizvodjaci :</h2>
	<table>
		<thead>
			<tr>
				<th>PIB&ensp;&ensp;</th>
				<th>Naziv&ensp;&ensp;</th>
				<th>Adresa&ensp;&ensp;</th>
				<th>Mesto&ensp;&ensp;</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${lista}">
					<tr>
						<th>${pro.pib}&ensp;&ensp;&ensp;&ensp;&ensp;</th>
						<th>${pro.maticniBroj}&ensp;&ensp;&ensp;</th>
						<th>${pro.adresa}&ensp;&ensp;&ensp;</th>
						<th>${pro.mesto.naziv}&ensp;&ensp;&ensp;</th>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>