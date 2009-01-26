package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MenuPanel extends Composite implements HistoryListener {
	private VerticalPanel menuPanel;

	public MenuPanel() {
		menuPanel = new VerticalPanel ();
		menuPanel.setStyleName("menuPanel");
		initWidget(menuPanel);
	}
	
	public void onHistoryChanged(String historyToken) {
		if (!"Login".equals (historyToken)) {
			menuPanel.add(new Label ("Menu"));
			menuPanel.add(new Label ("Inbox"));
			menuPanel.add(new Label ("Add task"));
		}
	}
	
	
}
