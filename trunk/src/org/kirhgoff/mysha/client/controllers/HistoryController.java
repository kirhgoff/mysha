package org.kirhgoff.mysha.client.controllers;

import org.kirhgoff.mysha.client.InboxPanel;
import org.kirhgoff.mysha.client.LoginPanel;
import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.client.interfaces.AuthServiceAsync;
import org.kirhgoff.mysha.domain.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class HistoryController {

	private final DeckPanel layout;

	public HistoryController(DeckPanel layout) {
		this.layout = layout;
	}

	public void onHistoryChanged(String historyToken) {
		if ("Inbox".equals (historyToken)) {
			insertWidget(new InboxPanel ());
		}
		else {
	        checkUserIsAlreadyLogged ();
			insertWidget(new LoginPanel ());
		}
		
	}

	private void insertWidget(Widget widget) {
		if(widget == null) return;//TODO
		int widgetIndex = layout.getWidgetIndex(widget);
		if (widgetIndex != -1) layout.showWidget(widgetIndex);
		else {
			layout.insert(widget, 0);
		}
		layout.showWidget(0);
	}
	
	public void checkUserIsAlreadyLogged() {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.getUser(new AsyncCallback<User>() {
			public void onSuccess(User result) {
				if (result != null)
					History.newItem("Inbox");
			}
		
			public void onFailure(Throwable caught) {
				History.newItem("Login");
			}
		});
		
	}

}
