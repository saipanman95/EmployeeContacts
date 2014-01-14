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
        <h1>Employee Details</h1>
        <div>${employee.title}</div>
        <div>${employee.firstName}</div>
        <div>${employee.middleName}</div>
        <div>${employee.lastName}</div>
        <div>${employee.suffix}</div>
        <div>${employee.hiredDate}</div>
    </body>
</html>
