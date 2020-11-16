<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Modifer Utilisateur</title>
	</head>
	<body>
	<h1>Modifier l'Utilisateur</h1>
	<form action="user_update" method="post">	

		<div>
			<label for="login">Login :</label>
				<input name="login" id="login" type="text" placeholder ="login" value="${muser.getLogin()}"> 
		</div>
				<div>
			<label for="email">Email :</label>
				<input type="text" name="email" id="email"  placeholder ="email" value="${muser.getEmail()}"> 
		</div>
		<div>
			<label for="ville">Ville :</label>
				<input type="text" name="ville" id="ville"  placeholder ="ville" value="${muser.getVille()}"> 
		</div>
		
		<input type="text" name="id" hidden="hidden" value="${muser.getIdUser()}">
		<input type="submit" value="Modifier">
	</form>
		<a href="UserInfo">Go To Main Page</a>
	</body>
</html>