<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="sitename"/></title>

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>


</head>
<body>
<div class="navigation"><a href="<c:url value="/vehicle/add" />">Add new</a></div>

	<table id="listTable">	
		<thead>
			<th><spring:message code="label.brand"/></th>
			<th><spring:message code="label.model"/></th>
			<th><spring:message code="label.carlicense"/></th>
			<th><spring:message code="label.vehicletype"/></th>
			<th><spring:message code="label.fuel"/></th>
			<th><spring:message code="label.trailer"/></th>
			<th><spring:message code="label.vehiclestate"/></th>
			<th><spring:message code="label.timechange"/></th>
			<th><spring:message code="label.school"/></th>
			<th>-</th>
		</thead>
		<tbody>
			<c:forEach items="${results}" var="result">
				<tr>
					<td>${result.marca}</td>
					<td>${result.modello}</td>
					<td>${result.targa}</td>
					<td>${result.tipo}</td>
					<td>${result.alimentazione}</td>
					<td>${result.rimorchio}</td>
					<td>${result.stato}</td>
					<td>${result.tempoCambio}</td>
					<td>${result.schoolName}</td>
					<td><a href="<c:url value="/vehicle/${result.id}" />">View</a> | 
					<a href="<c:url value="/vehicle/delete/${result.id}" />">Remove</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>