<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!-- this is kind of import to use the spring MVC tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>
	<form:form action="process-form" modelAttribute="student">
		First Name: <form:input path="firstName"/>
		<br>
		<br>
		Last Name: <form:input path="lastName"/>
		<br>
		<br>
		Country: <form:select path="country">
			<form:options items="${student.countryOptions }"/>			
		</form:select>
		<br>
		<br>
		Favorite Programming Language: 
			<form:radiobutton path="favoriteLanguage" value="CPP" label="CPP"/>
			<form:radiobutton path="favoriteLanguage" value="Java" label="Java"/>
			<form:radiobutton path="favoriteLanguage" value="Python" label="Python"/>
			<form:radiobutton path="favoriteLanguage" value="JavaScript" label="JavaScript"/>
			<form:radiobutton path="favoriteLanguage" value="Scala" label="Scala"/>
		<br>
		<br>
		<input type="submit" value="Submit"/>
		
	</form:form>
</body>
</html>