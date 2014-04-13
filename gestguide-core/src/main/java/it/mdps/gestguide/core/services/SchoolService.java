package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.model.Autoscuola;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class SchoolService {

	@Autowired
	private DaoFactory daoFactory;
	
	public void deleteSchool(Integer id) {
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		autoscuolaDao.delete(id);
	}

	public void addSchool(SchoolBean schoolBean) {
		Autoscuola autoscuola = new Autoscuola();
		autoscuola.setCap(schoolBean.getCap());
		autoscuola.setCitta(schoolBean.getCitta());
		autoscuola.setEmail(schoolBean.getEmail());
		autoscuola.setFax(schoolBean.getFax());
		autoscuola.setIndirizzo(schoolBean.getIndirizzo());
		autoscuola.setNome(schoolBean.getNomeSede());
		autoscuola.setProvincia(schoolBean.getProvincia());
		autoscuola.setTelefono(schoolBean.getTelefono());
		autoscuola.setDataCreazione(new Date());
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		autoscuolaDao.save(autoscuola);
	}

	public List<SchoolBean> getSchools() {
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		List<Autoscuola> schools = autoscuolaDao.findAll();

		List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();

		for(Autoscuola a: schools) {
			SchoolBean bean =  new SchoolBean();
			bean.setId(a.getIdAutoscuola());
			bean.setCap(a.getCap());
			bean.setCitta(a.getCitta());
			bean.setEmail(a.getEmail());
			bean.setFax(a.getFax());
			bean.setIndirizzo(a.getIndirizzo());
			bean.setNomeSede(a.getNome());
			bean.setProvincia(a.getProvincia());
			bean.setTelefono(a.getTelefono());
			schoolBeans.add(bean);
		}

		return schoolBeans;
	}

	public SchoolBean getSchool(Integer id) {
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		Autoscuola a = autoscuolaDao.find(Autoscuola.class, id);

		List<SchoolBean> schoolBeans = new ArrayList<SchoolBean>();

		SchoolBean bean =  new SchoolBean();
		bean.setId(a.getIdAutoscuola());
		bean.setCap(a.getCap());
		bean.setCitta(a.getCitta());
		bean.setEmail(a.getEmail());
		bean.setFax(a.getFax());
		bean.setIndirizzo(a.getIndirizzo());
		bean.setNomeSede(a.getNome());
		bean.setProvincia(a.getProvincia());
		bean.setTelefono(a.getTelefono());
		schoolBeans.add(bean);

		return bean;
	}

}
