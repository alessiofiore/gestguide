package it.mdps.gestguide.ui;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.vaadin.ui.components.calendar.event.BasicEventProvider;

@SuppressWarnings("serial")
public class ReservationEventProvider extends BasicEventProvider {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getEvents(Date startDate, Date endDate) {
		GregorianCalendar start = new GregorianCalendar();
        GregorianCalendar end   = new GregorianCalendar();
        end.add(java.util.Calendar.HOUR, 5); 
        
		List<ReservationEvent> events = new ArrayList<ReservationEvent>();
		ReservationEvent event = new ReservationEvent("Calendar study",
                "Learning how to use Vaadin Calendar",
                start.getTime(), end.getTime(), "1");
		
		events.add(event);
		
		return events;
	}


}
