<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0" />
	<title><spring:message code="sitename" /></title>

	<!--=== CSS ===-->

	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

	<!-- jQuery UI -->
	<!--<link href="plugins/jquery-ui/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />-->
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="plugins/jquery-ui/jquery.ui.1.10.2.ie.css"/>
	<![endif]-->

	<!-- Theme -->
	<link href="${pageContext.request.contextPath}/resources/assets/css/main.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/assets/css/plugins.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/assets/css/responsive.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/resources/assets/css/icons.css" rel="stylesheet" type="text/css" />

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome/font-awesome.min.css">
	<!--[if IE 7]>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome/font-awesome-ie7.min.css">
	<![endif]-->

	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>

	<!--=== JavaScript ===-->

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/lodash.compat.min.js"></script>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath}/resources/assets/js/libs/html5shiv.js"></script>
	<![endif]-->

	<!-- Smartphone Touch Events -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/event.swipe/jquery.event.move.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/event.swipe/jquery.event.swipe.js"></script>

	<!-- General -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/breakpoints.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/respond/respond.min.js"></script> <!-- Polyfill for min/max-width CSS3 Media Queries (only for IE8) -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/cookie/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/slimscroll/jquery.slimscroll.horizontal.min.js"></script>
	
	<!-- App -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/plugins.form-components.js"></script>
	
	<script>
		$(document).ready(function(){
			"use strict";
	
			App.init(); // Init layout and core plugins
			Plugins.init(); // Init all plugins
			FormComponents.init(); // Init all form-specific plugins
			
			$("#top-nav-menu").load("${pageContext.request.contextPath}/nav-topbar");
			$("#nav").load("${pageContext.request.contextPath}/nav-sidebar");
			
			// licenses SELECT onClick action
			$('#availableLicensesList').on('change', function() {
				if(this.value > -1) {
					var text = $('#availableLicensesList option:selected').text();
					var cat = "<td>"+ text +"</td>";
					var registrationDate = "<td>" + new Date() + "</td>";
					var schoolName = "<td></td>";
					
					var linkSave = "<a class='saveLink' href='#' onclick='saveLicense(" + this.value + ");return false;'>Save</a>";
					var linkCancel = "<a class='cancelLink' href='#' onclick='cancel(" + this.value + ",\"" + text + "\");return false;'>Cancel</a>";
					var links = "<td>" + linkSave + " | " + linkCancel + "</td>";
					var row = "<tr id='licenseRow" + this.value + "'> " + cat + registrationDate + schoolName + links + "</tr>";
					
					$('#activeRegistration tbody').append(row);
					// remove item from list
					$("#availableLicensesList option[value='"+this.value+"']").remove();
				}
			});
		});
		
		//delete license
		function deleteLicense(registrationId){
		    $.post("${pageContext.request.contextPath}/registration/delete", { licenseId: licenseId, instructorId: instructorId },
		       function(data) {
		    	if(data == 'SUCCESS') {
		    		$("#licenseRow" + licenseId).remove();
		    	} else {
		    		alert(data);
		    	}
		       });
		}
		
		function addTableRow() {
			/* 
			
			<td><c:out value="${registration.licenseCategory}" /></td>
			<td><c:out value="${registration.registrationDate}" /></td>
			<td><c:out value="${registration.schoolName}" /></td>
			<td><a class='deleteLink' href="#" onclick="deleteLicense(<c:out value="${license.id}" />, <c:out value="${result.id}" />);return false;"><spring:message code="action.delete" /></a></td>
			
			$("#activeRegistration tbody").append(); */
			
		}
	</script>
	
</head>

