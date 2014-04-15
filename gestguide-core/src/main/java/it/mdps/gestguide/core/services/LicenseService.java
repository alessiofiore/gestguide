package it.mdps.gestguide.core.services;

import java.util.ArrayList;
import java.util.List;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.LicenseBean;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.PatenteDao;
import it.mdps.gestguide.database.model.Patente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class LicenseService {

	@Autowired
	private DaoFactory daoFactory;
	
	public List<LicenseBean> getLicenses() {
		PatenteDao dao = daoFactory.getPatenteDao();
		List<Patente> patenti = dao.findAll();
		List<LicenseBean> licenses = new ArrayList<LicenseBean>();
		
		for(Patente p: patenti) {
			LicenseBean bean = BeanConverter.toLicenseBean(p);
			licenses.add(bean);
		}
		return licenses;
	}
}
