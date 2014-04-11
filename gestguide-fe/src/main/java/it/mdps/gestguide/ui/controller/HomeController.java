package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {	
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(value="/welcome.do", method=RequestMethod.GET)
	public String welcome(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);
		return "welcome";
	}
	
	@RequestMapping(value="/index.do", method=RequestMethod.GET)
	public ModelAndView  index(Model model) {
		return new ModelAndView("index", "command", new SchoolBean());
	}
	
	
}
