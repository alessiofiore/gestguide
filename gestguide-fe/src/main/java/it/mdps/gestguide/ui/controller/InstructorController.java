package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.InstructorBean;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.core.services.InstructorService;
import it.mdps.gestguide.core.services.SchoolService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView viewAddPage(Model model) {
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		List<SchoolBean> beans = service.getSchools();
		Map<Long, String> schools = new LinkedHashMap<Long, String>();
		for(SchoolBean b: beans) {
			schools.put(b.getId(), b.getNomeSede());
		}
		model.addAttribute("schools", schools);
		return new ModelAndView("addInstructor", "command", new InstructorBean());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addInstructor(@ModelAttribute InstructorBean instructorBean, Model model) {
		logger.debug("Adding instructors " + instructorBean.getId());
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		service.add(instructorBean);
		
		List<InstructorBean> beans = service.getList();
		model.addAttribute("results", beans);
		return "instructors";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getInstructors(Model model) {
		logger.debug("Getting instructors...");
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		List<InstructorBean> beans = service.getList();
		model.addAttribute("results", beans);
		return "instructors";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getInstructor(Model model, @PathVariable long id) {
		logger.debug("Getting instructor " + id + " ...");
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		InstructorBean bean = service.get(id);
		model.addAttribute("result", bean);
		return "instructor";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable long id) {
		logger.debug("Getting instructor " + id + " ...");
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		service.delete(id);
		
		List<InstructorBean> beans = service.getList();
		model.addAttribute("results", beans);
		return "instructors";
	}
	
}
