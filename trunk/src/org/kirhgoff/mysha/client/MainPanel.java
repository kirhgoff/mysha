package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;

public class MainPanel extends Composite implements HistoryListener {
	private ActivePanel activePanel;
	private MenuPanel menuPanel;
	private HeaderPanel headerPanel;
	private StatusPanel statusPanel;

	public MainPanel() {
		DockPanel mainPanel = new DockPanel ();
		
		menuPanel = new MenuPanel ();
		headerPanel = new HeaderPanel ();
		statusPanel = new StatusPanel ();
		activePanel = new ActivePanel ();
		
		mainPanel.add(headerPanel, DockPanel.NORTH);
		mainPanel.add(menuPanel, DockPanel.WEST);
		mainPanel.add(activePanel, DockPanel.CENTER);
		mainPanel.add(statusPanel, DockPanel.SOUTH);
		
		initWidget(mainPanel);
	}

	public void onHistoryChanged(String historyToken) {
		menuPanel.onHistoryChanged(historyToken);
		activePanel.onHistoryChanged(historyToken);
		headerPanel.onHistoryChanged(historyToken);
	}
	
	public Label getMessageLabel () {
		return statusPanel.getMessageLabel ();
	}
}