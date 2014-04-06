package it.mdps.gestguide.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.model.Autoscuola;

@Component
@Scope("prototype")
public class AutoscuolaDao extends GenericDao<Autoscuola> implements IAutoscuolaDao {

	@Override
	@Transactional(readOnly=true)
	public List<Autoscuola> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Autoscuola.findAll");
		
		return query.list();
	}

}
