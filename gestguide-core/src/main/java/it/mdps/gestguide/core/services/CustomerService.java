package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.CustomerBean;
import it.mdps.gestguide.core.beans.RegistrationBean;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.ClienteDao;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Cliente;
import it.mdps.gestguide.database.model.Iscrizione;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		cliente.setAutoscuola(a);
		cliente.setDataCreazione(new Date());
		ClienteDao clienteDao = daoFactory.getClienteDao();
		clienteDao.save(cliente);
	}
	
	// Get List
	public List<CustomerBean> getList() {
		ClienteDao dao = daoFactory.getClienteDao();
		List<Cliente> customers = dao.findAll();
		
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		List<Autoscuola> schools = autoscuolaDao.findAll();
		List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();
		for(Autoscuola a: schools)
			schoolBeans.add(BeanConverter.toSchoolBean(a));			
		
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
		
		List<RegistrationBean> registrations = new ArrayList<RegistrationBean>();
		for(Iscrizione i: c.getIscriziones())
			registrations.add(BeanConverter.toRegistrationBean(i));
		
		CustomerBean bean = BeanConverter.toCustomerBean(c);
		bean.setRegistrations(registrations);
		return bean;
	}
	
	// Delete
	public void delete(Integer id) {
		ClienteDao dao = daoFactory.getClienteDao();
		dao.delete(id);
	}
	
}
