package it.mdps.gestguide.ui.components;

import it.mdps.gestguide.common.StaticValues;
import it.mdps.gestguide.core.beans.SchoolBean;
import it.mdps.gestguide.ui.services.UIFacade;

import java.util.List;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Container.Filter;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.AbstractTextField.TextChangeEventMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
@SuppressWarnings("serial")
public class SchoolComponent extends CustomComponent {

	// Table
	private Table table;
	private BeanItemContainer<SchoolBean> tableBeanContainer;
	private TextField searchField = new TextField();

	private Button addNewButton = new Button(StaticValues.BUTTON_NEW);
	private Button removeButton = new Button(StaticValues.BUTTON_CANCEL);
	private Button saveButton = new Button(StaticValues.BUTTON_SAVE);

	// Form
	private SchoolFormLayout formLayout = new SchoolFormLayout();
	private BeanFieldGroup<SchoolBean> formFieldGroup;

	private UIFacade uiFacade;

	public SchoolComponent(UIFacade uiFacade) {
		this.uiFacade = uiFacade;

		initLayout();
		initForm();
		initButtons();
		//		initSearch();
	}

	private void initLayout() {
		HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
		setCompositionRoot(splitPanel);

		VerticalLayout leftLayout = new VerticalLayout();
		initTable();
		leftLayout.addComponent(table);
		splitPanel.addComponent(leftLayout);

		splitPanel.addComponent(formLayout);

		// Left
		HorizontalLayout bottomLeftLayout = new HorizontalLayout();
		leftLayout.addComponent(bottomLeftLayout);
		bottomLeftLayout.addComponent(searchField);
		bottomLeftLayout.addComponent(addNewButton);

		leftLayout.setSizeFull();
		leftLayout.setExpandRatio(table, 1);

		bottomLeftLayout.setWidth("100%");
		searchField.setWidth("100%");

		bottomLeftLayout.setExpandRatio(searchField, 1);
	}

	private void initForm() {

		formFieldGroup = formLayout.getBeanFieldGroup();
		formFieldGroup.addCommitHandler(new AddCommitHandler());
		
		// bind form field to bean attribute
		//		formLayout.addComponent(formFieldGroup.buildAndBind(StaticValues.NOME_SEDE, StaticValues.NOME_SEDE));
		//		formLayout.addComponent(formFieldGroup.buildAndBind(StaticValues.CITTA, StaticValues.CITTA));

		HorizontalLayout buttonBarLayout = new HorizontalLayout();
		buttonBarLayout.addComponent(removeButton);
		buttonBarLayout.addComponent(saveButton);

		formLayout.addComponent(buttonBarLayout);

		formLayout.setMargin(true);
		formLayout.setVisible(false);
	}

	private void initTable() {
		List<SchoolBean> schools = uiFacade.getSchools();

		tableBeanContainer = new BeanItemContainer<SchoolBean>(SchoolBean.class);
		tableBeanContainer.addAll(schools);

		table = new Table("Scuole", tableBeanContainer);
		table.setSelectable(true);
		table.setImmediate(true);
		//		table.setVisibleColumns(new String[] {StaticValues.ID, StaticValues.NOME_SEDE, StaticValues.CITTA });

		// executed when an element is selected from the list and show that in the editor on the right
		table.addValueChangeListener(new Property.ValueChangeListener() {
			public void valueChange(ValueChangeEvent event) {
				Object contactId = table.getValue();
				if(contactId != null) {
					formFieldGroup.setItemDataSource(table.getItem(contactId));
					formLayout.setVisible(true);
				}
			}
		});
	}

	/*
	 * ----------------------------------------------------------------------------
	 * Initialize button listeners
	 * ----------------------------------------------------------------------------
	 */

	private void initButtons() {
		// Add button
		addNewButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				SchoolBean schoolBean = new SchoolBean();
				schoolBean.setNomeSede("Inserisci nome sede");
				schoolBean.setCitta("Inserisci città");

				formFieldGroup.setItemDataSource(schoolBean);
				formLayout.setVisible(true);
				//				AddSchoolWindow subWindow = new AddSchoolWindow(uiFacade);				
				//				UI.getCurrent().addWindow(subWindow);			
			}
		});

		// Remove button
		removeButton.addClickListener(new ClickListener() {
			public void buttonClick(ClickEvent event) {
				Object contactId = table.getValue();
				table.removeItem(contactId);
			}
		});

		// Save button
		saveButton.addClickListener(new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					formFieldGroup.commit();
				} catch (CommitException e) {
					Notification.show("KO!");
				}
			}
		});
	}
	/* ---------------------------------------------------------------------------- */



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
				tableBeanContainer.removeAllContainerFilters();
				tableBeanContainer.addContainerFilter(new ContactFilter(event.getText()));
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
			String haystack = ("" + item.getItemProperty(StaticValues.NOME_SEDE).getValue()
					+ item.getItemProperty(StaticValues.CITTA).getValue()).toLowerCase();
			return haystack.contains(needle);
		}

		public boolean appliesToProperty(Object id) {
			return true;
		}
	}

	/* ---------------------------------------------------------------------------- */


	/* 
	 * ----------------------------------------------------------------------------
	 * Binder commit handler
	 * ----------------------------------------------------------------------------
	 */
	
	private class AddCommitHandler implements CommitHandler {

		@Override
		public void preCommit(CommitEvent commitEvent) throws CommitException {
			
		}

		@SuppressWarnings("unchecked")
		@Override
		public void postCommit(CommitEvent commitEvent) throws CommitException {			
			SchoolBean bean = ((BeanFieldGroup<SchoolBean>) commitEvent.getFieldBinder()).getItemDataSource().getBean();
			uiFacade.addSchool(bean);
			Notification.show(bean.getNomeSede() + "aggiunto");
			
			// refresh table
			BeanItem<SchoolBean> item = tableBeanContainer.addBean(bean);			
			table.select(item);
		}

	}

	/* ---------------------------------------------------------------------------- */


}
