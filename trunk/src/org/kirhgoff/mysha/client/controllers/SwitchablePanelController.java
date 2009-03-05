package org.kirhgoff.mysha.client.controllers;

import java.util.HashMap;
import java.util.Map;

import org.kirhgoff.mysha.client.SwitchablePanel;

import com.google.gwt.user.client.ui.Widget;

public class SwitchablePanelController implements Controller {

	private Map<String, Widget> widgets = new HashMap<String, Widget>();
	private SwitchablePanel panel;
	
	public SwitchablePanelController(SwitchablePanel panel) {
		this.panel = panel;
	}
	
	public void setState(String text) {
		System.out.println ("StatefulPanelController.setState " + text);
		Widget widget = widgets.get(text);
		panel.show(widget);
	}

	public void registerWidget(String string, Widget widget, boolean isDefault) {
		widgets.put (string, widget);
		if (isDefault) setState (string);
	}	
	
	public void registerWidget(String string, Widget widget) {
		registerWidget(string, widget, false);
	}
	
	public Map<String, Action> getActions () {
		Map<String, Action> actions = new HashMap<String, Action> ();
		
		for (String state : widgets.keySet()) {
			actions.put(state, new StateChangeAction (state));
		}
		return actions;
	}

	public Action getActionByName(String name) {
		return new StateChangeAction (name);
	}	
	
	class StateChangeAction implements Action {
		private String newState;
		
		public StateChangeAction(String state) {
			newState = state;
		}

		public void invoke() {
			System.out.println ("StateChangeAction.invoke " + newState);
			SwitchablePanelController.this.setState(newState);
		}
	}

}
