package it.mdps.gestguide.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.model.Istruttore;

@Component
@Scope("prototype")
public class IstruttoreDaoImpl extends GenericDao<Istruttore> implements IstruttoreDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Istruttore> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Istruttore.findAll");
		
		return query.list();
	}
	

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Istruttore where idIstruttore = :id");
		q.setLong("id", (Long) id);
		q.executeUpdate();
	}
}
