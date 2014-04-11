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
<script>
  $(function() {
	$.datepicker.setDefaults($.datepicker.regional["it"]);	
    $( "#datepicker" ).datepicker({"dateFormat": "dd/mm/yy"});
  });
  </script>
</head>
<body>
	<div class="navigation"><a href="<c:url value="/customer" />">Back</a></div>
	
	<h1><spring:message code="header.addvehicle"/></h1>
		
	<c:url var="url" value="/vehicle/add" />
	<form:form action="${url}" method="post">
		<table>
		<tr>
			<td><label><spring:message code="label.brand"/>:</label></td>
			<td><form:input path="marca" maxlength="30" size="20" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.model"/>:</label></td>
			<td><form:input path="modello" maxlength="30" size="20" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.carlicense"/>:</label></td>
			<td><form:input path="targa" maxlength="16" size="16" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.vehicletype"/>:</label></td>
			<td><form:input path="tipo" maxlength="100" size="30" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.fuel"/>:</label></td>
			<td><form:input path="alimentazione" maxlength="5" size="5" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.enginesize"/>:</label></td>
			<td><form:input path="cilindrata" maxlength="5" size="5" /></td>
		</tr><tr>
			<td><label><spring:message code="label.enginepower"/>:</label></td>
			<td><form:input path="cavalli" maxlength="5" size="5" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.trailer"/>:</label></td>
			<td><form:input path="rimorchio" maxlength="50" size="20" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.vehiclestate"/>:</label></td>
			<td><form:input path="stato" maxlength="2" size="2" /></td>
		</tr>
		<tr>
			<td><label><spring:message code="label.timechange"/>:</label></td>
			<td><form:input path="tempoCambio" maxlength="15" size="15" /></td>
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
</body>
</html>