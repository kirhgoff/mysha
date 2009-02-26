package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.AuthController;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class ActivePanel extends Composite implements HistoryListener{
	
	private final DeckPanel layout;

	public ActivePanel() {
		System.out.println("ActivePanel created.");
		layout = new DeckPanel ();
		layout.setStyleName("activePanel");
		History.addHistoryListener(this);
		AuthController.checkUserIsAlreadyLogged ();	
		
		initWidget (layout);
	}

	public void onHistoryChanged(String historyToken) {
		System.out.println("ActivePanel: onHistoryChanged=" + historyToken);
		if ("Inbox".equals (historyToken)) {
			createOrShow(new InboxPanel ());
		}
		else if ("AddTask".equals (historyToken)) {
			createOrShow(new NewProjectPanel ());
		}
		else if ("Sandbox".equals(historyToken)) {
			createOrShow (new SandboxPanel ());
		}
		else {
			createOrShow(new LoginPanel ());
		}
		
	}

	private void createOrShow(Widget widget) {
		if(widget == null) return;//TODO
		int widgetIndex = layout.getWidgetIndex(widget);
		if (widgetIndex != -1) layout.showWidget(widgetIndex);
		else {
			layout.insert(widget, 0);
			layout.showWidget(0);
		}
	}
	
	
}
