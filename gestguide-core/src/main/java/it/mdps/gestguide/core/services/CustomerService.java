package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.CustomerBean;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.ClienteDao;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Cliente;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class CustomerService {

	@Autowired
	private DaoFactory daoFactory;
	
	public void addCustomer(CustomerBean bean) {
		Cliente cliente = BeanConverter.fromCustomerBean(bean);
		
		ClienteDao ClienteDao = daoFactory.getClienteDao();
		ClienteDao.save(cliente);
	}
	
	public List<CustomerBean> getCustomers() {
		ClienteDao clienteDao = daoFactory.getClienteDao();
		List<Cliente> customers = clienteDao.findAll();
		
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		List<Autoscuola> schools = autoscuolaDao.findAll();
		List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();
		for(Autoscuola a: schools)
			schoolBeans.add(BeanConverter.toSchoolBean(a));			
		
		List<CustomerBean> customerBeans = new ArrayList<CustomerBean>();		
		for(Cliente c: customers) {
			CustomerBean bean = BeanConverter.toCustomerBean(c);
			
			
		}
		
		return customerBeans;
	}
	
}
