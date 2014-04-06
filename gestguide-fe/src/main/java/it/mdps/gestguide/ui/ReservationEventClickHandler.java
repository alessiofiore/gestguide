package it.mdps.gestguide.ui;

import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClick;
import com.vaadin.ui.components.calendar.CalendarComponentEvents.EventClickHandler;

@SuppressWarnings("serial")
public class ReservationEventClickHandler implements EventClickHandler {

	@Override
	public void eventClick(EventClick event) {
		ReservationEvent resEvent = (ReservationEvent) event.getCalendarEvent();
		System.out.println(resEvent.getId());
		
	}

}
