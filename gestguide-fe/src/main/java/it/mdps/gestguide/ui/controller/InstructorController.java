package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.common.StaticValues;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/instructor")
@SessionAttributes("schoolId")
public class InstructorController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView viewAddPage(Model model) {
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		List<SchoolBean> beans = service.getSchools();
		Map<Integer, String> schools = new LinkedHashMap<Integer, String>();
		for(SchoolBean b: beans) {
			schools.put(b.getId(), b.getNomeSede());
		}
		model.addAttribute("schools", schools);
		return new ModelAndView("addInstructor", "command", new InstructorBean());
	}
	
	/*
	 * instructorBean map a Spring form
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addInstructor(
			@ModelAttribute("schoolId") int schoolId,
			@ModelAttribute InstructorBean instructorBean, Model model) {
		logger.debug("Adding instructors " + instructorBean.getFirstName() + " " + instructorBean.getLastName());
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		service.add(instructorBean);
		
		List<InstructorBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "instructors";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getInstructors(@ModelAttribute("schoolId") int schoolId, Model model) {
		logger.debug("Getting instructors...");
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		List<InstructorBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "instructors";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getInstructor(Model model, @PathVariable Integer id) {
		logger.debug("Getting instructor " + id + " ...");
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		InstructorBean bean = service.get(id);
		model.addAttribute("result", bean);
		return "instructor";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@ModelAttribute("schoolId") int schoolId,Model model, @PathVariable Integer id) {
		logger.debug("Getting instructor " + id + " ...");
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		service.delete(id);
		
		List<InstructorBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "instructors";
	}
	
	@RequestMapping(value="/deleteLicense", method=RequestMethod.POST)
	@ResponseBody
	public String deleteLicense(
			@RequestParam("licenseId") int licenseId, 
			@RequestParam("instructorId") int instructorId
			) {
		logger.debug("Deleting license " + licenseId + " for instructor " + instructorId);
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		service.deleteLicence(licenseId, instructorId);
		return StaticValues.SUCCESS;
	}
	
	@RequestMapping(value="/addLicense", method=RequestMethod.POST)
	@ResponseBody
	public String addLicense(
			@RequestParam("licenseId") int licenseId, 
			@RequestParam("instructorId") int instructorId,
			@RequestParam("costPerHour") short costPerHour
			) {
		logger.debug("Adding license " + licenseId + " for instructor " + instructorId);
		InstructorService service = componentFactory.getComponent(InstructorService.class);
		service.addLicence(licenseId, instructorId, costPerHour);
		logger.debug("Added license " + licenseId + " for instructor " + instructorId);
		return StaticValues.SUCCESS;
	}
	
}
