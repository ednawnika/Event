<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Welcome Page</title>
        </head>

        <body>
            <h1>Welcome User</h1>


            <table>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action/Status</th>
                </tr>
                <c:forEach var="event" items="${events}">
                <tr>
                    <td><a href="events/profile/${event.id}">
                        <c:out value="${event.name}" />
                    </a></td>
                    <td><c:out value="${event.date}" /></td>
                    <td><c:out value="${event.location}" /></td>
                    <td>
                        <c:out value="${event.host}" />
                    </td>
                  
                 
                    
                    <td><a href="/events/edit/${event.id}">Edit</a>
                        <a href="/events/delete/${event.id}">Delete</a>
                    </td>
                </tr>
    
         </c:forEach>    
        
 </table>

 <br>







 <br>



            <form:form method="POST" action="/event" modelAttribute="event">
                <form:label path="name">Name:
                   
                    <form:input path="name" /></form:label><br>

                <form:label path="date">Date:
                    <form:input type="date" path="date" /></form:label><br>

                <form:label path="location">location:
                    <form:input path="location" /></form:label><br>
                    
                    <form:label path="host">Host:
                        <form:input path="host" /></form:label>
                    <br>

                <input type="submit" value="Submit" />
            </form:form>









            <br>












            <br>

            <form id="logoutForm" method="POST" action="/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="submit" value="Logout!" />
            </form>
        </body>

        </html>