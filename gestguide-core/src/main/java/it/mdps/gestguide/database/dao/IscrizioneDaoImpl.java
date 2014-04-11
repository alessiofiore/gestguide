package it.mdps.gestguide.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.model.Iscrizione;

@Component
@Scope("prototype")
public class IscrizioneDaoImpl extends GenericDao<Iscrizione> implements IscrizioneDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Iscrizione> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Iscrizione.findAll");
		
		return query.list();
	}

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Iscrizione where idIscrizione = :id");
		q.setLong("id", (Long) id);
		q.executeUpdate();
	}
}
