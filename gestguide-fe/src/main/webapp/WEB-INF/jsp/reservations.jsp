<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/redmond/jquery-ui-1.10.4.custom.min.css"/>" />
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/fullcalendar.css"/>" />

<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui-1.10.4.custom.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/fullcalendar.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/init.js"/>"></script>

<title><spring:message code="sitename"/></title>

<script>

	$(document).ready(function() {
	
		var date = new Date();
		
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
	        events: function(start, end, callback) {
	            $.ajax({
	                url: '/gestguide/reservation/json/reservations',
	                dataType: 'json',
	                data: {
	                	schoolId: '1'
	                },
	                success: function(data) {
	                    var events = [];
	                    $.each( data, function( key, val ) {
	                    	events.push({
	                    		id: val.schoolId,
	                            title: val.title,
	                            start: new Date(val.startDate),
	                            end: new Date(val.endDate),
	                            allDay: false
	                        });
	                    });	                    
	                    callback(events);
	                },
	                error: function(qXHR, textStatus, errorThrown) {
			            alert('there was an error while fetching events! ' + errorThrown);
			        },
			        color: 'yellow',   // a non-ajax option
			        textColor: 'black' // a non-ajax option
	            });
	        },
	        eventClick: function(event) {
	        	$( "#dialog" ).dialog( "open" );
	        }
		});	
		
		$( "#dialog" ).dialog({
		      autoOpen: false,
		      modal: true,
		      show: {
		        effect: "blind",
		        duration: 500
		      },
		      hide: {
		        effect: "blind",
		        duration: 500
		      }
		    });
	});
	
	

</script>

</head>
<body>
<div id="wrapper">
	<div id="navMenu"></div>
	<div class="navigation"><a href="<c:url value="/customer/add" />">Add new</a></div>
	<div id='calendar'></div>
	
	<div id="dialog" title="Basic modal dialog">
	  <p>Adding the modal overlay screen makes the dialog look more prominent because it dims out the page content.</p>
	</div>
</div>
</body>
</html>