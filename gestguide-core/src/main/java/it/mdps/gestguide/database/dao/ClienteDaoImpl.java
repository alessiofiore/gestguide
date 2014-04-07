package it.mdps.gestguide.database.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.model.Cliente;

@Component
@Scope("prototype")
public class ClienteDaoImpl extends GenericDao<Cliente> implements ClienteDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Cliente.findAll");
		
		return query.list();
	}

}
