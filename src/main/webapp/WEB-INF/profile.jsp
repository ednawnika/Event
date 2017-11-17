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

	<body>
		<div>
			<h3>Event Name:  <c:out value="${event.name}"/></h3>

			<h4>Date:  <c:out value="${event.date}"/></h4>
			
			<h5>Location:  <c:out value="${event.location}" /></h5>
 <c:forEach var="usar" items="${event.users}">
			<h5>Host:  <c:out value="${usar.username}" /></h5>
</c:forEach>

			
			
			
<h5>People who are attending this event</h5>

<table>
	<tr>
	<th>Name</th>
	<th>Location</th>
   </tr>

   <tr>
		<td><c:out value="${usar.username}"/></td>

<c:forEach var="usa" items="${users}">
		<td>
			
		</td>
</c:forEach>

   </tr>




</table>



	
	</body>
</html>