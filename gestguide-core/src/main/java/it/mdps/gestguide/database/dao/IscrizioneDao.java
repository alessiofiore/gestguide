package it.mdps.gestguide.database.dao;

import java.util.List;

import it.mdps.gestguide.database.model.Iscrizione;

public interface IscrizioneDao extends IGenericDao<Iscrizione> {
	
	public List<Iscrizione> findRegistrationsByCustomerId(int customerId);

}
