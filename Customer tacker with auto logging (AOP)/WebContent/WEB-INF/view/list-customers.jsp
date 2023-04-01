<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<!-- put new button to add new customer -->
			<input type="button" value="Add Customer" onclick="window.location.href='show-form-for-add'; return false"
				class="add-button"
			/>
		
			<!-- add html table -->
			<table>
				<tr>
					<th>First Name </th>
					<th>Last Name </th>
					<th>Email </th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print the customers -->
				<c:forEach var="customer" items="${customers }">
					
					<c:url var="updateLink" value="/customer/update-customer-form">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
									
					<tr>
						<td>${customer.firstName }</td>
						<td>${customer.lastName }</td>
						<td>${customer.email }</td>		
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete customer?'))) return false;"
							>
							Delete</a>
						</td>				
					</tr>
				</c:forEach>
				
			</table>
		
		</div>
	</div>
	

</body>
</html>