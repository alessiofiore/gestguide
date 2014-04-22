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
		return "index";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}
	
	@RequestMapping(value="/nav-topbar", method=RequestMethod.GET)
	public String getNavTopbar() {
		return "nav-topbar";
	}
	
	@RequestMapping(value="/nav-sidebar", method=RequestMethod.GET)
	public String getNavSidebar() {
		return "nav-sidebar";
	}
	
	
}
