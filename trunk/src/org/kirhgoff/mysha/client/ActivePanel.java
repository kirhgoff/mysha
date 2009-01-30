package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.History;
import com.google.gwt.user.client.HistoryListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class ActivePanel extends Composite implements HistoryListener{
	
	private final DeckPanel layout;

	public ActivePanel() {
		layout = new DeckPanel ();
		layout.setStyleName("activePanel");
		History.addHistoryListener(this);
		initWidget (layout);
	}

	public void onHistoryChanged(String historyToken) {
		System.out.println("ActivePanel: onHistoryChanged=" + historyToken);
		if ("Inbox".equals (historyToken)) {
			insertWidget(new InboxPanel ());
		}
		else {
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
	
	
}
