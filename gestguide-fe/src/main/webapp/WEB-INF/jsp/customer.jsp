<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/init.js"/>"></script>

<title><spring:message code="sitename"/></title>

<script type="text/javascript">
	//delete license
	function deleteLicense(registrationId){
	    $.post("../registration/delete", { licenseId: licenseId, instructorId: instructorId },
	       function(data) {
	    	if(data == 'SUCCESS') {
	    		$("#licenseRow" + licenseId).remove();
	    	} else {
	    		alert(data);
	    	}
	       });
	}
	
	$( document ).ready(function() {
		
	});
</script>

</head>
<body>
<div id="wrapper">
		<div id="navMenu"></div>
	<div class="navigation"><a href="<c:url value="/customer" />">Back</a></div>

	<div id="left_panel">
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
				<td><label><spring:message code="label.school"/>:</label></td>
				<td><c:out value="${result.schoolName}" /></td>
			</tr>
		</table>
	</div>
	<div id="right_panel">
			<h3>
				<spring:message code="header.registration" />
			</h3>
			<table id="activeRegistration">
				<thead>
					<th><spring:message code="label.license.category" /></th>
					<th><spring:message code="label.registrationDate" /></th>
					<th><spring:message code="label.school" /></th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach items="${result.registrations}" var="registration">
						<tr>
							<td><c:out value="${registration.licenseCategory}" /></td>
							<td><c:out value="${registration.registrationDate}" /></td>
							<td><c:out value="${registration.schoolName}" /></td>
							<td><a class='deleteLink' href="#" onclick="deleteLicense(<c:out value="${license.id}" />, <c:out value="${result.id}" />);return false;">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<div id="availableLicenses">
				<select id="availableLicensesList">
					<option value=-1>Add license</option>
				</select>
			</div>
		</div>
		<div class="clear"></div>
</div>
</body>
</html>