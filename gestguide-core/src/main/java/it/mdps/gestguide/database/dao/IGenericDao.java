package it.mdps.gestguide.database.dao;

import java.util.List;

public interface IGenericDao<T> {
	
	T create(T t);
	
	void delete(Object id);
	
	T find(Object id);
	
	T update(T t);
	
	List<T> findAll();
}
