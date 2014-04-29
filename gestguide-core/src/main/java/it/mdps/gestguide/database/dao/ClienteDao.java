package it.mdps.gestguide.database.dao;

import java.util.List;

import it.mdps.gestguide.database.model.Cliente;

public interface ClienteDao extends IGenericDao<Cliente> {

	public List<Cliente> findAll(int schoolId);
}
