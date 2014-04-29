package it.mdps.gestguide.database.dao;

import it.mdps.gestguide.database.model.Istruttore;

import java.util.Date;
import java.util.List;

public interface IstruttoreDao extends IGenericDao<Istruttore> {

	public List<Istruttore> findAll(int schoolId);
	
	public List<Istruttore> getInstructors(int schoolId, Date fromDate, Date toDate);
}
