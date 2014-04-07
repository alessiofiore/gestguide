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
	private AutoscuolaDao autoscuolaDao;
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
	private IscrizioneDao iscrizioneDao;
	
	@Autowired
	private IstruttoreDao istruttoreDao;
	
	@Autowired
	private MezzoDao mezzoDao;
	
	@Autowired
	private PatenteDao patenteDao;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	public AutoscuolaDao getAutoscuolaDao() {
		return autoscuolaDao; //context.getBean(AutoscuolaDao.class);
	}

	public ClienteDao getClienteDao() {
		return clienteDao;
	}

	public IscrizioneDao getIscrizioneDao() {
		return iscrizioneDao;
	}

	public IstruttoreDao getIstruttoreDao() {
		return istruttoreDao;
	}

	public MezzoDao getMezzoDao() {
		return mezzoDao;
	}

	public PatenteDao getPatenteDao() {
		return patenteDao;
	}
}
