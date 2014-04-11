package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.core.services.SchoolService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;
import it.mdps.gestguide.ui.services.UIFacade;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/school")
public class SchoolController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView viewAddPage(Model model) {
		return new ModelAndView("addSchool", "command", new SchoolBean());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addSchool(@ModelAttribute SchoolBean schoolBean, Model model) {
		logger.debug("Adding schools " + schoolBean.getNomeSede());
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		service.addSchool(schoolBean);
		
		List<SchoolBean> beans = service.getSchools();
		model.addAttribute("results", beans);
		return "schools";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getSchools(Model model) {
		logger.debug("Getting schools...");
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		List<SchoolBean> beans = service.getSchools();
		model.addAttribute("results", beans);
		return "schools";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getSchool(Model model, @PathVariable long id) {
		logger.debug("Getting school " + id + " ...");
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		SchoolBean bean = service.getSchool(id);
		model.addAttribute("result", bean);
		return "school";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable long id) {
		logger.debug("Getting school " + id + " ...");
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		service.deleteSchool(id);
		
		List<SchoolBean> beans = service.getSchools();
		model.addAttribute("results", beans);
		return "schools";
	}
	
	@RequestMapping(value="/json/schools", method=RequestMethod.GET)
	@ResponseBody
	public List<SchoolBean> schools() {
		UIFacade uiFacade = componentFactory.getComponent(UIFacade.class);
		List<SchoolBean> beans = uiFacade.getSchools();
		return beans;
	}
	
	
}
