package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping(method=RequestMethod.GET)
	public String reservation(Model model) {
		return "reservations";
	}
	
	@RequestMapping(value="/json/reservations/{schoolId}", method=RequestMethod.GET)
	public List<ReservationBean> getReservations(@PathVariable int schoolId) {
		
	}

}
