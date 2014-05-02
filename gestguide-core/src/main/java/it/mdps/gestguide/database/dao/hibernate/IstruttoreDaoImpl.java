package it.mdps.gestguide.database.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.dao.IstruttoreDao;
import it.mdps.gestguide.database.model.Istruttore;

@Component
@Scope("prototype")
public class IstruttoreDaoImpl extends GenericDao<Istruttore> implements IstruttoreDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Istruttore> findAll(int schoolId) {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Istruttore.findAll");
		query.setInteger("schoolId", schoolId);
		return query.list();
	}	

	@Override
	@Transactional
	public void delete(Object id) {
		Session session = super.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Istruttore where idIstruttore = :id");
		q.setInteger("id", (Integer) id);
		q.executeUpdate();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Istruttore> getAvailableInstructors(int schoolId, int licenseId, Date fromDate, Date toDate) {
		Session session = super.sessionFactory.getCurrentSession();
		String sql = "select * FROM Istruttore WHERE id_autoscuola = :schoolId "
				+ " AND id_istruttore in ( "
				+ "		SELECT a.id_istruttore FROM Abilitazione a, Istruttore i " // seleziona istruttori abilitati alla patente richiesta e appartenenti alla scuola
				+ "		WHERE i.id_autoscuola = :schoolId AND i.id_istruttore=a.id_istruttore "
				+ "		AND id_patente = :licenseId)"
				+ "	AND id_istruttore NOT IN ("
				+ "		SELECT id_istruttore FROM Prenotazione " // seleziona istruttori impegnati in quell'arco temporale
				+ "		WHERE id_autoscuola = :schoolId "
				+ "		AND ("
				+ "			(:fromDate BETWEEN data_inizio AND data_fine) "
				+ "			OR"
				+ "			(:toDate BETWEEN data_inizio AND data_fine)"
				+ "			OR"
				+ "			(:fromDate <= data_inizio AND :toDate >= data_fine)"
				+ "		)"
				+ ")";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Istruttore.class);
		
		query.setInteger("schoolId", schoolId);
		query.setInteger("licenseId", licenseId);
		query.setDate("fromDate", fromDate);
		query.setDate("toDate", toDate);
		
		return query.list();
	}

	@Override
	public List<Istruttore> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
