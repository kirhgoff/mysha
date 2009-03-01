package org.kirhgoff.mysha.client.controllers;

import java.util.HashMap;
import java.util.Map;

import org.kirhgoff.mysha.client.StatefulPanel;

import com.google.gwt.user.client.ui.Widget;

public class StatefulPanelController {

	private Map<String, Widget> widgets = new HashMap<String, Widget>();
	private StatefulPanel panel;
	
	public StatefulPanelController(StatefulPanel panel) {
		this.panel = panel;
	}
	
	public void setState(String text) {
		System.out.println ("StatefulPanelController.setState " + text);
		Widget widget = widgets.get(text);
		panel.show(widget);
	}

	public void registerWidget(String string, Widget widget) {
		widgets.put (string, widget);
	}
}
