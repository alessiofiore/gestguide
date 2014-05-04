package it.mdps.gestguide.database.dao.hibernate;

import it.mdps.gestguide.database.dao.GenericDao;
import it.mdps.gestguide.database.dao.MezzoDao;
import it.mdps.gestguide.database.model.Mezzo;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope("prototype")
public class MezzoDaoImpl extends GenericDao<Mezzo> implements MezzoDao {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Mezzo> findAll(int schoolId) {
		Session session = super.sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("Mezzo.findAll");
		query.setInteger("schoolId", schoolId);
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
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Mezzo> getAvailableVehicles(int schoolId, int licenseId, Date fromDate, Date toDate) {
		Session session = super.sessionFactory.getCurrentSession();
		
		String sql = "select * FROM Mezzo WHERE id_autoscuola = :schoolId "
				+ " AND id_mezzo in ( "
				+ "		SELECT a.id_mezzo FROM Abilitazione_Mezzo a, Mezzo m " // seleziona mezzi abilitati alla patente richiesta e appartenenti alla scuola
				+ "		WHERE m.id_autoscuola = :schoolId AND m.id_mezzo=a.id_mezzo "
				+ "		AND id_patente = :licenseId)"
				+ "	AND id_mezzo NOT IN ("
				+ "		SELECT id_mezzo FROM Prenotazione " // seleziona mezzi impegnati in quell'arco temporale
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
		query.addEntity(Mezzo.class);
		
		query.setInteger("schoolId", schoolId);
		query.setInteger("licenseId", licenseId);
		query.setDate("fromDate", fromDate);
		query.setDate("toDate", toDate);
		
		return query.list();
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Mezzo> findAll() {		
		
		return null;
	}
}
