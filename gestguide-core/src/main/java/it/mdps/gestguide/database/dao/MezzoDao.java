package it.mdps.gestguide.database.dao;

import java.util.List;

import it.mdps.gestguide.database.model.Mezzo;

public interface MezzoDao extends IGenericDao<Mezzo> {
	public List<Mezzo> findAll(int schoolId);
}
