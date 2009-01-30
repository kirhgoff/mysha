package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class MainPanel extends Composite {
	private ActivePanel activePanel;
	private MenuPanel menuPanel;
	private HeaderPanel headerPanel;
	private StatusPanel statusPanel;
	private CopyrightPanel copyrightPanel;

	public MainPanel() {
		DockPanel mainPanel = new DockPanel ();
		mainPanel.setStyleName("mainPanel");
		
		//TODO compbine header and status together to make them be aligned on the left
		headerPanel = new HeaderPanel ();
		statusPanel = new StatusPanel ();
		menuPanel = new MenuPanel ();
		activePanel = new ActivePanel ();
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