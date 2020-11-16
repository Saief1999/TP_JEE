<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Add User</title>
	</head>
	<body>
	<h1>Ajouter un Utilisateur</h1>
	<form action="user_add" method="post">	

		<div>
			<label for="login">Login :</label>
				<input name="login" id="login" type="text" placeholder ="login"> 
		</div>
		<div>
			<label for="pass">Pass :</label>
				<input type="password" name="pass" id="pass" placeholder ="pass"> 
		</div>
				<div>
			<label for="email">Email :</label>
				<input type="text" name="email" id="email"  placeholder ="email"> 
		</div>
		<div>
			<label for="ville">Ville :</label>
				<input type="text" name="ville" id="ville"  placeholder ="ville"> 
		</div>
		<input type="submit" value="Envoyer">
	</form>
		<a href="UserInfo">Go To Main Page</a>
	</body>
</html>