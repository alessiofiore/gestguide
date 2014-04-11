<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />

<title>Insert title here</title>
</head>
<body>
	<div class="navigation"><a href="<c:url value="/school" />">Back</a></div>

	<table>
		<tr>
			<td><label><spring:message code="label.sitename"/>:</label></td>
			<td><c:out value="${result.nomeSede}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.zip"/>:</label></td>
			<td><c:out value="${result.cap}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.city"/>:</label></td>
			<td><c:out value="${result.citta}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.province"/>:</label></td>
			<td><c:out value="${result.provincia}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.address"/>:</label></td>
			<td><c:out value="${result.indirizzo}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.phone"/>:</label></td>
			<td><c:out value="${result.telefono}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.fax"/>:</label></td>
			<td><c:out value="${result.fax}" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.email"/>:</label></td>
			<td><c:out value="${result.email}" /></td>
		</tr>
	</table>
</body>
</html>