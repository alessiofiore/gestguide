<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<!--<link href="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />-->
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery.ui.1.10.2.ie.css"/>
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

	<!--[if IE 8]>
		<link href="${pageContext.request.contextPath}/resources/assets/css/ie8.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
	
	<!-- Page specific css -->
	<link href="${pageContext.request.contextPath}/resources/assets/css/plugins/jquery.ui.timepicker.css" rel="stylesheet" type="text/css" />
	

	<!--=== JavaScript ===-->

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/lodash.compat.min.js"></script>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="assets/js/libs/html5shiv.js"></script>
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

	<!-- Forms -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script> <!-- Styled select boxes -->

	<!-- App -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/plugins.form-components.js"></script>


	<script>
		$(document).ready(
			function() {
				"use strict";
	
				App.init(); // Init layout and core plugins
				Plugins.init(); // Init all plugins
				FormComponents.init(); // Init all form-specific plugins
	
				// init top and left menu
				$("#top-nav-menu").load("${pageContext.request.contextPath}/nav-topbar");
				$("#nav").load("${pageContext.request.contextPath}/nav-sidebar");
			});
		
			$(function() {
				$.datepicker.setDefaults($.datepicker.regional["it"]);	
			    $( "#datepicker" ).datepicker({"dateFormat": "dd/mm/yy"});
		  	});
	</script>
</head>

<body>

	<!-- Header -->
	<header class="header navbar navbar-fixed-top" role="banner">
		<!-- Top Navigation Bar -->
		<div class="container">

			<!-- Only visible on smartphones, menu toggle -->
			<ul class="nav navbar-nav">
				<li class="nav-toggle"><a href="javascript:void(0);" title=""><i
						class="icon-reorder"></i></a></li>
			</ul>

			<!-- Logo -->
			<a class="navbar-brand" href="index"> <!-- <img src="assets/img/logo.png" alt="logo" /> -->
				Gest<strong>Guide</strong>
			</a>
			<!-- /logo -->

			<!-- Sidebar Toggler -->
			<a href="#" class="toggle-sidebar bs-tooltip" data-placement="bottom"
				data-original-title="Toggle navigation"> <i class="icon-reorder"></i>
			</a>
			<!-- /Sidebar Toggler -->

			<!-- Top Left Menu -->
			<ul id="top-nav-menu"
				class="nav navbar-nav navbar-left hidden-xs hidden-sm">
				<!-- defined in navigation.jsp -->
			</ul>
			<!-- /Top Left Menu -->

			<!-- Top Right Menu -->
			<ul class="nav navbar-nav navbar-right">
				<!-- User Login Dropdown -->
				<li class="dropdown user"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="icon-male"></i> <span
						class="username">John Doe</span> <i class="icon-caret-down small"></i>
				</a>
					<ul class="dropdown-menu">
						<li><a href="login.html"><i class="icon-key"></i> Log Out</a></li>
					</ul></li>
				<!-- /user login dropdown -->
			</ul>
			<!-- /Top Right Menu -->
		</div>
		<!-- /top navigation bar -->
	</header>
	<!-- /.header -->

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
							<i class="icon-home"></i> <a href='<c:url value="/" />'>Dashboard</a>
						</li>
						<li>
							<a href='<c:url value="${pageContext.request.contextPath}/customer" />'><spring:message code="header.customers" /></a></li>
							<li class="current"><spring:message code="header.addcustomer" />
						</li>
					</ul>
				</div>
				<!-- /Breadcrumbs line -->

				<!--=== Page Header ===-->
				<div class="page-header">
					<div class="page-title">
						<h3>
							<spring:message code="header.addcustomer" />
						</h3>
					</div>
				</div>
				<!-- /Page Header -->

				<!--=== Page Content ===-->
				<div class="row">
					<div class="col-md-12">
						<c:url var="url" value="/customer/add" />
						<form:form action="${url}" method="post" class="form-horizontal">
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.firstname" />:</label>
								<div class="col-md-10">
									<form:input path="firstName" type="text" name="regular" class="form-control" maxlength="30" size="20" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.lastname" />:</label>
								<div class="col-md-10">
									<form:input path="lastName" type="text" name="regular" class="form-control" maxlength="30" size="20" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.ssn" />:</label>
								<div class="col-md-10">
									<form:input path="socialSecurityNumber" type="text" name="regular" class="form-control" maxlength="16" size="16" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.address" />:</label>
								<div class="col-md-10">
									<form:input path="address" type="text" name="regular" class="form-control" maxlength="100" size="30" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.zip" />:</label>
								<div class="col-md-10">
									<form:input path="zipCode" type="text" name="regular" class="form-control" maxlength="5" size="5" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.city" />:</label>
								<div class="col-md-10">
									<form:input path="city" type="text" name="regular" class="form-control" maxlength="50" size="20" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.province" />:</label>
								<div class="col-md-10">
									<form:input path="province" type="text" name="regular" class="form-control" maxlength="2" size="2" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.phone" />:</label>
								<div class="col-md-10">
									<form:input path="phone" type="text" name="regular" class="form-control" maxlength="15" size="15" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.mobilephone" />:</label>
								<div class="col-md-10">
									<form:input path="mobilePhone" type="text" name="regular" class="form-control" maxlength="15" size="15" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.email" />:</label>
								<div class="col-md-10">
									<form:input path="email" type="text" name="regular" class="form-control" maxlength="50" size="30" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.datebirth" />:</label>
								<div class="col-md-10">
									<form:input path="dateOfBirth" type="text" name="regular" class="form-control" maxlength="10" size="10" id="datepicker" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label"><spring:message code="label.school" />:</label>
								<div class="col-md-10">
									<form:select path="schoolId">
										<form:option value="-1" label="--- Select ---" />
										<form:options items="${schools}" />
									</form:select>
								</div>
							</div>

							<div class="form-group">
								<div class="col-md-12">
									<input type="submit" />
								</div>
							</div>
						</form:form>
					</div>
					<!-- /.col-md-12 -->
				</div>
				<!-- /.row -->
				<!-- /Page Content -->

			</div>
			<!-- /.container -->

		</div>
	</div>

</body>
</html>