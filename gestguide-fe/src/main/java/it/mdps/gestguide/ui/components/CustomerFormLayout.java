package it.mdps.gestguide.ui.components;

import java.util.Date;

import it.mdps.gestguide.common.StaticValues;
import it.mdps.gestguide.core.beans.CustomerBean;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;

public class CustomerFormLayout extends FormLayout {
	
	private static final long serialVersionUID = 1L;

	private BeanFieldGroup<CustomerBean> beanFieldGroup = new BeanFieldGroup<CustomerBean>(CustomerBean.class);
	
	public CustomerFormLayout() {
		setSpacing(true);
		// Add the fields and bind them to bean attributes
				
		addComponent(beanFieldGroup.buildAndBind(StaticValues.ID, "id"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.NOME, "firstName"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.COGNOME, "lastName"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.CODICE_FISCALE, "socialSecurityNumber"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.DATA_NASCITA, "dateOfBirth", DateField.class));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.INDIRIZZO, "address"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.CITTA, "city"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.PROVINCIA, "province"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.CAP, "zipCode"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.TELEFONO, "phone"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.CELLULARE, "mobilePhone"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.EMAIL, "email"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.AUTOSCUOLA, "school"));
		
		// Buffer the form content
		beanFieldGroup.setBuffered(true);
	}
	
	public BeanFieldGroup<CustomerBean> getBeanFieldGroup() {
		return beanFieldGroup;
	}
}
