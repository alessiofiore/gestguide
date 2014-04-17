package it.mdps.gestguide.core.services;

import it.mdps.gestguide.database.dao.DaoFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class RegistrationService {

	@Autowired
	private DaoFactory daoFactory;
	
//	public List<RegistrationBean> getRegistrations(int customerId) {
//		IscrizioneDao dao = daoFactory.getIscrizioneDao();
//		List<Iscrizione> iscrizioni = dao.findRegistrationsByCustomerId(customerId);
//		
//		List<RegistrationBean> beans = new ArrayList<RegistrationBean>();
//		for(Iscrizione i: iscrizioni)
//			beans.add(BeanConverter.toRegistrationBean(i));
//		
//		return beans;
//	}
}
