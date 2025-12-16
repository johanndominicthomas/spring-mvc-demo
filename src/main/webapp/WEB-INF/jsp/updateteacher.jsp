<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<html>
<head>
<meta charset="UTF-8">
<title>Edit Teacher</title>
</head>
<body>
	<h2>Edit Teacher</h2>
	<br>
	<form:form method="post" action="${pageContext.request.contextPath}/updateteacher" modelAttribute="teacher">
		<form:input path="name" placeholder="Enter Name"/>
		<br>
		<br>
		<form:input path="subject" placeholder="Enter Subject"/>
		<br>
		<form:hidden path="id" />
		<input type="submit" value="Update" />
	</form:form>
</body>
</html>