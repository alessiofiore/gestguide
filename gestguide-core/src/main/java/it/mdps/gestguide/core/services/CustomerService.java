package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.CustomerBean;
import it.mdps.gestguide.core.beans.RegistrationBean;
import it.mdps.gestguide.core.exception.EntityNotFoundException;
import it.mdps.gestguide.core.exception.EntityNotFoundException.ErrorType;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.ClienteDao;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.PatenteDao;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Cliente;
import it.mdps.gestguide.database.model.Iscrizione;
import it.mdps.gestguide.database.model.Patente;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class CustomerService {

	@Autowired
	private DaoFactory daoFactory;
	
	// Add
	public void add(CustomerBean bean) {
		Cliente cliente = BeanConverter.fromCustomerBean(bean);
		
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		Autoscuola a = autoscuolaDao.find(Autoscuola.class, bean.getSchoolId());
		if(a == null)
			throw new EntityNotFoundException(ErrorType.SCHOOL_NOT_FOUND);
		
		cliente.setAutoscuola(a);
		cliente.setDataCreazione(new Date());
		ClienteDao clienteDao = daoFactory.getClienteDao();
		clienteDao.save(cliente);
	}
	
	// Get List
	@Transactional(readOnly=true)
	public List<CustomerBean> getList(int schoolId) {
		ClienteDao dao = daoFactory.getClienteDao();
		List<Cliente> customers = dao.findAll(schoolId);	
		
		List<CustomerBean> customerBeans = new ArrayList<CustomerBean>();		
		for(Cliente c: customers) {
			CustomerBean bean = BeanConverter.toCustomerBean(c);
			customerBeans.add(bean);
		}
		
		return customerBeans;
	}
	
	// Find
	@Transactional(readOnly=true)
	public CustomerBean get(Integer id) {
		ClienteDao dao = daoFactory.getClienteDao();
		Cliente c = dao.find(Cliente.class, id);
		CustomerBean bean = BeanConverter.toCustomerBean(c);
		
		List<RegistrationBean> registrations = new ArrayList<RegistrationBean>();
		HashSet<String> activeLicenses = new HashSet<String>();
		for(Iscrizione i: c.getIscriziones()) {
			registrations.add(BeanConverter.toRegistrationBean(i));
			activeLicenses.add(i.getPatente().getCategoria());
		}
		bean.setRegistrations(registrations);
		
		// get all licenses
		PatenteDao pDao = daoFactory.getPatenteDao();
		List<Patente> patenti = pDao.findAll();
		
		// calculate licenses non already used
		Map<Integer, String> availableLicenses = new LinkedHashMap<Integer, String>();
		for(Patente p: patenti) {
			if(!activeLicenses.contains(p.getCategoria()))
				availableLicenses.put(p.getIdPatente(), p.getCategoria());
		}
		bean.setAvailableLicenses(availableLicenses);
		
		return bean;
	}
	
	// Delete
	public void delete(Integer id) {
		ClienteDao dao = daoFactory.getClienteDao();
		dao.delete(id);
	}
	
}
