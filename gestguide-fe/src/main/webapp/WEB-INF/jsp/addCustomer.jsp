<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="sitename"/></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/redmond/jquery-ui-1.10.4.custom.min.css"/>" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/init.js"/>"></script>

<script>
  $(function() {
	$.datepicker.setDefaults($.datepicker.regional["it"]);	
    $( "#datepicker" ).datepicker({"dateFormat": "dd/mm/yy"});
  });
  </script>
</head>
<body>
<div id="wrapper">
		<div id="navMenu"></div>
	<div class="navigation"><a href="<c:url value="/customer" />">Back</a></div>
	
	<h1><spring:message code="header.addcustomer"/></h1>
		
	<c:url var="url" value="/customer/add" />
	<form:form action="${url}" method="post">
		<table>
		<tr>
			<td><label><spring:message code="label.firstname"/>:</label></td>
			<td><form:input path="firstName" maxlength="30" size="20" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.lastname"/>:</label></td>
			<td><form:input path="lastName" maxlength="30" size="20" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.ssn"/>:</label></td>
			<td><form:input path="socialSecurityNumber" maxlength="16" size="16" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.address"/>:</label></td>
			<td><form:input path="address" maxlength="100" size="30" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.zip"/>:</label></td>
			<td><form:input path="zipCode" maxlength="5" size="5" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.city"/>:</label></td>
			<td><form:input path="city" maxlength="50" size="20" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.province"/>:</label></td>
			<td><form:input path="province" maxlength="2" size="2" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.phone"/>:</label></td>
			<td><form:input path="phone" maxlength="15" size="15" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.mobilephone"/>:</label></td>
			<td><form:input path="mobilePhone" maxlength="15" size="15" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.email"/>:</label></td>
			<td><form:input path="email" maxlength="50" size="30" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.datebirth"/>:</label></td>
			<td><form:input path="dateOfBirth" maxlength="10" size="10" id="datepicker"/></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.school"/>:</label></td>
			<td><form:select path="schoolId" > 
				<form:option value="-1" label="--- Select ---"/>
  			 	<form:options items="${schools}" />
			</form:select></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" /></td>
		</tr>
		</table>
	</form:form>	
	</div>
</body>
</html>