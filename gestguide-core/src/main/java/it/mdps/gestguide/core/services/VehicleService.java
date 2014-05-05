package it.mdps.gestguide.core.services;

import it.mdps.gestguide.core.beans.BeanConverter;
import it.mdps.gestguide.core.beans.VehicleBean;
import it.mdps.gestguide.database.dao.AutoscuolaDao;
import it.mdps.gestguide.database.dao.DaoFactory;
import it.mdps.gestguide.database.dao.MezzoDao;
import it.mdps.gestguide.database.model.Autoscuola;
import it.mdps.gestguide.database.model.Mezzo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope("prototype")
public class VehicleService {

	@Autowired
	private DaoFactory daoFactory;
	
	// Add
	public void add(VehicleBean bean) {
		Mezzo entity = BeanConverter.fromVehicleBean(bean);
		
		AutoscuolaDao autoscuolaDao = daoFactory.getAutoscuolaDao();
		Autoscuola a = autoscuolaDao.find(Autoscuola.class, bean.getSchoolId());
		entity.setAutoscuola(a);
		entity.setDataCreazione(new Date());
		
		MezzoDao dao = daoFactory.getMezzoDao();
		dao.save(entity);
	}
	
	// Get List
	@Transactional(readOnly=true)
	public List<VehicleBean> getList(int schoolId) {
		MezzoDao dao = daoFactory.getMezzoDao();
		List<Mezzo> customers = dao.findAll(schoolId);
		
		List<VehicleBean> customerBeans = new ArrayList<VehicleBean>();		
		for(Mezzo c: customers) {
			VehicleBean bean = BeanConverter.toVehicleBean(c);
			customerBeans.add(bean);
		}
		
		return customerBeans;
	}
	
	// Find
	public VehicleBean get(Integer id) {
		MezzoDao dao = daoFactory.getMezzoDao();
		Mezzo c = dao.find(Mezzo.class, id);
		return BeanConverter.toVehicleBean(c);
	}
	
	// Delete
	public void delete(Integer id) {
		MezzoDao dao = daoFactory.getMezzoDao();
		dao.delete(id);
	}
	
}
