package it.mdps.gestguide.ui.components;

import java.util.List;

import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.ui.services.UIFacade;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class SchoolComponent extends CustomComponent
{
	private Table schoolList = new Table();
	private TextField searchField = new TextField();
	private Button addNewSchoolButton = new Button("Nuovo");
	private Button removeSchoolButton = new Button("Cancella");
	private Button saveSchoolButton = new Button("Salva");
	private FormLayout editorForm = new FormLayout();
	private FieldGroup editorFields = new FieldGroup();

	private IndexedContainer schoolContainer;

	private static final String ID = "ID";
	private static final String NOME = "Nome sede";
	private static final String CITTA = "Citta";
	private static final String TELEFONO = "Telefono";
	private static final String FAX = "Fax";
	private static final String EMAIL = "Email";
	private static final String INDIRIZZO = "Indirizzo";
	private static final String PROVINCIA = "Provincia";
	private static final String CAP = "CAP";
	
	private static final String[] fieldNames = new String[] { ID, NOME, TELEFONO, FAX, EMAIL, INDIRIZZO, CITTA, PROVINCIA, CAP};

	private UIFacade uiFacade;
	
	public SchoolComponent(UIFacade uiFacade) {
		this.uiFacade = uiFacade;		
		
		initLayout();
		initContactList();
		initEditor();
		initSearch();
		initButtons();
	}

	private void initLayout() {
		HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
		setCompositionRoot(splitPanel);

		VerticalLayout leftLayout = new VerticalLayout();
		splitPanel.addComponent(leftLayout);
		splitPanel.addComponent(editorForm);
		leftLayout.addComponent(schoolList);

		HorizontalLayout bottomLeftLayout = new HorizontalLayout();
		leftLayout.addComponent(bottomLeftLayout);
		bottomLeftLayout.addComponent(searchField);
		bottomLeftLayout.addComponent(addNewSchoolButton);

		leftLayout.setSizeFull();
		leftLayout.setExpandRatio(schoolList, 1);
		schoolList.setSizeFull();

		bottomLeftLayout.setWidth("100%");
		searchField.setWidth("100%");

		bottomLeftLayout.setExpandRatio(searchField, 1);

		editorForm.setMargin(true);

		editorForm.setVisible(false);
	}

	private void initEditor() {

		for (String fieldName : fieldNames) {
			TextField field = new TextField(fieldName);
			editorForm.addComponent(field);
			field.setWidth("200px");

			editorFields.bind(field, fieldName);
		}
		
		HorizontalLayout buttonBarLayout = new HorizontalLayout();
		buttonBarLayout.addComponent(removeSchoolButton);
		buttonBarLayout.addComponent(saveSchoolButton);
		
		editorForm.addComponent(buttonBarLayout);
		editorFields.setBuffered(false);
	}
	
	/* 
	 * ----------------------------------------------------------------------------
	 * Search
	 * ----------------------------------------------------------------------------
	 */

	private void initSearch() {
		searchField.setInputPrompt("Search contacts");
		searchField.setTextChangeEventMode(TextChangeEventMode.LAZY);
		searchField.addTextChangeListener(new TextChangeListener() {
			public void textChange(final TextChangeEvent event) {
				schoolContainer.removeAllContainerFilters();
				schoolContainer.addContainerFilter(new ContactFilter(event.getText()));
			}
		});
	}
	

	// Filter for search
	private class ContactFilter implements Filter {
		private String needle;

		public ContactFilter(String needle) {
			this.needle = needle.toLowerCase();
		}

		public boolean passesFilter(Object itemId, Item item) {
			String haystack = ("" + item.getItemProperty(NOME).getValue()
					+ item.getItemProperty(CITTA).getValue()).toLowerCase();
			return haystack.contains(needle);
		}

		public boolean appliesToProperty(Object id) {
			return true;
		}
	}
	
	/* ---------------------------------------------------------------------------- */
	
	/*
	 * ----------------------------------------------------------------------------
	 * Initialize button listeners
	 * ----------------------------------------------------------------------------
	 */

	private void initButtons() {
		// Add button
		addNewSchoolButton.addClickListener(new ClickListener() {
			@SuppressWarnings("unchecked")
			public void buttonClick(ClickEvent event) {
				
				schoolContainer.removeAllContainerFilters();
				Object contactId = schoolContainer.addItemAt(0);

				schoolList.getContainerProperty(contactId, ID).setReadOnly(true);
				schoolList.getContainerProperty(contactId, NOME).setValue("Nome");
				schoolList.getContainerProperty(contactId, CITTA).setValue("Città");

				schoolList.select(contactId);
			}
		});

		// Remove button
		removeSchoolButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				Object contactId = schoolList.getValue();
				schoolList.removeItem(contactId);
			}
		});
		
		// Save button
		saveSchoolButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				SchoolBean schoolBean = new SchoolBean();
				
				Object id = schoolList.getValue();
				schoolBean.setNome((String) schoolContainer.getContainerProperty(id, NOME).getValue());
				schoolBean.setCitta((String) schoolContainer.getContainerProperty(id, CITTA).getValue());
				schoolBean.setTelefono((String) schoolContainer.getContainerProperty(id, TELEFONO).getValue());
				schoolBean.setFax((String) schoolContainer.getContainerProperty(id, FAX).getValue());
				schoolBean.setEmail((String) schoolContainer.getContainerProperty(id, EMAIL).getValue());
				schoolBean.setIndirizzo((String) schoolContainer.getContainerProperty(id, INDIRIZZO).getValue());
				schoolBean.setProvincia((String) schoolContainer.getContainerProperty(id, PROVINCIA).getValue());
				schoolBean.setCap((String) schoolContainer.getContainerProperty(id, CAP).getValue());
				
				uiFacade.addSchool(schoolBean);
			}
		});
	}
	/* ---------------------------------------------------------------------------- */
	
	
	
	/*
	 * ----------------------------------------------------------------------------
	 * Contact list
	 * ----------------------------------------------------------------------------
	 */

	private void initContactList() {

		schoolContainer = populateSchoolList();
		
		schoolList.setContainerDataSource(schoolContainer);
		schoolList.setVisibleColumns(new String[] { NOME, CITTA });
		schoolList.setSelectable(true);
		schoolList.setImmediate(true);

		// executed when an element is selected from the list and show that in the editor on the right
		schoolList.addValueChangeListener(new Property.ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				Object contactId = schoolList.getValue();
				editorFields.setItemDataSource(schoolList.getItem(contactId));
				editorForm.setVisible(contactId != null);
			}
		});
	}

	// populate list
	@SuppressWarnings("unchecked")
	private IndexedContainer populateSchoolList() {
		IndexedContainer ic = new IndexedContainer();

		// initialize fields
		for (String p: fieldNames) {
			ic.addContainerProperty(p, String.class, "");
		}
		
		// get school list
		List<SchoolBean> schools = uiFacade.getSchools();
		
		// populate school list
		for(SchoolBean s: schools) {
			Object id = ic.addItem();
			ic.getContainerProperty(id, ID).setValue(s.getId()!=null?s.getId().toString():"");
			ic.getContainerProperty(id, ID).setReadOnly(true);
			ic.getContainerProperty(id, NOME).setValue(s.getNome()!=null?s.getNome():"");
			ic.getContainerProperty(id, CITTA).setValue(s.getCitta()!=null?s.getCitta():"");
			ic.getContainerProperty(id, TELEFONO).setValue(s.getTelefono()!=null?s.getTelefono():"");
			ic.getContainerProperty(id, FAX).setValue(s.getFax()!=null?s.getFax():"");
			ic.getContainerProperty(id, EMAIL).setValue(s.getEmail()!=null?s.getEmail():"");
			ic.getContainerProperty(id, INDIRIZZO).setValue(s.getIndirizzo()!=null?s.getIndirizzo():"");
			ic.getContainerProperty(id, PROVINCIA).setValue(s.getProvincia()!=null?s.getProvincia():"");
			ic.getContainerProperty(id, CAP).setValue(s.getCap()!=null?s.getCap():"");
		}
		
		
		return ic;
	}
	
	/* ---------------------------------------------------------------------------- */

}
