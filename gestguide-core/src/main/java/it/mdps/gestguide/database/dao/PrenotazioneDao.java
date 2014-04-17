package it.mdps.gestguide.database.dao;

import java.util.List;

import it.mdps.gestguide.database.model.Prenotazione;

public interface PrenotazioneDao extends IGenericDao<Prenotazione> {

	public List<Prenotazione> findBySchool(int schoolId);
}
