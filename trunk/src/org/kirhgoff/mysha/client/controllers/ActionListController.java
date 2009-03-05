package org.kirhgoff.mysha.client.controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.SourcesClickEvents;
import com.google.gwt.user.client.ui.Widget;

public class ActionListController {
	private Map<String, Action> actions = new HashMap<String, Action> ();
	
	public Collection<String> getActionNames() {
		System.out.println ("ActionListController.getActionNames " + actions.keySet());
		return actions.keySet();
	}

	public void createTriggerForClick(final String actionName, SourcesClickEvents menuItem) {
		menuItem.addClickListener(new ClickActionTrigger (actionName));
	}

	public void add (String actionName, Action action) {
		System.out.println ("ActionListController.add this=" + this + " acton=" + actionName);
		actions.put(actionName, action);
	}
	
	protected Action getActionByName(String actionName) {
		System.out.println ("ActionListController.getActionByName actionName=" + actionName + " this=" + this);
		return actions.get(actionName);
	}

	public void getActionsFromTheSource(Controller source) {
		actions.putAll(source.getActions());
		System.out.println ("ActionListController.addSource " + actions.keySet());
	}

	private class ClickActionTrigger implements ClickListener  {
		private String actionName;

		public ClickActionTrigger(String actionName) {
			this.actionName = actionName;
		}
		
		public void onClick(Widget sender) {
			Action action = ActionListController.this.getActionByName (actionName);
			System.out.println ("ClickActionTrigger.onClick actionName=" + actionName + " this=" + this);
			System.out.println ("ClickActionTrigger.onClick action=" + action);
			action.invoke();
		}
	}
}
