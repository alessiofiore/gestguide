package it.mdps.gestguide.ui.components;

import it.mdps.gestguide.ui.CalendarActionHandler;
import it.mdps.gestguide.ui.ReservationEventClickHandler;
import it.mdps.gestguide.ui.ReservationEventProvider;

import com.vaadin.annotations.Theme;
import com.vaadin.ui.Calendar;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class ReservationComponent extends CustomComponent
{

    public ReservationComponent() {
        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        setCompositionRoot(layout);
        
        Calendar calendar = new Calendar("My Calendar");
        calendar.setWidth("600px");
        calendar.setHeight("300px");
        calendar.addActionHandler(new CalendarActionHandler());
        calendar.setEventProvider(new ReservationEventProvider());
        calendar.setHandler(new ReservationEventClickHandler());
        
        layout.addComponent(calendar);
    }

}
