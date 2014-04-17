package it.mdps.gestguide.database.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public abstract class GenericDao<T> implements IGenericDao<T> {

	@Resource(name = "sessionFactory")
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T save(T t) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.save(t);
	}
	
	@Override
	@Transactional
	public void saveOrUpdate(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public T find(Class<T> type, Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(type, id);
	}

	@Override
	@Transactional
	public T update(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public abstract void delete(Object id);

	@Override
	public abstract List<T> findAll();

}
