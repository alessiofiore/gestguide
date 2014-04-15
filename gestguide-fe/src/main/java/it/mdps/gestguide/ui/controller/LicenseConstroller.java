package it.mdps.gestguide.ui.controller;

import it.mdps.gestguide.core.beans.LicenseBean;
import it.mdps.gestguide.core.services.LicenseService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LicenseConstroller {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	@RequestMapping("json/licenses")
	@ResponseBody
	public List<LicenseBean> getLicenses() {
		logger.debug("Getting licenses...");
		LicenseService service = componentFactory.getComponent(LicenseService.class);
		
		return service.getLicenses();
	}
}
