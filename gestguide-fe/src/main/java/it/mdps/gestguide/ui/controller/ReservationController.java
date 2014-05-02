package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.core.services.ReservationService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/reservation")
@SessionAttributes("schoolId")
public class ReservationController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	/*
	 * ------------------------------------------------------------------------------------
	 * Pages
	 * ------------------------------------------------------------------------------------
	 */
	
	@RequestMapping(method=RequestMethod.GET)
	public String reservation(Model model) {
		return "pages_calendar";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String viewReservationPage(@RequestParam("sid") int subscriptionId) {
		return "addReservation";
	}
	
	/*
	 * ------------------------------------------------------------------------------------
	 */
	
	
	
	/*
	 * ------------------------------------------------------------------------------------
	 * JSON
	 * ------------------------------------------------------------------------------------
	 */
	
	@RequestMapping(value="/json/reservations", method=RequestMethod.GET)
	@ResponseBody
	public List<ReservationBean> getReservations(
			@ModelAttribute("schoolId") int schoolId) {
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));		
		Date from = c.getTime();
		
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
		Date to = c.getTime();
		
		return this.getReservations(schoolId, from, to);
	}
	
	@RequestMapping(value="/json/reservationsInterval", method=RequestMethod.GET)
	@ResponseBody
	public List<ReservationBean> getReservations(
			@ModelAttribute("schoolId") int schoolId, 
			@RequestParam("from") Date from, 
			@RequestParam("to") Date to) {
		

		logger.debug("Getting reservation for " + schoolId + " from " + from + " to " + to);
		
		ReservationService service = componentFactory.getComponent(ReservationService.class);
		return service.getReservations(schoolId, from, to);
	}
	
	@RequestMapping(value="/json/availableInstructors", method=RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> getAvailableInstructors(
			@ModelAttribute("schoolId") int schoolId,
			@RequestParam("sid") int subscriptionId,
			@RequestParam("lid") int licenseId,
			@RequestParam("from") String from,
			@RequestParam("to") String to) {
		
			Map<Integer, String> instructors = new LinkedHashMap<Integer, String>();
		
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
			try {
				Date fromDate = sdf.parse(from);
				Date toDate = sdf.parse(to);
				
				logger.info("Searching available instructors from " + fromDate + " to " + toDate);
				ReservationService service = componentFactory.getComponent(ReservationService.class);
				instructors = service.getAvailableInstructor(schoolId, licenseId, fromDate, toDate);
				
			} catch (ParseException e) {
				logger.error(e.getMessage());
			}
			
			return instructors;
	}

}
