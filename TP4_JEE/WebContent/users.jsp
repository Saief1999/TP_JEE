<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>
</head>
<body>
	<table border="1" width="80%">
		<tr>
			<th>ID</th>
			<th>Login</th>
			<th>Pass</th>
			<th>Email</th>
			<th>Ville</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${users}" var="p">
			<tr>
				<td>${p.idUser}</td>
				<td>${p.login}</td>
				<td>${p.pass}</td>
				<td>${p.email}</td>
				<td>${p.ville}</td>
				<td>
					<a href="user_update?id=${p.idUser}">Update</a>
					<a href="user_delete?id=${p.idUser}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form method="GET" action="user_add">
		<button type="submit">Add User</button>
	</form>
	<a href="UserInfo">Go To Main Page</a>
	
</body>
</html>