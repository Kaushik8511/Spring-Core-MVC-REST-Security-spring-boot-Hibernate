<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<h1>Welcome to java configuration</h1>

	<hr>
	<!-- display user and role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role:
		<security:authentication property="principal.authorities" />
	</p>
	<security:authorize access="hasRole('MANAGER')">
		<hr>
		<!-- add a link to point to /leaders => for managers only-->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Meeting</a>(Only for managers)
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<hr>
		<!-- add a link to point to /systems => for ADMIN only-->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT systems
				Meeting</a>(Only for admins)
		</p>
	</security:authorize>


	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

</body>
</html>