<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />

<title><spring:message code="sitename"/></title>
</head>
<body>
	<div class="navigation"><a href="<c:url value="/instructor" />">Back</a></div>

	<table>
		<tr>
			<td><label><spring:message code="label.firstname"/>:</label></td>
			<td><c:out value="${result.firstName}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.lastname"/>:</label></td>
			<td><c:out value="${result.lastName}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.ssn"/>:</label></td>
			<td><c:out value="${result.socialSecurityNumber}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.address"/>:</label></td>
			<td><c:out value="${result.address}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.zip"/>:</label></td>
			<td><c:out value="${result.zipCode}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.city"/>:</label></td>
			<td><c:out value="${result.city}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.province"/>:</label></td>
			<td><c:out value="${result.province}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.phone"/>:</label></td>
			<td><c:out value="${result.phone}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.mobilephone"/>:</label></td>
			<td><c:out value="${result.mobilePhone}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.email"/>:</label></td>
			<td><c:out value="${result.email}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.datebirth"/>:</label></td>
			<td><c:out value="${result.dateOfBirth}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.hiringdate"/>:</label></td>
			<td><c:out value="${result.hiringDate}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.school"/>:</label></td>
			<td><c:out value="${result.schoolName}" /></td>
		</tr>
	</table>
</body>
</html>