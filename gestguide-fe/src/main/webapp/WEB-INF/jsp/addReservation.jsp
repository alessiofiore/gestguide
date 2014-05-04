<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

	<!-- Page specific plugins -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/timepicker/jquery.ui.timepicker.js"></script>
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/blockui/jquery.blockUI.min.js"></script> --%>

	<!-- Forms -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script> <!-- Styled select boxes -->

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
		
		// init top and left menu
		$("#top-nav-menu").load("${pageContext.request.contextPath}/nav-topbar");
		$("#nav").load("${pageContext.request.contextPath}/nav-sidebar");
	});
	
	// init i18n messages for javascript use
	var messages = new Array();
	messages['input.select.instructor'] = "<spring:message code="input.select.instructor"/>";
	messages['input.select.vehicle'] = "<spring:message code="input.select.vehicle"/>";
	
	</script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/add-reservation-form.js"></script>
	
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
						<li>
							<a href="${pageContext.request.contextPath}/reservation"><spring:message code="header.reservations"/></a>
						</li>						
						<li class="current">
							<spring:message code="header.addreservation"/>
						</li>
					</ul>
				</div>
				<!-- /Breadcrumbs line -->

				<!--=== Page Header ===-->
				<div class="page-header">
					<div class="page-title">
						<h3><spring:message code="header.addreservation"/></h3>
					</div>
				</div>
				<!-- /Page Header -->

				<!--=== Page Content ===-->
				<div class="row">
					<div class="col-md-12">					
						<div class="widget box">
							<div class="widget-header">
								<h4><i class="icon-reorder"></i> <spring:message code="header.reservations.availability" arguments="a" /></h4>								
							</div>
							<div class="widget-content">
								<!-- <form class="form-horizontal row-border" action="#"> -->
									<div class="form-group">
										<div class="row">
											<div class="col-md-8">
												<div class="row">
													<div class="col-md-2">
														<label class="control-label"><spring:message code="label.reservation.from"/></label>
													</div>
													<div class="col-md-3">
														 <input type="text" maxlength="10" size="10" id="fromDate" class="form-control input-width-medium">
														 <span class="help-block"><spring:message code="label.reservation.from.date"/></span>
													</div>
													<div class="col-md-3">
														<input type="text" maxlength="10" size="10" id="fromTime" class="form-control input-width-medium">
														<span class="help-block"><spring:message code="label.reservation.from.time"/></span>
													</div>
																							
												</div>
												<div class="row">
													<div class="col-md-2">
														<label class="control-label"><spring:message code="label.reservation.to"/></label>
													</div>
													<div class="col-md-3">
														 <input type="text" maxlength="10" size="10" id="toDate" class="form-control input-width-medium">
														 <span class="help-block"><spring:message code="label.reservation.to.date"/></span>
													</div>
													<div class="col-md-3">
														<input type="text" maxlength="10" size="10" id="toTime" class="form-control input-width-medium">
														<span class="help-block"><spring:message code="label.reservation.to.time"/></span>
													</div>										
												</div>
											</div>
											<div class="col-md-1">
												<div class="row">
													<button class="btn btn-lg" id="searchButton"><spring:message code="input.button.search"/></button>
												</div>
											</div>	
										</div>
								    </div>
									<div class="form-group" >
										<div class="row" id="">
											<div class="col-md-3" id="availInstructor">
										        <select class="form-control col-md-3" name="select" id="selectInstructor"> </select>
									        </div>
									        <div class="col-md-3" id="availVehicle">
										        <select class="form-control col-md-3" name="select" id="selectVehicle"> </select>
									        </div>
									        <div class="col-md-1">												
												<button class="btn btn-lg" id="saveButton"><spring:message code="input.button.save"/></button>												
											</div>	
								        </div>
								    </div>
								<!-- </form> -->
							</div>
						</div> <!-- /.widget box -->
					</div> <!-- /.col-md-12 -->
				</div> <!-- /.row -->
				<!-- /Page Content -->

			</div>
			<!-- /.container -->

		</div>
	</div>

</body>
</html>