package it.mdps.gestguide.database.dao.hibernate;

import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.dao.PrenotazioneDao;
import it.mdps.gestguide.database.model.Prenotazione;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

public class PrenotazioneDaoImpl extends GenericDao<Prenotazione> implements PrenotazioneDao {

	@Override
	public void delete(Object id) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Prenotazione> findBySchool(int schoolId) {
		Session session = super.sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Prenotazione.class);
		c.add(Restrictions.eq("autoscuola.idAutoscuola", schoolId));
		return c.list();
	}

	@Override
	public List<Prenotazione> findAll() {
//		Session session = super.sessionFactory.getCurrentSession();
//		Query query = session.getNamedQuery("Prenotazione.findAll");		
		return null;
	}

	
}
