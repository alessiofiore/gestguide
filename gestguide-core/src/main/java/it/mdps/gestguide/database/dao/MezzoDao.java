package it.mdps.gestguide.database.dao;

import it.mdps.gestguide.database.model.Mezzo;

import java.util.Date;
import java.util.List;

public interface MezzoDao extends IGenericDao<Mezzo> {
	public List<Mezzo> findAll(int schoolId);
	
	public List<Mezzo> getAvailableVehicles(int schoolId, int licenseId, Date fromDate, Date toDate);
}
