<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Index</title>
		<!-- <link rel="stylesheet" type="text/css" href="/css/style.css"> -->
	</head>





		<h3>Event Name:<c:out value="${event.name}" />
		</h3>



	<body>
		<form:form method="POST" action="/events/edit/${id}" modelAttribute="even">
			<form:label path="name">Name:
		
				<form:input path="name" /></form:label>
			<br>
		
			<form:label path="date">Date:
				<form:input type="date" path="date" /></form:label>
			<br>
		
			<form:label path="location">location:
				<form:input path="location" /></form:label>
			<br>
		
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>