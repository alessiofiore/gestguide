package it.mdps.gestguide.ui.components;

import it.mdps.gestguide.common.StaticValues;
import it.mdps.gestguide.core.beans.SchoolBean;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.ui.FormLayout;

public class SchoolFormLayout extends FormLayout {
	
	private static final long serialVersionUID = 1L;

	private BeanFieldGroup<SchoolBean> beanFieldGroup = new BeanFieldGroup<SchoolBean>(SchoolBean.class);
	
	public SchoolFormLayout() {
		setSpacing(true);
		// Add the fields and bind them to bean attributes
		addComponent(beanFieldGroup.buildAndBind(StaticValues.ID, "id"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.NOME_SEDE, "nomeSede"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.INDIRIZZO, "indirizzo"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.CITTA, "citta"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.PROVINCIA, "provincia"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.CAP, "cap"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.TELEFONO, "telefono"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.FAX, "fax"));
		addComponent(beanFieldGroup.buildAndBind(StaticValues.EMAIL, "email"));
		
		// Buffer the form content
		beanFieldGroup.setBuffered(true);
	}
	
	public BeanFieldGroup<SchoolBean> getBeanFieldGroup() {
		return beanFieldGroup;
	}
}
