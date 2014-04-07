package it.mdps.gestguide.core.beans;

import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Cliente;

public class BeanConverter {
	
	public static SchoolBean toSchoolBean(Autoscuola a) {
		SchoolBean bean = new SchoolBean();
		bean.setCap(a.getCap());
		bean.setCitta(a.getCitta());
		bean.setEmail(a.getEmail());
		bean.setFax(a.getFax());
		bean.setId(a.getIdAutoscuola());
		bean.setIndirizzo(a.getIndirizzo());
		bean.setNomeSede(a.getNome());
		bean.setProvincia(a.getProvincia());
		bean.setTelefono(a.getTelefono());
		
		return bean;
	}
	
	public static Autoscuola fromSchoolBean(SchoolBean bean) {
		Autoscuola a = new Autoscuola();		
		a.setCap(bean.getCap());
		a.setCitta(bean.getCitta());
		a.setEmail(bean.getEmail());
		a.setFax(bean.getFax());
		a.setIdAutoscuola(bean.getId());
		a.setIndirizzo(bean.getIndirizzo());
		a.setNome(bean.getNomeSede());
		a.setProvincia(bean.getProvincia());
		a.setTelefono(bean.getTelefono());		
		return a;
	}
	
	public static CustomerBean toCustomerBean(Cliente c) {
		CustomerBean bean = new CustomerBean();
		
		bean.setAddress(c.getIndirizzo());
		bean.setCity(c.getCitta());
		bean.setCreationDate(c.getDataCreazione());
		bean.setDateOfBirth(c.getDataNascita());
		bean.setEmail(c.getEmail());
		bean.setFirstName(c.getNome());
		bean.setId(c.getIdCliente());
		bean.setLastName(c.getCognome());
		bean.setMobilePhone(c.getCellulare());
		bean.setPhone(c.getTelefono());
		bean.setProvince(c.getProvincia());
		bean.setSocialSecurityNumber(c.getCodiceFiscale());
		bean.setZipCode(c.getCap());		
		return bean;
	}
	
	public static Cliente fromCustomerBean(CustomerBean bean) {
		Cliente c = new Cliente();
		c.setCap(bean.getZipCode());
		c.setCellulare(bean.getMobilePhone());
		c.setCitta(bean.getCity());
		c.setCodiceFiscale(bean.getSocialSecurityNumber());
		c.setCognome(bean.getLastName());
		c.setDataCreazione(bean.getCreationDate());
		c.setDataNascita(bean.getDateOfBirth());
		c.setEmail(bean.getEmail());
		c.setIdCliente(bean.getId());
		c.setIndirizzo(bean.getAddress());
		c.setNome(bean.getFirstName());
		c.setProvincia(bean.getProvince());
		c.setTelefono(bean.getPhone());		
		return c;
	}

}
