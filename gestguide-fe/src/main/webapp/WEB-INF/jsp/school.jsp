<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="navigation"><a href="<c:url value="/school" />">Back</a></div>

	<table>
		<tr>
			<td>nomeSede</td>
			<td><c:out value="${result.nomeSede}" /></td>
		</tr>
		<tr>
			<td>cap</td>
			<td><c:out value="${result.cap}" /></td>
		</tr>
		<tr>
			<td>citta</td>
			<td><c:out value="${result.citta}" /></td>
		</tr>
		<tr>
			<td>provincia</td>
			<td><c:out value="${result.provincia}" /></td>
		</tr>
		<tr>
			<td>indirizzo</td>
			<td><c:out value="${result.indirizzo}" /></td>
		</tr>
		<tr>
			<td>telefono</td>
			<td><c:out value="${result.telefono}" /></td>
		</tr>
		<tr>
			<td>fax</td>
			<td><c:out value="${result.fax}" /></td>
		</tr>
		<tr>
			<td>email</td>
			<td><c:out value="${result.email}" /></td>
		</tr>
	</table>
</body>
</html>