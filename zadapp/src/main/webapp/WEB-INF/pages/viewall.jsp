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
	
	.table-container{
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }

        table{
            background-color: rgba(79, 84, 105, 0.8);
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
            border-bottom: 1px solid rgba(162, 174, 224, 0.8);
            height: 1.7rem;
            padding-left: 0.5rem;    
            font-size: 20px;
        }
		h2{
			margin-left: 42vw;
			font-size: 60px;
			color: rgba(79, 84, 105, 0.8)
		}
		
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/backandfont.jsp" flush="true"/>
	<jsp:include page="/WEB-INF/pages/menu.jsp" flush="true"/>
	<h2>Svi proizvodjaci :</h2>
	<table>
		<thead>
			<tr>
				<th>PIB&ensp;&ensp;</th>
				<th>Maticni broj&ensp;&ensp;</th>
				<th>Adresa&ensp;&ensp;&ensp;&nbsp;</th>
				<th>Mesto&ensp;&ensp;&nbsp;</th>
				<th>Izmeni/Obrisi</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="pro" items="${lista}">
					<tr>
						<th>${pro.pib}&ensp;&ensp;&ensp;&ensp;&ensp;</th>
						<th>${pro.maticniBroj}&ensp;&ensp;&ensp;&ensp;</th>
						<th>${pro.adresa}&ensp;&ensp;&ensp;&ensp;</th>
						<th>${pro.mestoDto.naziv}&ensp;&ensp;&ensp;&ensp;</th>
						<th>
							<c:url var="urlView" value="/viewpro">
								<c:param name="pib" value="${pro.pib}" ></c:param>
								<c:param name="maticniBroj" value="${pro.maticniBroj}" ></c:param>
								<c:param name="adresa" value="${pro.adresa}" ></c:param>
							</c:url>
							<a href="${urlView}">Pogledaj</a>
						</th>
					</tr>
				</c:forEach>
			</tbody>
	</table>
</body>
</html>