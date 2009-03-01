package org.kirhgoff.mysha.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class StatefulPanel extends Composite {
	
	private final DeckPanel layout;
	
	public StatefulPanel() {
		layout = new DeckPanel ();
		layout.setStyleName("activePanel");
		
		initWidget (layout);
	}

	public void show(Widget widget) {
		System.out.println("StatefulPanel.createOrShow widgets number = " + layout.getWidgetCount());
		while (layout.getWidgetCount() != 0)
			layout.remove(0);
		
		layout.insert(widget, 0);
		layout.showWidget(0);
		
	}
	
	public void oldCreateOrShow(Widget widget) {
		System.out.println("StatefulPanel.createOrShow widgets number = " + layout.getWidgetCount());
		if(widget == null) return;//TODO
		int widgetIndex = layout.getWidgetIndex(widget);
		if (widgetIndex != -1) layout.showWidget(widgetIndex);
		else {
			layout.insert(widget, 0);
			layout.showWidget(0);
		}
	}
}
