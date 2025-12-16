<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Teacher</title>
</head>
<body>
	<h2>Add Teacher</h2>
	<br>
	<form:form method="post" action="save" modelAttribute="teacher">
		<form:input path="name" placeholder="Enter Name"/>
		<br>
		<form:input path="subject" placeholder="Enter Subject"/>
		<br>
		<input type="submit" value="Save" />
	</form:form>
</body>
</html>