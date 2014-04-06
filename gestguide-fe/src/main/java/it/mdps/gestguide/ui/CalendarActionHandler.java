package it.mdps.gestguide.ui;

import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;

public class CalendarActionHandler implements Handler {

	@Override
	public Action[] getActions(Object target, Object sender) {
		Action delete = new Action("Delete");
		// TODO Auto-generated method stub
		return new Action[]{delete};
	}

	@Override
	public void handleAction(Action action, Object sender, Object target) {
		// TODO Auto-generated method stub
		
	}

}
