package org.kirhgoff.mysha.client;



import org.kirhgoff.mysha.client.controllers.InboxController;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InboxPanel extends Composite {
	public InboxPanel() {

		VerticalPanel mainPanel = new VerticalPanel ();
		
		final Label label = new Label ();
		label.setStyleName("mainPanel-header");
		
		final FlexTable panel = new FlexTable ();
		panel.setTitle("Customer list");
		panel.setText(0, 0, "First name");
		panel.setText(0, 1, "Surname");
		panel.setStyleName("inboxPanel-customerList-table");
		
		mainPanel.add(label);
		mainPanel.add(panel);
		
		initWidget(mainPanel);
		
		InboxController controller = new InboxController ();
		controller.loadCustomrListToTable(panel);
		controller.addUserNameToHeader(label);
	}
	
	
}
