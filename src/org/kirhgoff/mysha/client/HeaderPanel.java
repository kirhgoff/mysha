package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.AuthController;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class HeaderPanel extends Composite {
	private DockPanel headerPanel;

	public HeaderPanel() {
		createPanel();

		initWidget(headerPanel);
	}

	private void createPanel() {
		headerPanel = new DockPanel ();
		headerPanel.setStyleName("headerPanel");
		headerPanel.setWidth("100%");

		Label title = new Label ("Mysha");
		title.setStyleName("headerPanel-title");
		headerPanel.add(title, DockPanel.CENTER);
		
		Label greeting = new Label ();
		greeting.setStyleName ("headerPanel-greeting");
		headerPanel.add(greeting, DockPanel.EAST);
		
		AuthController.addUserNameToHeader(greeting);		
	}
}
