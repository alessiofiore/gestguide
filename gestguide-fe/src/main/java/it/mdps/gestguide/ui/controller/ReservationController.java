package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.core.services.ReservationService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reservation(Model model) {
		return "reservations";
	}
	
	@RequestMapping(value="/json/reservations", method=RequestMethod.GET)
	@ResponseBody
	public List<ReservationBean> getReservations(
			@RequestParam("schoolId") int schoolId) {
		
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
		
//		ReservationService service = componentFactory.getComponent(ReservationService.class);
//		return service.getReservations(schoolId, from, to);
	}
	
	@RequestMapping(value="/json/reservationsInterval", method=RequestMethod.GET)
	@ResponseBody
	public List<ReservationBean> getReservations(
			@RequestParam("schoolId") int schoolId, 
			@RequestParam("from") Date from, 
			@RequestParam("to") Date to) {
		

		logger.debug("Getting reservation for " + schoolId + " from " + from + " to " + to);
		
		ReservationService service = componentFactory.getComponent(ReservationService.class);
		return service.getReservations(schoolId, from, to);
	}

}
