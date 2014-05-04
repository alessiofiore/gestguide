package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.common.StaticValues;
import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.core.services.ReservationService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;
import it.mdps.gestguide.ui.utils.DateUtil;

import java.text.ParseException;
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
	public String reservation() {
		return "pages_calendar";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String viewReservationPage() {
		return "addReservation";
	}
	
	/*
	 * ------------------------------------------------------------------------------------
	 */
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public String addReservation(
			@ModelAttribute("schoolId") int schoolId,
			@RequestParam("subscription") int subscriptionId,
			@RequestParam("from") String from,
			@RequestParam("to") String to,
			@RequestParam("instructor") int instructorId,
			@RequestParam("vehicle") int vehicleId) {
		
		ReservationService service = componentFactory.getComponent(ReservationService.class);
		try {
			Date fromDate = DateUtil.parseDate(from);
			Date toDate = DateUtil.parseDate(to);
			service.addReservation(schoolId, subscriptionId, instructorId, vehicleId, fromDate, toDate);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			// TODO
			//throw new ServiceException();
		}
		
		return StaticValues.SUCCESS;
	}
	
	
	
	/*
	 * ------------------------------------------------------------------------------------
	 * JSON
	 * ------------------------------------------------------------------------------------
	 */
	/**
	 * Return all reservations of current month
	 * 
	 * @param schoolId
	 * @return
	 */
	@RequestMapping(value="/json/reservations", method=RequestMethod.GET)
	@ResponseBody
	public List<ReservationBean> getReservations(
			@ModelAttribute("schoolId") int schoolId) {
		
		Calendar c = Calendar.getInstance();
		// first date of current month
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));		
		Date from = c.getTime();
		
		// last date of current month
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, c.getActualMaximum(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, c.getActualMaximum(Calendar.MINUTE));
		c.set(Calendar.SECOND, c.getActualMaximum(Calendar.SECOND));
		Date to = c.getTime();
		
		return this.getReservations(schoolId, from, to);
	}
	
	/**
	 * Return all reservations in a given interval
	 * 
	 * @param schoolId
	 * @param from
	 * @param to
	 * @return
	 */
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
	
	/**
	 * Return available instructors
	 * 
	 * @param schoolId
	 * @param licenseId
	 * @param from
	 * @param to
	 * @return
	 */
	@RequestMapping(value="/json/availableInstructors", method=RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> getAvailableInstructors(
			@ModelAttribute("schoolId") int schoolId,
			@RequestParam("license") int licenseId,
			@RequestParam("from") String from,
			@RequestParam("to") String to) {
		
			Map<Integer, String> instructors = new LinkedHashMap<Integer, String>();
			
			try {
				Date fromDate = DateUtil.parseDate(from);
				Date toDate = DateUtil.parseDate(to);
				
				logger.info("Searching available instructors from " + fromDate + " to " + toDate);
				ReservationService service = componentFactory.getComponent(ReservationService.class);
				instructors = service.getAvailableInstructor(schoolId, licenseId, fromDate, toDate);
				
			} catch (ParseException e) {
				logger.error(e.getMessage());
				// TODO
				//throw new ServiceException();
			}
			
			return instructors;
	}
	
	/**
	 * Return available vehicles
	 * 
	 * @param schoolId
	 * @param licenseId
	 * @param from
	 * @param to
	 * @return
	 */
	@RequestMapping(value="/json/availableVehicles", method=RequestMethod.GET)
	@ResponseBody
	public Map<Integer, String> getAvailableVehicles(
			@ModelAttribute("schoolId") int schoolId,
			@RequestParam("license") int licenseId,
			@RequestParam("from") String from,
			@RequestParam("to") String to) {
		
		Map<Integer, String> vehicles = new LinkedHashMap<Integer, String>();
		
		try {
			Date fromDate = DateUtil.parseDate(from);
			Date toDate = DateUtil.parseDate(to);
			
			logger.info("Searching available instructors from " + fromDate + " to " + toDate);
			ReservationService service = componentFactory.getComponent(ReservationService.class);
			vehicles = service.getAvailableVehicles(schoolId, licenseId, fromDate, toDate);
			
		} catch (ParseException e) {
			logger.error(e.getMessage());
			
			// TODO
			//throw new ServiceException();
		}
		
		return vehicles;
	}

}
