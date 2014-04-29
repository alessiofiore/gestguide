package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.CustomerBean;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.core.services.CustomerService;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
@SessionAttributes("schoolId")
public class CustomerController {

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
		return new ModelAndView("addCustomer", "command", new CustomerBean());
	}
	
	/*
	 * customerBean map a Spring form
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCustomer(@ModelAttribute("schoolId") int schoolId,
			@ModelAttribute CustomerBean customerBean, Model model) {
		logger.debug("Adding customers " + customerBean.getId());
		CustomerService service = componentFactory.getComponent(CustomerService.class);
		service.add(customerBean);
		
		List<CustomerBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "customers";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getCustomers(@ModelAttribute("schoolId") int schoolId, Model model) {
		logger.debug("Getting customers...");
		CustomerService service = componentFactory.getComponent(CustomerService.class);
		List<CustomerBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "customers";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getCustomer(Model model, @PathVariable Integer id) {
		logger.debug("Getting customer " + id + " ...");
		CustomerService service = componentFactory.getComponent(CustomerService.class);
		CustomerBean bean = service.get(id);
		model.addAttribute("result", bean);
		return "customer";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@ModelAttribute("schoolId") int schoolId, Model model, @PathVariable Integer id) {
		logger.debug("Getting customer " + id + " ...");
		CustomerService service = componentFactory.getComponent(CustomerService.class);
		service.delete(id);
		
		List<CustomerBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "customers";
	}
	
}
