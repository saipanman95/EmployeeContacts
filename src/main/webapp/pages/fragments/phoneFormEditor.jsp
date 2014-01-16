<%-- 
    Document   : phoneFormEditor
    Created on : Jan 15, 2014, 11:08:52 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <a href="employeeInformation.html?id=${employee.id}&type=phone" >Click to add new Phone</a>
        </td>
    </tr>
</table>  