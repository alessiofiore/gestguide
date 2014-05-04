package it.mdps.gestguide.database.dao.hibernate;

import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.dao.PrenotazioneDao;
import it.mdps.gestguide.database.model.Prenotazione;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("prototype")
public class PrenotazioneDaoImpl extends GenericDao<Prenotazione> implements PrenotazioneDao {
	
	@Override
	public void delete(Object id) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Prenotazione> find(int schoolId, Date from, Date to) {
		Session session = super.sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(Prenotazione.class);
		c.add(Restrictions.eq("autoscuola.idAutoscuola", schoolId));
		c.add(Restrictions.ge("dataInizio", from));
		c.add(Restrictions.le("dataFine", to));
		return c.list();
	}

	@Override
	public List<Prenotazione> findAll() {
//		Session session = super.sessionFactory.getCurrentSession();
//		Query query = session.getNamedQuery("Prenotazione.findAll");		
		return null;
	}

	
}
