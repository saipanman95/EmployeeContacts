<%-- 
    Document   : welcom
    Created on : Jan 13, 2014, 7:04:34 PM
    Author     : michael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Details</title>
        <script type="text/javascript" src="../js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="../js/jquery-ui-1.10.3.custom.min.js"></script>
        <link rel="stylesheet" href="../css/ui-lightness/jquery-ui-1.10.3.custom.min.css">
        <link rel="stylesheet" href="../css/employeeInformation.css">
        <script>
            $(function() {
                $("#hiredDate").datepicker({
                    dateFormat: 'yy-mm-dd',
                    changeMonth: true,
                    changeYear: true
                });
            });
        </script>
    </head>
    <body>

        <h1>Employee Details</h1>
        <fieldset >
            <a href="employeeDirectory.html">Return to Employee Search</a>
        </fieldset>
        <fieldset title="Create/Edit Employee Details">

            <div id="messages">
                ${param.message}
            </div>

            <form:form method="post" action="saveEmployeeDetails.html" commandName="employee" >
                <table >
                    <tr>
                        <td>
                            <label for="searchId">ID: </label>
                        </td>
                        <td colspan="2">

                                <form:hidden path="id" id="id" /> 
                                ${employee.id}
                            
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="title">Title: </label>
                        </td>
                        <td colspan="2">
                            <form:input path="title" id="title" />
                        </td>
                    </tr>
                    <tr>

                        <td>
                            <label for="firstName">First Name: </label></td>
                        <td colspan="2">
                            <form:input path="firstName" id="firstName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="middleName">Middle Name: </label></td>
                        <td colspan="2">
                            <form:input id="middleName" path="middleName"  />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="lastName">Last Name: </label></td>
                        <td colspan="2">
                            <form:input id="lastName" path="lastName" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="suffix">Suffix: </label></td>
                        <td colspan="2">
                            <form:input  id="suffix" path="suffix" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="hiredDate">Hired Date: </label></td>
                        <td colspan="2">
                            <form:input id="hiredDate" path="hiredDate" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="address">Address: </label></td>
                        <td>
                            <table class="contact-table">
                                <tr >
                                    <td class="contact-type-select">Type</td>
                                    <td>Street</td>
                                    <td>Street 2</td>
                                    <td>City</td>
                                    <td>State</td>
                                    <td>Zip</td>
                                    <td>Country</td>
                                </tr>
                                <c:forEach items="${employee.addresses}" varStatus="addressRow">                                    
                                    <tr>
                                        <td>
                                            <form:hidden path="addresses[${addressRow.index}].id"/>
                                            <form:hidden path="addresses[${addressRow.index}].employee.id"/>
                                            <form:select path="addresses[${addressRow.index}].addressType.lookupId">
                                                <form:option value="1">WORK</form:option>
                                                <form:option value="2">HOME</form:option>
                                                <form:option value="3">SCHOOL</form:option>
                                                <form:option value="4">MOBILE</form:option>
                                            </form:select>
                                        </td>
                                        <td>
                                            <form:input path="addresses[${addressRow.index}].street1" />
                                        </td>
                                        <td>
                                            <form:input path="addresses[${addressRow.index}].street2" />
                                        </td>
                                        <td>
                                            <form:input path="addresses[${addressRow.index}].city" />
                                        </td>
                                        <td>
                                            <form:input path="addresses[${addressRow.index}].stateProv" cssClass="state-input"/>
                                        </td>
                                        <td>
                                            <form:input path="addresses[${addressRow.index}].zipcode" cssClass="zip-input"/>
                                        </td>
                                        <td>
                                            <form:input path="addresses[${addressRow.index}].country" cssClass="country-input"/>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty employee.addresses}">
                                    <tr>
                                        <td colspan="7">
                                            No Records founds.
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td colspan="7">
                                        <c:if test="${employee.id ne null}">
                                            <a href="employeeInformation.html?id=${employee.id}&type=address" >Click to add new Address</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </table>                            

                        </td>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="email">Email: </label>
                        </td>
                        <td>
                            <table class="contact-table">
                                <tr >
                                    <td class="contact-type-select">Type</td>
                                    <td>Email Address</td>
                                </tr>
                                <c:forEach items="${employee.emails}" varStatus="emailRow">                                    
                                    <tr>
                                        <td>
                                            <form:select path="emails[${emailRow.index}].emailType.lookupId">
                                                <form:option value="1">WORK</form:option>
                                                <form:option value="2">HOME</form:option>
                                                <form:option value="3">SCHOOL</form:option>
                                                <form:option value="4">MOBILE</form:option>
                                            </form:select>
                                        </td>
                                        <td>
                                            <form:input path="emails[${emailRow.index}].emailAddress" cssClass="email-address-input" />
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty employee.emails}">
                                    <tr>
                                        <td colspan="2">
                                            No Records founds.
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td colspan="2">
                                        <c:if test="${employee.id ne null}">
                                            <a href="employeeInformation.html?id=${employee.id}&type=email" >Click to add new Email</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </table>     
                        </td>
                        <td>

                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="phone">Phone </label>
                        </td>
                        <td>
                            <table class="contact-table" >
                                <tr >
                                    <td class="contact-type-select">Type</td>
                                    <td>Phone Number</td>
                                </tr>
                                <c:forEach items="${employee.phoneNumbers}" varStatus="phoneRow">                                    
                                    <tr>
                                        <td>
                                            <form:select path="phoneNumbers[${phoneRow.index}].phoneType.lookupId">
                                                <form:option value="1">WORK</form:option>
                                                <form:option value="2">HOME</form:option>
                                                <form:option value="3">SCHOOL</form:option>
                                                <form:option value="4">MOBILE</form:option>
                                            </form:select>
                                        </td>
                                        <td>
                                            <form:input path="phoneNumbers[${phoneRow.index}].phoneNumer" />
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty employee.phoneNumbers}">
                                    <tr>
                                        <td colspan="2">
                                            No Records founds.
                                        </td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td colspan="2">
                                        <c:if test="${employee.id ne null}">
                                            <a href="employeeInformation.html?id=${employee.id}&type=phone" >Click to add new Phone</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </table>     
                        </td>
                        <td>

                        </td>
                    </tr>

                    <tr>
                        <td>                        
                            <input id="search" type="submit" value="Create/Update" />
                        </td>
                        <td>                        
                            <input id="reset" type="reset" value="reset" />
                        </td>
                    </tr>
                </form:form>
        </fieldset>
    </body>
</html>
