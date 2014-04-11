<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />

<title><spring:message code="sitename"/></title>
</head>
<body>
	<div class="navigation"><a href="<c:url value="/school" />">Back</a></div>
	
	<spring:message code="header.addschool"/>

	<c:url var="url" value="/school/add" />
	<form:form action="${url}" method="post">
		<table>
		<tr>
			<td><label><spring:message code="label.sitename"/>:</label></td>
			<td><form:input path="nomeSede" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.address"/>:</label></td>
			<td><form:input path="indirizzo" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.city"/>:</label></td>
			<td><form:input path="citta" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.province"/>:</label></td>
			<td><form:input path="provincia" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.zip"/>:</label></td>
			<td><form:input path="cap" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.phone"/>:</label></td>
			<td><form:input path="telefono" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.fax"/>:</label></td>
			<td><form:input path="fax" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.email"/>:</label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" /></td>
		</tr>
		</table>
	</form:form>	
</body>
</html>