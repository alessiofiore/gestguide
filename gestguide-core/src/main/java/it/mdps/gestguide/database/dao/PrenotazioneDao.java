package it.mdps.gestguide.database.dao;

import it.mdps.gestguide.database.model.Prenotazione;

import java.util.Date;
import java.util.List;

public interface PrenotazioneDao extends IGenericDao<Prenotazione> {

	public List<Prenotazione> find(int schoolId, Date fromt, Date to);
}
