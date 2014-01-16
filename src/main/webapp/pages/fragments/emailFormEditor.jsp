<%-- 
    Document   : emailFormEditor
    Created on : Jan 15, 2014, 11:07:35 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <a href="employeeInformation.html?id=${employee.id}&type=email" >Click to add new Email</a>
        </td>
    </tr>
</table>  
