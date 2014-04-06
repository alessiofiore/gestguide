package it.mdps.gestguide.ui.services;

import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.core.services.SchoolService;
import it.mdps.gestguide.core.utils.SpringComponentFactory;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class UIFacade {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private SpringComponentFactory componentFactory;
	
	public void addSchool(SchoolBean schoolBean) {
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		service.addSchool(schoolBean);
	}
	
	public List<SchoolBean> getSchools() {
		logger.debug("Getting schools...");
		SchoolService service = componentFactory.getComponent(SchoolService.class);
		return service.getSchools();
	}

}
