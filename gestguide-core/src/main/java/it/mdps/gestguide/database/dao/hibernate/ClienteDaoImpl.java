package it.mdps.gestguide.database.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.dao.ClienteDao;
import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.model.Cliente;

@Component
@Scope("prototype")
public class ClienteDaoImpl extends GenericDao<Cliente> implements ClienteDao {

	@Override
	@Transactional(readOnly=true)
	public List<Cliente> findAll() {
				
		return null;
	}

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Cliente where idCliente = :id");
		q.setInteger("id", (Integer) id);
		q.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAll(int schoolId) {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Cliente.findAll");
		query.setInteger("schoolId", schoolId);
		return query.list();
	}
}
