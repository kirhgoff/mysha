package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.CustomerCreationController;
import org.kirhgoff.mysha.client.controllers.TemplateController;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class NewProjectPanel extends Composite {
	
	private ListBox customerChooser;
	private ListBox templateChooser;
	private TemplateController controller;
	//private Templa
	
	public NewProjectPanel() {
		VerticalPanel panel = new VerticalPanel ();
		Label title = new Label ("Create new project");
		//Label customerLabel = new Label ("Select customer name or ");
		//Hyperlink createCustomerHyperlink = new Hyperlink ("create new", "CreateNewCustomer"); 
		
		customerChooser = new ListBox ();
		
		//Label templateChooserLabel = new Label ("Create new project");
		templateChooser = new ListBox ();
		VerticalPanel templatePanel = new VerticalPanel ();
		
		controller = new TemplateController ();
		controller.setPanel (templatePanel);
		controller.registerCustomerChooser (customerChooser);
		controller.registerTemplateChooser (templateChooser);

		panel.add(title);
		panel.add (customerChooser);
		panel.add (templateChooser);
		panel.add(templatePanel);
		//panel.add()

		title.setStyleName("newProjectPanel-title");
		customerChooser.setStyleName("newProjectPanel-customerChooser");
		templateChooser.setStyleName("newProjectPanel-templateChooser");
		templatePanel.setStyleName("nweProjectPanel-templatePanel");
		
		
		
		initWidget (panel);
	}
}
