package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.gui.workflow.WorkflowPanel;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class MainPanel extends Composite {
	private SwitchablePanel activePanel;
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
		
		activePanel = new SwitchablePanel ();
		activePanel.add ("inbox", new InboxPanel ());
		activePanel.add ("new project", new NewProjectPanel ());
		activePanel.add ("sandbox", new SandboxPanel (), true);
		activePanel.add ("workflow", new WorkflowPanel (), true);
		
		menuPanel = new MenuPanel (activePanel.getSwitchableController());
		copyrightPanel = new CopyrightPanel ();

		mainPanel.add(headerPanel, DockPanel.NORTH);
		mainPanel.add(statusPanel, DockPanel.NORTH);
		mainPanel.add(menuPanel, DockPanel.WEST);
		mainPanel.add(activePanel, DockPanel.CENTER);
		mainPanel.add(copyrightPanel, DockPanel.SOUTH);
		
		initWidget(mainPanel);
	}
	
	public Label getMessageLabel () {
		return statusPanel.getMessageLabel ();
	}
}