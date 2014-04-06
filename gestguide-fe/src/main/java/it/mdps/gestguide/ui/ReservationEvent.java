package it.mdps.gestguide.ui;

import java.util.Date;

import com.vaadin.ui.components.calendar.event.BasicEvent;

@SuppressWarnings("serial")
public class ReservationEvent extends BasicEvent {
	
	public ReservationEvent(String caption, String description, Date startDate,
			Date endDate, String id) {
		super(caption, description, startDate, endDate);
		this.id = id;
	}

	private String id;
	
	public String getId() {
		return id;
	}
}
