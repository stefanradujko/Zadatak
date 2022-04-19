<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log in</title>
    
    <style>
        
        :root
        {
        --menu-color: rgba(79, 84, 105, 0.8);
        --line-color: rgba(162, 174, 224, 0.8);
        --shadow-color:rgba(74, 69, 224, 0.8);
        --button-color:rgba(34, 35, 37, 0.8);
        --hoover-color:rgba(59, 62, 73, 0.8);
        }

        .form-container{
            height: 100vh;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
            align-items: center;
            flex-wrap: wrap;
        }

        form{
            background-color: var(--menu-color);
            border-color: transparent;
            height: 25rem;
            width: 20rem;
            display: flex;
            justify-content: start;
            flex-direction: column;
            text-align: center;
        }

        form>* {
            margin: auto;
            padding: auto;
        }

        h1{
            border-bottom: 1px solid var(--line-color);
            color: white;
            width: 70%;
            padding-bottom: 0.5rem;
            text-shadow: 2px 2px var(--shadow-color);
            font-size: 50px;
        }

        input{
            background: transparent;
            border: none;
            border-bottom: 1px solid rgba(162, 174, 224, 0.8);
            height: 1.7rem;
            padding-left: 0.5rem;    
            font-size: 22px;
        }

        ::placeholder {
            color: white;
            opacity: 7; 
        }
        
        [type=submit]{
        border-color: transparent;
        background-color: var(--button-color);
        margin-left: 6rem;
        margin-right: 6rem;
        height: 2.3rem;
        transition: 1s;
        }

        [type=submit]:hover{
            background-color: var(--hoover-color);
            box-shadow: 0.5em;
            transform: scale(1.1);
        }

        [type=submit]:active{
            background-color: var(--hoover-color);
        }
    </style>
</head>
<body>
	<jsp:include page="/WEB-INF/pages/backandfont.jsp" flush="true"/>
    <div class="form-container">
        <form action="/zadapp/app/login" method="post"> 
            <h1>Login</h1>
            <input type="text" name="username" placeholder="Username...">
            <input type="password" name="password" placeholder="Password... ">
            <input type="submit" value="Log In">
            <h2>${message}</h2>
        </form>
    </div>
</body>
</html>