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
//				data: {
//					schoolId: '1'
//				},
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