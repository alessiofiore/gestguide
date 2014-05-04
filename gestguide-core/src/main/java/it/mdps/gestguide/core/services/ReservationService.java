package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.core.exception.EntityNotFoundException;
import it.mdps.gestguide.core.exception.EntityNotFoundException.ErrorType;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.IscrizioneDao;
import it.mdps.gestguide.database.dao.IstruttoreDao;
import it.mdps.gestguide.database.dao.MezzoDao;
import it.mdps.gestguide.database.dao.PrenotazioneDao;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Iscrizione;
import it.mdps.gestguide.database.model.Istruttore;
import it.mdps.gestguide.database.model.Mezzo;
import it.mdps.gestguide.database.model.Prenotazione;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class ReservationService {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DaoFactory daoFactory;
	
	@Transactional
	public List<ReservationBean> getReservations(int schoolId, Date from, Date to) {
		PrenotazioneDao dao = daoFactory.getPrenotazioneDao();
		List<Prenotazione> prenotazioni = dao.find(schoolId, from, to);		
		List<ReservationBean> beans = new ArrayList<ReservationBean>();
		
		for(Prenotazione p: prenotazioni)
			beans.add(BeanConverter.toReservationBean(p));
			
		return beans;
	}
	
	public Map<Integer, String> getAvailableInstructor(int schoolId, int licenseId, Date fromDate, Date toDate) {
		Map<Integer, String> instructor = new LinkedHashMap<Integer, String>();
		
		IstruttoreDao dao = daoFactory.getIstruttoreDao();
		List<Istruttore> istruttori = dao.getAvailableInstructors(schoolId, licenseId, fromDate, toDate);
		logger.debug("Found " + istruttori.size() + " istructors");
		
		for(Istruttore i: istruttori) {
			instructor.put(i.getIdIstruttore(), i.getCognome() + " " + i.getNome());
			logger.debug("Added instructor: " + i.getCognome() + " " + i.getNome());
		}
		
		
		return instructor;
	}
	
	public Map<Integer, String> getAvailableVehicles(int schoolId, int licenseId, Date fromDate, Date toDate) {
		Map<Integer, String> vehicles = new LinkedHashMap<Integer, String>();
		
		MezzoDao dao = daoFactory.getMezzoDao();
		List<Mezzo> mezzi = dao.getAvailableVehicles(schoolId, licenseId, fromDate, toDate);
		logger.debug("Found " + mezzi.size() + " vehicles");
		
		for(Mezzo m: mezzi) {
			vehicles.put(m.getIdMezzo(), m.getMarca() + " " + m.getModello());
			logger.debug("Added vehicles: " + m.getMarca() + " " + m.getModello());
		}
		
		
		return vehicles;
	}
	
	public void addReservation(int schoolId, int subscriptionId, int instructorId, int vehicleId, Date from, Date to) {
		AutoscuolaDao aDao = daoFactory.getAutoscuolaDao();
		Autoscuola a = aDao.find(Autoscuola.class, schoolId);
		if(a == null)
			throw new EntityNotFoundException(ErrorType.SCHOOL_NOT_FOUND);
		
		IscrizioneDao iDao = daoFactory.getIscrizioneDao();
		Iscrizione i = iDao.find(Iscrizione.class, subscriptionId);
		if(i == null)
			throw new EntityNotFoundException(ErrorType.SUBSCRIPTION_NOT_FOUND);
		
		IstruttoreDao isDao = daoFactory.getIstruttoreDao();
		Istruttore is = isDao.find(Istruttore.class, instructorId);
		if(is == null)
			throw new EntityNotFoundException(ErrorType.INSTRUCTOR_NOT_FOUND);
		
		MezzoDao mDao = daoFactory.getMezzoDao();
		Mezzo m = mDao.find(Mezzo.class, vehicleId);
		if(m == null)
			throw new EntityNotFoundException(ErrorType.VEHICLE_NOT_FOUND);
				
		Prenotazione p = new Prenotazione();
		p.setAutoscuola(a);
		p.setIscrizione(i);
		p.setIstruttore(is);
		p.setMezzo(m);		
		p.setDataInizio(from);
		p.setDataFine(to);
		
		PrenotazioneDao prenDao = daoFactory.getPrenotazioneDao();
		prenDao.save(p);
	}
}
