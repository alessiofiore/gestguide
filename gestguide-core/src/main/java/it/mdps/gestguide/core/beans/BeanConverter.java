package it.mdps.gestguide.core.beans;

import it.mdps.gestguide.common.EncodingValues.Fuel;
import it.mdps.gestguide.database.model.AbilitazioneIstruttore;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Cliente;
import it.mdps.gestguide.database.model.Iscrizione;
import it.mdps.gestguide.database.model.Istruttore;
import it.mdps.gestguide.database.model.Mezzo;
import it.mdps.gestguide.database.model.Patente;
import it.mdps.gestguide.database.model.Prenotazione;

public class BeanConverter {
	
	public static VehicleBean toVehicleBean(Mezzo m) {
		VehicleBean bean = new VehicleBean();
		bean.setId(m.getIdMezzo());
		bean.setAlimentazione(m.getAlimentazione().ordinal());
		bean.setMarca(m.getMarca());
		bean.setModello(m.getModello());
		bean.setRimorchio(m.getRimorchio());
		bean.setStato(m.getStato());
		bean.setTarga(m.getTarga());
		bean.setTempoCambio(m.getTempoCambio());
		bean.setTipo(m.getTipo());
		bean.setSchoolName(m.getAutoscuola().getNome());
		return bean;
	}
	
	public static Mezzo fromVehicleBean(VehicleBean bean) {
		Mezzo m = new Mezzo();
		if(bean.getId() != null)
			m.setIdMezzo(bean.getId());
		m.setMarca(bean.getMarca());
		m.setModello(bean.getModello());
		m.setRimorchio(bean.getRimorchio());
		m.setStato(bean.getStato());
		m.setTarga(bean.getTarga());
		m.setTempoCambio(bean.getTempoCambio());
		m.setTipo(bean.getTipo());
		
		switch (bean.getAlimentazione()) {
		case 0:
			m.setAlimentazione(Fuel.GASOLINE);
			break;
		case 1:
			m.setAlimentazione(Fuel.DIESEL);
			break;
		case 2:
			m.setAlimentazione(Fuel.GPL);
			break;
		case 3:
			m.setAlimentazione(Fuel.METHANE);
			break;
		default:
			throw new IllegalArgumentException("Unsopported fuel");
		}
		return m;
	}
	
	public static InstructorBean toInstructorBean(Istruttore i) {
		InstructorBean bean = new InstructorBean();
				
		bean.setAddress(i.getIndirizzo());
		bean.setCity(i.getCitta());
		bean.setDateOfBirth(i.getDataNascita());
		bean.setEmail(i.getEmail());
		bean.setFirstName(i.getNome());
		bean.setHiringDate(i.getDataAssunzione());
		bean.setId(i.getIdIstruttore());
		bean.setLastName(i.getCognome());
		bean.setMobilePhone(i.getCellulare());
		bean.setPhone(i.getTelefono());
		bean.setProvince(i.getProvincia());
		bean.setSocialSecurityNumber(i.getCodiceFiscale());
		bean.setZipCode(i.getCap());
		
		Autoscuola a = i.getAutoscuola();
		bean.setSchoolId(a.getIdAutoscuola());
		bean.setSchoolName(a.getNome());
		return bean;
	}
	
	public static Istruttore fromInstructorBean(InstructorBean bean) {
		Istruttore c = new Istruttore();
		c.setCap(bean.getZipCode());
		c.setCellulare(bean.getMobilePhone());
		c.setCitta(bean.getCity());
		c.setCodiceFiscale(bean.getSocialSecurityNumber());
		c.setCognome(bean.getLastName());
		c.setDataNascita(bean.getDateOfBirth());
		c.setDataAssunzione(bean.getHiringDate());
		c.setEmail(bean.getEmail());
		if(bean.getId() != null)
			c.setIdIstruttore(bean.getId());
		c.setIndirizzo(bean.getAddress());
		c.setNome(bean.getFirstName());
		c.setProvincia(bean.getProvince());
		c.setTelefono(bean.getPhone());		
		return c;
	}
	
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
		if(bean.getId() != null)
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
		
		Autoscuola a = c.getAutoscuola();
		bean.setSchoolId(a.getIdAutoscuola());
		bean.setSchoolName(a.getNome());
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
		if(bean.getId() != null)
			c.setIdCliente(bean.getId());
		c.setIndirizzo(bean.getAddress());
		c.setNome(bean.getFirstName());
		c.setProvincia(bean.getProvince());
		c.setTelefono(bean.getPhone());		
		return c;
	}
	
	public static LicenseBean toLicenseBean(AbilitazioneIstruttore a) {
		LicenseBean licenseBean = new LicenseBean();
		licenseBean.setId(a.getPatente().getIdPatente());
		licenseBean.setCategory(a.getPatente().getCategoria());
		licenseBean.setCostPerHour(a.getCostoOra());
		return licenseBean;
	}
	
	public static LicenseBean toLicenseBean(Patente p) {
		LicenseBean licenseBean = new LicenseBean();
		licenseBean.setId(p.getIdPatente());
		licenseBean.setCategory(p.getCategoria());
		return licenseBean;
	}
	
	public static RegistrationBean toRegistrationBean(Iscrizione i) {
		RegistrationBean bean = new RegistrationBean();
		bean.setId(i.getIdIscrizione());
		bean.setLicenseId(i.getPatente().getIdPatente());
		bean.setLicenseCategory(i.getPatente().getCategoria());
		bean.setRegistrationDate(i.getData());
		bean.setSchoolId(i.getAutoscuola().getIdAutoscuola());
		bean.setSchoolName(i.getAutoscuola().getNome());
		return bean;
	}

	
	public static ReservationBean toReservationBean(Prenotazione p) {
		ReservationBean bean = new ReservationBean();
		bean.setInstructorId(p.getIstruttore().getIdIstruttore());
		bean.setVehicleId(p.getMezzo().getIdMezzo());
		bean.setRegistrationId(p.getIdPrenotazione());
		bean.setStartDate(p.getDataInizio());
		bean.setEndDate(p.getDataFine());
		Cliente c = p.getIscrizione().getCliente();
		bean.setTitle(c.getNome() + " " + c.getCognome());
		return bean;
	}
}
