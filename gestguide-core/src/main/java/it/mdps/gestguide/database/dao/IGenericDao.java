package it.mdps.gestguide.database.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T> {
	
	T save(T t);
	
	void saveOrUpdate(T o);
	
	<O extends Object> void delete(O id);
	
	T find(Class<T> type, Serializable id);
	
	T update(T t);
	
	List<T> findAll();
}
