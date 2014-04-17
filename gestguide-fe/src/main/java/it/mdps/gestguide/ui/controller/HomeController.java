package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.utils.SpringComponentFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {	
		
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model) {
		return "reservations";
	}
	
	@RequestMapping(value="/navigation", method=RequestMethod.GET)
	public String getNavMenu() {
		return "navigation";
	}
	
	
}
