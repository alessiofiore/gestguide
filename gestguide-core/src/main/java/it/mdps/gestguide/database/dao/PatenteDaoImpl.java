package it.mdps.gestguide.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.model.Patente;

@Component
@Scope("prototype")
public class PatenteDaoImpl extends GenericDao<Patente> implements PatenteDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Patente> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Patente.findAll");
		
		return query.list();
	}

}
