package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.StatefulPanelController;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class MainPanel extends Composite {
	private StatefulPanel activePanel;
	private MenuPanel menuPanel;
	private HeaderPanel headerPanel;
	private StatusPanel statusPanel;
	private CopyrightPanel copyrightPanel;

	public MainPanel() {
		DockPanel mainPanel = new DockPanel ();
		mainPanel.setStyleName("mainPanel");

		//TODO combine header and status together to make them be aligned on the left
		headerPanel = new HeaderPanel ();
		statusPanel = new StatusPanel ();
		activePanel = new StatefulPanel ();

		StatefulPanelController controller = new StatefulPanelController (activePanel);
		controller.registerWidget ("inbox", new InboxPanel ());
		controller.registerWidget ("new project", new NewProjectPanel ());
		controller.registerWidget ("sandbox", new SandboxPanel ());
		
		menuPanel = new MenuPanel (controller);
		copyrightPanel = new CopyrightPanel ();

		mainPanel.add(headerPanel, DockPanel.NORTH);
		mainPanel.add(statusPanel, DockPanel.NORTH);
		mainPanel.add(menuPanel, DockPanel.WEST);
		mainPanel.add(activePanel, DockPanel.CENTER);
		mainPanel.add(copyrightPanel, DockPanel.SOUTH);
		
		initWidget(mainPanel);
		
		controller.setState ("sandbox");
	}
	
	public Label getMessageLabel () {
		return statusPanel.getMessageLabel ();
	}
}