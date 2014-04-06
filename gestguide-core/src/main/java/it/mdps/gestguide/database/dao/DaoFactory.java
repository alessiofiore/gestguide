package it.mdps.gestguide.database.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class DaoFactory implements ApplicationContextAware {

	private ApplicationContext context;

	@Autowired
	private IAutoscuolaDao autoscuolaDao;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	public IAutoscuolaDao getAutoscuolaDao() {
		return autoscuolaDao; //context.getBean(AutoscuolaDao.class);
	}
	
	
}
