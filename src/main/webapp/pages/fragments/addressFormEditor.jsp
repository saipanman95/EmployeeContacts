<%-- 
    Document   : addressFormEditor
    Created on : Jan 15, 2014, 11:05:53 PM
    Author     : michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
            <a href="employeeInformation.html?id=${employee.id}&type=address" >Click to add new Address</a>
        </td>
    </tr>
</table>
