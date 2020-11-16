<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<FORM METHOD="POST" action="login">
		<span style="color:red"><% if (request.getAttribute("AuthError")!=null) out.println(request.getAttribute("AuthError")); %></span>
		<P>
			login: <INPUT NAME="login" TYPE="TEXT" SIZE=" 12" MAXLENGTH=" 20">
		<P>
			password: <INPUT NAME="password" TYPE="TEXT" SIZE=" 12"
				MAXLENGTH=" 20">
		<P>
			Thank you! <INPUT TYPE="SUBMIT" value="submit">
	</FORM>

</body>
</html>