<body>

	<!-- Header -->
	<header class="header navbar navbar-fixed-top" role="banner">
		<!-- Top Navigation Bar -->
		<div class="container">

			<!-- Only visible on smartphones, menu toggle -->
			<ul class="nav navbar-nav">
				<li class="nav-toggle"><a href="javascript:void(0);" title=""><i class="icon-reorder"></i></a></li>
			</ul>

			<!-- Logo -->
			<a class="navbar-brand" href="index">
				<!-- <img src="assets/img/logo.png" alt="logo" /> -->
				Gest<strong>Guide</strong>
			</a>
			<!-- /logo -->

			<!-- Sidebar Toggler -->
			<a href="#" class="toggle-sidebar bs-tooltip" data-placement="bottom" data-original-title="Toggle navigation">
				<i class="icon-reorder"></i>
			</a>
			<!-- /Sidebar Toggler -->

			<!-- Top Left Menu -->
			<ul id="top-nav-menu" class="nav navbar-nav navbar-left hidden-xs hidden-sm">
				<!-- defined in navigation.jsp -->
			</ul>
			<!-- /Top Left Menu -->

			<!-- Top Right Menu -->
			<ul class="nav navbar-nav navbar-right">
				<!-- User Login Dropdown -->
				<li class="dropdown user">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<i class="icon-male"></i>
						<span class="username">John Doe</span>
						<i class="icon-caret-down small"></i>
					</a>
					<ul class="dropdown-menu">
						<li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
					</ul>
				</li>
				<!-- /user login dropdown -->
			</ul>
			<!-- /Top Right Menu -->
		</div>
		<!-- /top navigation bar -->
	</header> <!-- /.header -->

	<div id="container">
		<div id="sidebar" class="sidebar-fixed">
			<div id="sidebar-content">

				<!--=== Navigation ===-->
				<ul id="nav">
					
				</ul>
				<!-- /Navigation -->
			</div>
			<div id="divider" class="resizeable"></div>
		</div>
		<!-- /Sidebar -->

		<div id="content">
			<div class="container">
				<!-- Breadcrumbs line -->
				<div class="crumbs">
					<ul id="breadcrumbs" class="breadcrumb">
						<li>
							<i class="icon-home"></i>
							<a href='<c:url value="/" />'>Dashboard</a>
						</li>
						<li class="current">
							<a href='<c:url value="/customer" />'><spring:message code="label.customers"/></a>
						</li>
					</ul>

					<!-- <ul class="crumb-buttons">
						<li><a href="charts.html" title=""><i class="icon-signal"></i><span>Statistics</span></a></li>
					</ul> -->
				</div>
				<!-- /Breadcrumbs line -->

				<!--=== Page Header ===-->
				<div class="page-header">
					<!-- <div class="page-title">
						<h3>Dashboard</h3>
					</div> -->
				</div>
				<!-- /Page Header -->

				<!--=== Page Content ===-->
				<div class="row">
					<div class="col-md-12">
						<!-- Tabs-->
						<div class="tabbable tabbable-custom tabbable-full-width">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab_overview" data-toggle="tab"><spring:message code="label.profile" /></a></li>
								<li><a href="#tab_edit_account" data-toggle="tab"><spring:message code="label.edit" /></a></li>
							</ul>
							
							<div class="tab-content row">
								<div class="tab-pane active" id="tab_overview">
								
									<!--=== Profile TAB ===-->
									<div class="col-md-12"> 
										<div class="row profile-info">
											<div class="col-md-5">												
												<h1><c:out value="${result.firstName} ${result.lastName}" /></h1>

												<dl class="dl-horizontal">													
													<dt><spring:message code="label.ssn"/></dt>
													<dd><c:out value="${result.socialSecurityNumber}" /></dd>
													
													<dt><spring:message code="label.address"/></dt>
													<dd><c:out value="${result.address}" /></dd>
													
													<dt><spring:message code="label.zip"/></dt>
													<dd><c:out value="${result.zipCode}" /></dd>
													
													<dt><spring:message code="label.city"/></dt>
													<dd><c:out value="${result.city}" /></dd>
													
													<dt><spring:message code="label.province"/></dt>
													<dd><c:out value="${result.province}" /></dd>
													
													<dt><spring:message code="label.phone"/></dt>
													<dd><c:out value="${result.phone}" /></dd>
													
													<dt><spring:message code="label.mobilephone"/></dt>
													<dd><c:out value="${result.mobilePhone}" /></dd>														
													
													<dt><spring:message code="label.email"/></dt>
													<dd><c:out value="${result.email}" /></dd>
													
													<dt><spring:message code="label.datebirth"/></dt>
													<dd><c:out value="${result.dateOfBirth}" /></dd>
													
													<dt><spring:message code="label.school"/></dt>
													<dd><c:out value="${result.schoolName}" /></dd>													
												</dl>
											</div> <!-- /Profile Info -->
											
											<!--  -->
											<div class="col-md-7">
												<div class="widget box">
												    <div class="widget-header">
												        <h4><i class="icon-reorder"></i> <spring:message code="header.registration"/></h4>
												 
												        <!--=== Toolbar ===-->
												        <div class="toolbar no-padding">
												            <div class="btn-group">
												                <span class="btn btn-xs widget-collapse"><i class="icon-angle-down"></i></span>
												                <span class="btn btn-xs widget-refresh"><i class="icon-refresh"></i></span>
												                <span class="btn btn-xs"><i class="icon-plus"></i> <spring:message code="action.add"/></span>
												                <span class="btn btn-xs dropdown-toggle" data-toggle="dropdown">
												                    <spring:message code="action.manage"/> <i class="icon-angle-down"></i>
												                </span>
												                <ul class="dropdown-menu pull-right">
												                    <li><a href="#"><i class="icon-pencil"></i> <spring:message code="action.edit"/></a></li>
												                    <li><a href="#" onclick="addTableRow();return false;"><i class="icon-trash"></i> <spring:message code="action.add"/></a></li>												                    
												                </ul>
												            </div>
												        </div>
												        <!-- /Toolbar -->
												    </div>
												    <div class="widget-content">
												        <table id="activeRegistration" class="table table-striped table-bordered table-hover table-checkable">
															<thead>
																<tr>
																	<th><spring:message code="label.license.category" /></th>
																	<th><spring:message code="label.registrationDate" /></th>
																	<th><spring:message code="label.school" /></th>
																	<th></th>
																</tr>
															</thead>
															<tbody>
																<c:forEach items="${result.registrations}" var="registration">
																	<tr>
																		<td><c:out value="${registration.licenseCategory}" /></td>
																		<td><c:out value="${registration.registrationDate}" /></td>
																		<td><c:out value="${registration.schoolName}" /></td>
																		<td>																			
																			<a href='<c:url value="/reservation/add?subscription=${registration.id}&license=${registration.licenseId}&customer=${result.id}" />'><spring:message code="action.reserve" /></a> |
																			<a class='deleteLink' href="#" onclick="deleteRegistration(<c:out value="${registration.id}" />);return false;"><spring:message code="action.delete" /></a>
																		</td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>
														
														<div id="availableLicenses">
															<select id="availableLicensesList">
																<option value=-1 selected="selected"><spring:message code="input.select.addlicense" /></option>
																<c:forEach items="${result.availableLicenses}" var="avLicense">
																	<option value="${avLicense.key}">${avLicense.value}</option>
																</c:forEach>
															</select>
														</div>
												    </div>
												</div>
											</div>
											
										</div> <!-- /row -->
									</div>  <!-- /Profile -->
									
								</div>
								<!-- /Overview -->
								
								<!--=== Edit Account TAB ===-->
								<div class="tab-pane" id="tab_edit_account">
									<form class="form-horizontal" action="#">
										<div class="col-md-12">
											<div class="widget">
												<div class="widget-header">
													<h4>General Information</h4>
												</div>
												<div class="widget-content">
													<div class="row">
													
													</div>  <!-- /.row -->
												</div> <!-- /.widget-content -->
											</div> <!-- /.widget -->
										</div> <!-- /.col-md-12 -->
										<div class="form-actions">
												<input type="submit" value="Update Account" class="btn btn-primary pull-right">
											</div>
										</div> <!-- /.col-md-12 -->
									</form>
								</div>
								<!-- /Edit Account -->
																
							</div> <!-- /.tab-content -->
						</div>
						<!--END TABS-->
						
					</div>
				</div> <!-- /.row -->
				<!-- /Page Content -->

			</div>
			<!-- /.container -->

		</div>
	</div>

</body>
</html>