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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vehicle")
@SessionAttributes("schoolId")
public class VehicleController {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	/*
	 * ------------------------------------------------------------------------------------
	 * Pages
	 * ------------------------------------------------------------------------------------
	 */
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView viewAddPage(Model model) {
		// TODO prendere solo la lista delle scuole parte del consorzio
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		List<SchoolBean> beans = service.getSchools();
		Map<Integer, String> schools = new LinkedHashMap<Integer, String>();
		for(SchoolBean b: beans) {
			schools.put(b.getId(), b.getNomeSede());
		}
		model.addAttribute("schools", schools);
		return new ModelAndView("addVehicle", "command", new VehicleBean());
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getVehicles(@ModelAttribute("schoolId") int schoolId, Model model) {
		logger.debug("Getting vehicles...");
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		List<VehicleBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "vehicles";
	}
	
	// ------------------------------------------------------------------------------------
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addVehicle(
			@ModelAttribute("schoolId") int schoolId,
			@ModelAttribute VehicleBean vehicleBean, Model model)
	{
		logger.debug("Adding vehicles " + vehicleBean.getMarca() + " " + vehicleBean.getModello());
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		service.add(vehicleBean);
		
		List<VehicleBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "vehicles";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getVehicle(Model model, @PathVariable Integer id) {
		logger.debug("Getting vehicle " + id + " ...");
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		VehicleBean bean = service.get(id);
		model.addAttribute("result", bean);
		return "vehicle";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@ModelAttribute("schoolId") int schoolId, Model model, @PathVariable Integer id) {
		logger.debug("Getting vehicle " + id + " ...");
		VehicleService service = componentFactory.getComponent(VehicleService.class);
		service.delete(id);
		
		List<VehicleBean> beans = service.getList(schoolId);
		model.addAttribute("results", beans);
		return "vehicles";
	}
	
}
