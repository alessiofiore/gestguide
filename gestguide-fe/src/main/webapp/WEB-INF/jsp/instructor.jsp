<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="sitename" /></title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/init.js"/>"></script>

<script type="text/javascript">

	// undo add license
	function cancel(licenseId, category) {
		$("#licenseRow" + licenseId).remove();
		$("#availableLicensesList").append("<option value='" + licenseId + "'>" + category + "</option>");
	}
	
	// edit license
	function editLicense(licenseId) {
				
	}
	
	// save license
	function saveLicense(licenseId) {
		cost = $("#licenseRow" + licenseId + " input.costPerHour").val();
		instructorId = ${result.id};
		
		$.post("../instructor/addLicense", { licenseId: licenseId, instructorId: instructorId,  costPerHour: cost},
       		function(data) {
    		if(data == 'SUCCESS') {
    			$("#licenseRow" + licenseId + " .costPerHour").replaceWith(cost);
    			
    			editLink = "<a class='editLink' href='#' onclick='editLicense(<c:out value='" + licenseId + "' />);return false;'>Edit</a>";
    			$("#licenseRow" + licenseId + " .saveLink").replaceWith(editLink);
    			
    			deleteLink = "<a class='deleteLink' href='#' onclick='deleteLicense(<c:out value='" + licenseId + "' />, <c:out value='" + instructorId + "' />);return false;'>Delete</a>";
    			$("#licenseRow" + licenseId + " .cancelLink").replaceWith(deleteLink);
    		} else {
    			alert(data);
    		}
		});
	}
	
	// delete license
	function deleteLicense(licenseId, instructorId){
	    $.post("../instructor/deleteLicense", { licenseId: licenseId, instructorId: instructorId },
	       function(data) {
	    	if(data == 'SUCCESS') {
	    		$("#licenseRow" + licenseId).remove();
	    	} else {
	    		alert(data);
	    	}
	       });
	}

$( document ).ready(function() {
	
	// get list of licenses
	$.getJSON( "..license/json/licenses", function( data ) {
		  var items = [];
		  items.push( "<option value=-1>Add license</option>");
		  $.each( data, function( key, val ) {
			 $("#availableLicensesList").append("<option value='" + val.id + "'>" + val.category + "</option>");
		  });
		});
	
	// licenses SELECT onClick action
	$('#availableLicensesList').on('change', function() {
		if(this.value > -1) {
			text = $('#availableLicensesList option:selected').text();
			cat = "<td>"+ text +"</td>";
			costH = "<td><input type='text' maxlength='4' size='4' class='costPerHour' value=0></td>";
			
			linkSave = "<a class='saveLink' href='#' onclick='saveLicense(" + this.value + ");return false;'>Save</a>";
			linkCancel = "<a class='cancelLink' href='#' onclick='cancel(" + this.value + ",\"" + text + "\");return false;'>Cancel</a>";
			links = "<td>" + linkSave + " | " + linkCancel + "</td>";
			row = "<tr id='licenseRow" + this.value + "'> " + cat + costH + links + "</tr>";
			$('#ownedLicenses tbody').append(row);
			// remove item from list
			$("#availableLicensesList option[value='"+this.value+"']").remove();
		}
	});
});

	
</script>
</head>
<body>
	<div id="wrapper">
		<div id="navMenu"></div>
		<div class="navigation">
			<a href="<c:url value="/instructor" />">Back</a>
		</div>

		<div id="left_panel">
			<table>
				<tr>
					<td><label><spring:message code="label.firstname" />:</label></td>
					<td><c:out value="${result.firstName}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.lastname" />:</label></td>
					<td><c:out value="${result.lastName}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.ssn" />:</label></td>
					<td><c:out value="${result.socialSecurityNumber}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.address" />:</label></td>
					<td><c:out value="${result.address}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.zip" />:</label></td>
					<td><c:out value="${result.zipCode}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.city" />:</label></td>
					<td><c:out value="${result.city}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.province" />:</label></td>
					<td><c:out value="${result.province}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.phone" />:</label></td>
					<td><c:out value="${result.phone}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.mobilephone" />:</label></td>
					<td><c:out value="${result.mobilePhone}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.email" />:</label></td>
					<td><c:out value="${result.email}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.datebirth" />:</label></td>
					<td><c:out value="${result.dateOfBirth}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.hiringdate" />:</label></td>
					<td><c:out value="${result.hiringDate}" /></td>
				</tr>
				<tr>
					<td><label><spring:message code="label.school" />:</label></td>
					<td><c:out value="${result.schoolName}" /></td>
				</tr>
			</table>
		</div>
		<div id="right_panel">
			<h3>
				<spring:message code="header.licenses" />
			</h3>
			<table id="ownedLicenses">
				<thead>
					<th><spring:message code="label.license.category" /></th>
					<th><spring:message code="label.license.costPerHour" /></th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach items="${result.licenses}" var="license">
						<tr>
							<td><c:out value="${license.category}" /></td>
							<td><c:out value="${license.costPerHour}" /></td>
							<td><a class='editLink' href="#" onclick="editLicense(<c:out value="${license.id}" />);return false;">Edit</a>
								| <a class='deleteLink' href="#" onclick="deleteLicense(<c:out value="${license.id}" />, <c:out value="${result.id}" />);return false;">Delete</a></td>
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