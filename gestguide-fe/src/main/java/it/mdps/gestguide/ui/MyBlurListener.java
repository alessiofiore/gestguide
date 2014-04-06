package it.mdps.gestguide.ui;

import com.vaadin.event.FieldEvents.BlurEvent;
import com.vaadin.event.FieldEvents.BlurListener;
import com.vaadin.ui.DateField;

public class MyBlurListener implements BlurListener{

	private static final long serialVersionUID = 3221669038961222492L;

	@Override
	public void blur(BlurEvent event) {
		DateField df = (DateField) event.getComponent();
		System.out.println(df.getValue());
	}

}
