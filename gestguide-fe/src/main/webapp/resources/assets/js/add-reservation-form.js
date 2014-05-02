 /*
 * Script used in addReservation.jsp
 */

$(document).ready(function(){	

	hideRow();
	
	$("#searchButton").click(function() {
		initForm();
		from = $("#fromDate").val() + " " + $("#fromTime").val();
		to = $("#toDate").val() + " " + $("#toTime").val();
		
		getAvailableInstructors(getParameterByName('sid'), getParameterByName('lid'), from, to);
	});
	
	$("#fromDate").change(function() {
		hideRow();
	});
	
	$("#toDate").change(function() {
		hideRow();
	});
 });

$(function init() {
	initDateTime();
	initForm();
});

// utils
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function hideRow() {
	$("#availInstructor").hide();
	$("#availVehicle").hide();
	$("#saveButton").hide();
}

function initForm() {
	
	$("#selectInstructor").empty();
	$("#selectVehicle").empty();
	
	$("#selectInstructor").append("<option selected='selected'>" + messages['input.select.instructor'] + "</option>");
	$("#selectVehicle").append("<option selected='selected'>" + messages['input.select.vehicle'] + "</option>");
}

function initDateTime() {
	$.datepicker.setDefaults($.datepicker.regional["it"]);	
	 $("#fromDate").datepicker({"dateFormat": "dd/mm/yy"});
	 $("#toDate").datepicker({"dateFormat": "dd/mm/yy"});
	 
	 var fromDate = new Date();
	 
	 var prettyDate = ("0" + (fromDate.getDate() -1)).slice(-2) + '/' + ("0" + (fromDate.getMonth() + 1)).slice(-2) + '/' + fromDate.getFullYear();
	 var prettyTime = ("0" + fromDate.getHours()).slice(-2) + ":" + ("0" + fromDate.getMinutes()).slice(-2);
		 
	 $("#fromDate").val(prettyDate);
	 $("#toDate").val(prettyDate);
	 
	 $("#fromTime").timepicker({
		 timeSeparator: ':',
		 hours: {
		        starts: 0,                // First displayed hour
		        ends: 23                  // Last displayed hour
		    },
		    minutes: {
		        starts: 0,                // First displayed minute
		        ends: 55,                 // Last displayed minute
		        interval: 5,              // Interval of displayed minutes
		        manual: []                // Optional extra entries for minutes
		    },
		    rows: 4,                      // Number of rows for the input tables, minimum 2, makes more sense if you use multiple of 2
		    showHours: true,              // Define if the hours section is displayed or not. Set to false to get a minute only dialog
		    showMinutes: true
	 });
	 
	 $("#toTime").timepicker({
		 timeSeparator: ':',
		 hours: {
		        starts: 0,                // First displayed hour
		        ends: 23                  // Last displayed hour
		    },
		    minutes: {
		        starts: 0,                // First displayed minute
		        ends: 55,                 // Last displayed minute
		        interval: 5,              // Interval of displayed minutes
		        manual: []                // Optional extra entries for minutes
		    },
		    rows: 4,                      // Number of rows for the input tables, minimum 2, makes more sense if you use multiple of 2
		    showHours: true,              // Define if the hours section is displayed or not. Set to false to get a minute only dialog
		    showMinutes: true
	 });
	 
	 $("#fromTime").val(prettyTime);
	 $("#toTime").val(prettyTime);
}

function getAvailableInstructors(sid, lid, from, to) {
	$.getJSON("../reservation/json/availableInstructors", 
			{
				sid: sid,
				lid: lid,
				from: from,
				to: to
			},
			function( data ) {
			  var items = [];
			  items.push( "<option value=-1>Add license</option>");
			  $.each( data, function( key, val ) {
				 $("#selectInstructor").append("<option value='" + key + "'>" + val + "</option>");
			  });
			}
		);
	
	$("#availInstructor").show();
	$("#availVehicle").show();
	$("#saveButton").show();
}
 
 