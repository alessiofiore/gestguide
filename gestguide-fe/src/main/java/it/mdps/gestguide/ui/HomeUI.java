package it.mdps.gestguide.ui;

import it.mdps.gestguide.ui.components.HomeLayout;
import it.mdps.gestguide.ui.services.UIFacade;
import it.mdps.gestguide.ui.utils.SpringContextHelper;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@Theme("mytheme")
@SuppressWarnings("serial")
public class HomeUI extends UI
{

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = HomeUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
    	SpringContextHelper helper = new SpringContextHelper(VaadinServlet.getCurrent().getServletContext());
    	UIFacade facade = (UIFacade) helper.getBean("uiFacade");
    	
    	HomeLayout layout = new HomeLayout(facade);
    	layout.setWidth("90%");
    	setContent(layout);
        
    }

}
