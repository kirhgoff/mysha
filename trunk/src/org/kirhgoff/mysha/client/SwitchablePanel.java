package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.SwitchablePanelController;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DeckPanel;
import com.google.gwt.user.client.ui.Widget;

public class SwitchablePanel extends Composite {
	
	private final DeckPanel layout;
	private SwitchablePanelController switchableController;
	
	public SwitchablePanel() {
		layout = new DeckPanel ();
		layout.setStyleName("activePanel");

		switchableController = new SwitchablePanelController(this);
		
		initWidget (layout);
	}

	//actually a controller method
	public void show(Widget widget) {
		System.out.println("StatefulPanel.show widgets number = " + layout.getWidgetCount());
		while (layout.getWidgetCount() != 0)
			layout.remove(0);
		
		layout.insert(widget, 0);
		layout.showWidget(0);
		
	}
	
	public void add (String stateName, Widget widget) {
		switchableController.registerWidget(stateName, widget);
	} 

	public void add (String stateName, Widget widget, boolean isDefault) {
		switchableController.registerWidget(stateName, widget, isDefault);
	} 
	
/*	public void oldCreateOrShow(Widget widget) {
		System.out.println("StatefulPanel.createOrShow widgets number = " + layout.getWidgetCount());
		if(widget == null) return;//TODO
		int widgetIndex = layout.getWidgetIndex(widget);
		if (widgetIndex != -1) layout.showWidget(widgetIndex);
		else {
			layout.insert(widget, 0);
			layout.showWidget(0);
		}
	}
	*/
	
	public SwitchablePanelController getSwitchableController () {
		return switchableController;
	}
}
