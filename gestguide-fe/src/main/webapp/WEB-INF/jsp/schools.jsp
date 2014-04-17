<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="sitename"/></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/init.js"/>"></script>

</head>
<body>
<div id="wrapper">
	<div id="navMenu"></div>
	<div class="navigation"><a href="<c:url value="/school/add" />">Add new</a></div>

	<table id="schoolsTable">
		<thead>
			<th><spring:message code="label.sitename"/></th>
			<th><spring:message code="label.city"/></th>
			<th>-</th>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="result">
				<tr>
					<td>${result.nomeSede}</td>
					<td>${result.citta}</td>
					<td><a href="<c:url value="/school/${result.id}" />">View</a> | 
					<a href="<c:url value="/school/delete/${result.id}" />">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>