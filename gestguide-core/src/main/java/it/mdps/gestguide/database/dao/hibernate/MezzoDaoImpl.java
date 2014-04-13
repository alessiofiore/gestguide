package it.mdps.gestguide.database.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.dao.MezzoDao;
import it.mdps.gestguide.database.model.Mezzo;

@Component
@Scope("prototype")
public class MezzoDaoImpl extends GenericDao<Mezzo> implements MezzoDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Mezzo> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Mezzo.findAll");
		
		return query.list();
	}

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Mezzo where idMezzo = :id");
		q.setInteger("id", (Integer) id);
		q.executeUpdate();
	}
}
