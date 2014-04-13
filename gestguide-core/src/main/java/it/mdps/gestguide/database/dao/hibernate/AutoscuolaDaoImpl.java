package it.mdps.gestguide.database.dao.hibernate;

import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.model.Autoscuola;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("prototype")
public class AutoscuolaDaoImpl extends GenericDao<Autoscuola> implements AutoscuolaDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Autoscuola> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Autoscuola.findAll");
		
		return query.list();
	}

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Autoscuola where idAutoscuola = :id");
		q.setInteger("id", (Integer) id);
		q.executeUpdate();
	}
}
