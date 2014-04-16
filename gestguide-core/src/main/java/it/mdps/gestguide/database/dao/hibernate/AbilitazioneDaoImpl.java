package it.mdps.gestguide.database.dao.hibernate;

import it.mdps.gestguide.database.dao.AbilitazioneDao;
import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.model.Abilitazione;
import it.mdps.gestguide.database.model.AbilitazionePK;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("prototype")
public class AbilitazioneDaoImpl extends GenericDao<Abilitazione> implements AbilitazioneDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Abilitazione> findAll() {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Abilitazione.findAll");
		
		return query.list();
	}

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Abilitazione where id = :id");
		q.setParameter("id", (AbilitazionePK) id);
		q.executeUpdate();
	}
}
