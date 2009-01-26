package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.InboxController;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class HeaderPanel extends Composite {
	private HorizontalPanel headerPanel;

	public HeaderPanel() {
		headerPanel = new HorizontalPanel ();
		headerPanel.setStyleName("headerPanel");
		final Label label = new Label ();
		label.setStyleName("mainPanel-header");

		initWidget(headerPanel);
	}
	
	public void onHistoryChanged(String historyToken) {
		if (!"Login".equals (historyToken)) {
			Label greeting = new Label ();
			
			headerPanel.add(new Label ("Mysha header panel"));
			headerPanel.add(greeting);
			InboxController.addUserNameToHeader(greeting);
		}
	}
}
