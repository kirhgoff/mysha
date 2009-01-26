package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class StatusPanel extends Composite {
	private Label messageLabel = new Label ("");

	public StatusPanel() {
		HorizontalPanel panel = new HorizontalPanel ();
		panel.add(messageLabel);
		initWidget(panel);
	}

	public Label getMessageLabel() {
		return messageLabel;
	}
	
}
