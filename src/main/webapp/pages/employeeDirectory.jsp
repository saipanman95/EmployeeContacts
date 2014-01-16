<%-- 
    Document   : welcom
    Created on : Jan 13, 2014, 7:04:34 PM
    Author     : michael
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="../js/jquery-2.0.3.min.js"></script>
        <script type="text/javascript" src="../js/jquery-ui-1.10.3.custom.min.js"></script>
        <link rel="stylesheet" href="../css/ui-lightness/jquery-ui-1.10.3.custom.min.css">
        <link rel="stylesheet" href="../css/employeeDirectory.css">
        <script>
            $(function() {
                $("#searchFromDt").datepicker({
                    dateFormat: 'yy-mm-dd',
                    changeMonth: true,
                    changeYear: true
                });
                $("#searchToDt").datepicker({
                    dateFormat: 'yy-mm-dd',
                    changeMonth: true,
                    changeYear: true
                });
                $('#reset').click(function() {
                    document.location.href = "employeeDirectoryReset.html";
                });
            });
        </script>
    </head>
    <body>
        
            <h1>Employee Directory</h1>
            
       
        <fieldset title="Employee Search">
            <form:form method="GET" action="employeeDirectory.html" commandName="employee">
                <table class="search-table">
                    <tr>
                        <td>
                            <label for="searchId">ID: </label><br/>
                            <input id="searchId" name="id" type="text"  />
                        </td>
                        <td>
                            <label for="searchLastName">Last Name: </label><br/>
                            <input id="searchLastName" name="lastName" type="text"  />
                        </td>
                        <td>
                            <label for="searchFromDt">From Date: </label><br/>
                            <input id="searchFromDt" name="fromDt" type="text"   />
                        </td>
                        <td>                        
                            <input id="search" class="employee-button" name="search" type="submit" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label for="searchAddress">Street Address: </label><br/>
                            <input id="searchAddress" name="address" type="text"   />
                        </td>
                        <td>
                            <label for="searchFirstName">First Name: </label><br/>
                            <input id="searchFirstName" name="firstName" type="text"   />
                        </td>
                        <td>
                            <label for="searchToDt">To Date: </label><br/>
                            <input id="searchToDt" name="toDt" type="text"   />
                        </td>
                        <td>                        
                            <input id="reset" class="employee-button" name="reset" type="reset" />
                        </td>
                    </tr>
                </table>
            </form:form> 
        </fieldset>
        <fieldset title="Employee Directory" >
            <span style="padding:5px;margin-bottom: 5px;"><a href="employeeInformation.html?id=0">Add Employee</a></span>
            <display:table name="${employees}" class="employee-directory-table"
                           defaultsort="1" requestURI="employeeDirectory.html"
                           pagesize="10" >
                <display:column property="id"  paramId="id" url="/pages/employeeInformation.html"/>
                <display:column sortable="true" property="title"/>
                <display:column sortable="true" property="firstName"/>
                <display:column sortable="true" property="middleName"/>
                <display:column sortable="true" property="lastName"/>
                <display:column property="suffix"/>
                <display:column sortable="true" format="{0,date,dd-MMM-yyyy}" property="hiredDate"/> 
                <display:column sortable="true" title="Address" property="stringifiedAddress" />
                <display:column sortable="true" title="Email" property="stringifiedEmails" />
                <display:column sortable="true" title="Phone" property="stringifiedPhoneNumbers" />
            </display:table>
        </fieldset>
    </body>
</html>
