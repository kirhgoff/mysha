package org.kirhgoff.mysha.client;



import org.kirhgoff.mysha.client.controllers.CustomerCreationController;
import org.kirhgoff.mysha.client.controllers.InboxController;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class InboxPanel extends Composite {
	public InboxPanel() {

		VerticalPanel mainPanel = new VerticalPanel ();
		
		final Label label = new Label ();
		label.setStyleName("mainPanel-header");
		
		HorizontalPanel creationPanel = new HorizontalPanel ();
		TextBox firstNameBox = new TextBox ();
		TextBox secondNameBox = new TextBox ();
		Button addNewButton = new Button ("Add");

		creationPanel.add (new Label ("First name"));
		creationPanel.add(firstNameBox);
		creationPanel.add (new Label ("Surname"));
		creationPanel.add(secondNameBox);
		creationPanel.add(addNewButton);
		
		final FlexTable inboxPanel = new FlexTable ();
		inboxPanel.setStyleName("inboxTable");
		inboxPanel.setText(0, 0, "First name");
		inboxPanel.setText(0, 1, "Surname");
		inboxPanel.getRowFormatter().addStyleName(0, "inboxHeaderRow");
		inboxPanel.getCellFormatter().addStyleName(0, 0, "inboxColumn");
		inboxPanel.getCellFormatter().addStyleName(0, 1, "inboxColumn");
		
		mainPanel.add(label);
		mainPanel.add (creationPanel);
		mainPanel.add(inboxPanel);
		
		initWidget(mainPanel);
		
		CustomerCreationController customerController = new CustomerCreationController ();
		customerController.registerCreationForm (firstNameBox, secondNameBox, addNewButton);
		
		InboxController controller = new InboxController ();
		controller.loadCustomrListToTable(inboxPanel);
		controller.addUserNameToHeader(label);
	}
	
	
}
