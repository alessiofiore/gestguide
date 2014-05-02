package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.IstruttoreDao;
import it.mdps.gestguide.database.dao.PrenotazioneDao;
import it.mdps.gestguide.database.model.Istruttore;
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
}
