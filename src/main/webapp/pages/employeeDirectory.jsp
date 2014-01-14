<%-- 
    Document   : welcom
    Created on : Jan 13, 2014, 7:04:34 PM
    Author     : michael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Employee Directory</h1>
        <table>
            <c:forEach items="${employees}" var="emp">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/pages/employeeInformation.html?id=${emp.id}">${emp.id}</a></td>
                    <td>${emp.title}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.middleName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.suffix}</td>
                    <td>${emp.hiredDate}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
