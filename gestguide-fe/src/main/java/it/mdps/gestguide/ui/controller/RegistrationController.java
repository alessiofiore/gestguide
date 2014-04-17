package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.common.StaticValues;
import it.mdps.gestguide.core.services.RegistrationService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping()
	public String delete(@RequestParam int registrationId) {
		RegistrationService service = componentFactory.getComponent(RegistrationService.class);
		
		return StaticValues.SUCCESS;
	}
}
