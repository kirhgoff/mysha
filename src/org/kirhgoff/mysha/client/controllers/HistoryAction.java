package org.kirhgoff.mysha.client.controllers;

import com.google.gwt.user.client.History;

public class HistoryAction implements Action {
	private String command;
	public HistoryAction(String string) {
		command = string;
	}

	public void invoke() {
		History.newItem(command, false);
		History.fireCurrentHistoryState();
	}
}
