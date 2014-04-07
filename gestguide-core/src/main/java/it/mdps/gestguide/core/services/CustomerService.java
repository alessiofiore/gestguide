package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.CustomerBean;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.ClienteDao;
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
		ClienteDao.create(cliente);
	}
	
	public List<CustomerBean> getCustomers() {
		ClienteDao ClienteDao = daoFactory.getClienteDao();
		List<Cliente> Customers = ClienteDao.findAll();
		
		List<CustomerBean> CustomerBeans = new ArrayList<CustomerBean>();		
		for(Cliente c: Customers) {
			CustomerBeans.add(BeanConverter.toCustomerBean(c));
		}
		
		return CustomerBeans;
	}
	
}
