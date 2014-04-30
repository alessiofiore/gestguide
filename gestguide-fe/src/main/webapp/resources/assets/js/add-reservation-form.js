 /*
 * Script used in addReservation.jsp
 */

function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

$(function() {
	 $.datepicker.setDefaults($.datepicker.regional["it"]);	
	 $("#fromDate").datepicker({"dateFormat": "dd/mm/yy"});
	 $("#toDate").datepicker({"dateFormat": "dd/mm/yy"});
	 
	 var myDate = new Date();
	 var prettyDate = myDate.getDate() + '/' + (myDate.getMonth()+1) + '/' + myDate.getFullYear();
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
 });
 
 $(document).ready(function(){
	$("#selectInstructor").hide(); 
	$("#selectVehicle").hide();
	
	$( "#reservationDate" ).change(function(){
		alert(this.value);
	});
	
	$("#searchButton").click(function() {
		from = $("#fromDate").val() + " " + $("#fromTime").val();
		to = $("#toDate").val() + " " + $("#toTime").val();
		
		$.getJSON("../reservation/json/availableInstructors", 
			{
				sid: getParameterByName('sid'),
				lid: getParameterByName('lid'),
				from: from,
				to: to
			},
			function( data ) {				
			  var items = [];
			  items.push( "<option value=-1>Add license</option>");
			  $.each( data, function( key, val ) {
				 $("#availableLicensesList").append("<option value='" + val.id + "'>" + val.category + "</option>");
			  });
			}
		);
	});
 });