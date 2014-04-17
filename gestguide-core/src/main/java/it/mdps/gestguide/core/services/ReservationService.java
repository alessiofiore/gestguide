package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.ReservationBean;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.PrenotazioneDao;
import it.mdps.gestguide.database.model.Prenotazione;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class ReservationService {
	
	@Autowired
	private DaoFactory daoFactory;
	
	@Transactional
	public List<ReservationBean> getReservations(int schoolId) {
		PrenotazioneDao dao = daoFactory.getPrenotazioneDao();
		List<Prenotazione> prenotazioni = dao.findBySchool(schoolId);
		
		List<ReservationBean> beans = new ArrayList<ReservationBean>();
		return null;
	}
}
