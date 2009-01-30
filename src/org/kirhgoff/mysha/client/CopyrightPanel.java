package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

public class CopyrightPanel extends Composite {
	public CopyrightPanel() {
		HorizontalPanel panel = new HorizontalPanel ();
		panel.setStyleName("copyrightPanel");
		Label label = new Label ("Created by kirhgoff [2009] version 0.1 alfa");
		label.setStyleName("copyrightPanel-label");
		panel.add(label);
		initWidget(panel);
	}
}