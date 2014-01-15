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
        <fieldset title="Create/Edit Employee Details">
            <form:form method="GET" action="saveEmployeeDetails" commandName="employee">
                <table>
                    <tr>
                        <td>
                            <label for="searchId">ID: </label>
                        </td>
                        <td colspan="2">
                            <input id="id" name="id" type="text" value="${employee.id}" disabled="true" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="title">Title: </label>
                        </td>
                        <td colspan="2">
                            <input id="title" name="title" type="text" value="${employee.title}" />
                        </td>
                    </tr>
                    <tr>

                        <td>
                            <label for="firstName">First Name: </label></td>
                        <td colspan="2">
                            <input id="firstName" name="firstName" type="text" value="${employee.firstName}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="middleName">Middle Name: </label></td>
                        <td colspan="2">
                            <input id="middleName" name="middleName" type="text" value="${employee.middleName}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="lastName">Last Name: </label></td>
                        <td colspan="2">
                            <input id="lastName" name="lastName" type="text" value="${employee.lastName}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="suffix">Suffix: </label></td>
                        <td colspan="2">
                            <input id="suffix" name="suffix" type="text" value="${employee.suffix}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="address">Address: </label></td>
                        <td>
                            <div id="address" >${employee.stringifiedAddress} </div>                            
                        </td>
                        <td>
                            <a href="#" >edit</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="email">Email: </label></td>
                        <td>
                            <div id="email" >${employee.stringifiedEmails}</div>
                        </td>
                        <td>
                            <a href="#" >edit</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="phone">Phone </label></td>
                        <td>
                            <div id="phone" >${employee.stringifiedPhoneNumbers}</div>
                        </td>
                        <td>
                            <a href="#" >edit</a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="hiredDate">Hired Date: </label></td>
                        <td colspan="2">
                            <input id="hiredDate" name="hiredDate" type="date"  value="${employee.hiredDate}" />
                        </td>
                    </tr>
                    <tr>
                        <td>                        
                            <input id="search" name="search" type="submit" />
                        </td>
                    </tr>
            </form:form>
        </fieldset>
    </body>
</html>
