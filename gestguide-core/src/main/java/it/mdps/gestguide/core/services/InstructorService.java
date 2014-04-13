package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.InstructorBean;
import it.mdps.gestguide.core.beans.LicenseBean;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.IstruttoreDao;
import it.mdps.gestguide.database.model.Abilitazione;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Istruttore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class InstructorService {

	@Autowired
	private DaoFactory daoFactory;
	
	// Add
	public void add(InstructorBean bean) {
		Istruttore entity = BeanConverter.fromInstructorBean(bean);
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		Autoscuola a = autoscuolaDao.find(Autoscuola.class, bean.getSchoolId());
		entity.setAutoscuola(a);
		entity.setDataCreazione(new Date());
		IstruttoreDao clienteDao = daoFactory.getIstruttoreDao();
		clienteDao.save(entity);
	}
	
	// Get List
	public List<InstructorBean> getList() {
		IstruttoreDao dao = daoFactory.getIstruttoreDao();
		List<Istruttore> customers = dao.findAll();
		
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		List<Autoscuola> schools = autoscuolaDao.findAll();
		List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();
		for(Autoscuola a: schools)
			schoolBeans.add(BeanConverter.toSchoolBean(a));			
		
		List<InstructorBean> customerBeans = new ArrayList<InstructorBean>();		
		for(Istruttore c: customers) {
			InstructorBean bean = BeanConverter.toInstructorBean(c);
			customerBeans.add(bean);
		}
		
		return customerBeans;
	}
	
	// Find
	@Transactional(readOnly=true)
	public InstructorBean get(Integer id) {
		IstruttoreDao dao = daoFactory.getIstruttoreDao();
		Istruttore c = dao.find(Istruttore.class, id);
		
		InstructorBean instructor = BeanConverter.toInstructorBean(c);
		
		// set licenses owned
		List<Abilitazione> abilitazioni = c.getAbilitaziones();
		List<LicenseBean> licenses = new ArrayList<LicenseBean>();
		for(Abilitazione a: abilitazioni) {
			LicenseBean bean = BeanConverter.toLicenseBean(a);
			licenses.add(bean);
		}
		instructor.setLicenses(licenses);
		
		return instructor;
	}
	
	// Delete
	public void delete(Integer id) {
		IstruttoreDao dao = daoFactory.getIstruttoreDao();
		dao.delete(id);
	}
	
}
