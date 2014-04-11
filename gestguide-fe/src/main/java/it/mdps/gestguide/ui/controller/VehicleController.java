package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.VehicleBean;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.core.services.VehicleService;
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
@RequestMapping("/vehicle")
public class VehicleController {

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
		return new ModelAndView("addVehicle", "command", new VehicleBean());
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addVehicle(@ModelAttribute VehicleBean vehicleBean, Model model) {
		logger.debug("Adding vehicles " + vehicleBean.getId());
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		service.add(vehicleBean);
		
		List<VehicleBean> beans = service.getList();
		model.addAttribute("results", beans);
		return "vehicles";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getVehicles(Model model) {
		logger.debug("Getting vehicles...");
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		List<VehicleBean> beans = service.getList();
		model.addAttribute("results", beans);
		return "vehicles";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getVehicle(Model model, @PathVariable long id) {
		logger.debug("Getting vehicle " + id + " ...");
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		VehicleBean bean = service.get(id);
		model.addAttribute("result", bean);
		return "vehicle";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(Model model, @PathVariable long id) {
		logger.debug("Getting vehicle " + id + " ...");
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		service.delete(id);
		
		List<VehicleBean> beans = service.getList();
		model.addAttribute("results", beans);
		return "vehicles";
	}
	
}