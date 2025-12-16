<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher List</title>
</head>
<body>
	<h2>Teachers List</h2>
	<br>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Subject</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		
		<c:forEach var="te" items="${list}">
			<tr>
			    <td>${te.id}</td>
			    <td>${te.name}</td>
			    <td>${te.subject}</td>
			    <td><a href="editteacher/${te.id}">Edit</a></td>
			    <td><a href="deleteteacher/${te.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="teacher">Add New Teacher</a>
	<br>
	<a href="<c:url value='/'/>">Home</a> 
	<!-- gets project context path.i.e /spring-mvc-self/ -->
</body>
</html>