<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.app.metier.Utilisateur"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenu</title>
</head>
<body>

<h1 style="marign:auto">Bienvenu a la page d'accueil de l'utilisateur !</h1>
<%  
Utilisateur user =(Utilisateur)request.getSession(false).getAttribute("user"); %>
<h2>Id: <%= user.getIdUser() %></h2>
<h2>Login: <%= user.getLogin() %></h2>
<h2>Pass: <%=user.getPass()  %></h2>
<h2>Email: <%=user.getEmail() %></h2>
<h2>Ville: <%=user.getVille()%></h2>

<a href="users">Go To the list of users</a>

<a href="logout">Logout</a>
</body>
</html>