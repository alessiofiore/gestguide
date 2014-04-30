package it.mdps.gestguide.database.dao;

import it.mdps.gestguide.database.model.Istruttore;

import java.util.Date;
import java.util.List;

public interface IstruttoreDao extends IGenericDao<Istruttore> {

	public List<Istruttore> findAll(int schoolId);
	
	public List<Istruttore> getAvailableInstructors(int schoolId, int licenseId, Date fromDate, Date toDate);
}
