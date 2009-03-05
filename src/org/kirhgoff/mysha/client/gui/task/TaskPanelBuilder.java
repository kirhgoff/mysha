package org.kirhgoff.mysha.client.gui.task;

import java.util.Map;

import org.kirhgoff.mysha.client.controllers.Action;
import org.kirhgoff.mysha.client.gui.workflow.WorkflowOperations;
import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TaskPanelBuilder {

	protected Widget createControlPanel(final TaskPanel taskPanel) {
		VerticalPanel panel = new VerticalPanel ();
		//not good - probably better move cotroller calls to panel itself
		Action action = taskPanel.getSwitchableController().getActionByName("Edit");
		System.out.println ("TaskPanelBuilder.createControlPanel Edit action=" + action);
		panel.add(createButton(taskPanel, "Edit", action));
		panel.add(new HTML ("<p/>"));
		
		Map<String, Action> transitionsForTask = WorkflowOperations.getTransitionsForTask (taskPanel.getTask());
		for (String transitionName : transitionsForTask.keySet()) {
			panel.add(createButton(taskPanel, transitionName, transitionsForTask.get(transitionName)));	
		}
		
		return panel;
	}

	protected Widget createButton(final TaskPanel taskPanel, final String actionName, Action action) {
		Label label = new Label(actionName);
		label.setStyleName(taskPanel.getMainStyle() + "-button");
		taskPanel.getOperationsController().add(actionName, action); 
		taskPanel.getOperationsController().createTriggerForClick (actionName, label);
		return label;
	}

	protected Widget createTaskBodyPanel(TaskPanel taskPanel) {
		VerticalPanel taskBodyPanel = new VerticalPanel ();
		Label titleLabel = new Label();
		taskPanel.getOperationsController ().registerTitleLabel (titleLabel);
		titleLabel.setStyleName(taskPanel.getMainStyle() + "-titleLabel");
		taskBodyPanel.add (titleLabel);
		taskBodyPanel.setWidth("100%");
		return taskBodyPanel;
	}

	protected Widget createCommonInfoPanel(TaskPanel taskPanel) {
		VerticalPanel commonInfoPanel = new VerticalPanel ();
		Task task = taskPanel.getTask ();
		
		Label idLabel = new Label(task.getID());
		Label typeLabel = new Label ("Type: " + task.getType());
		Label statusLabel = new Label ("Status: " + task.getStatus ());
		
		commonInfoPanel.add(idLabel);
		commonInfoPanel.add(typeLabel);
		commonInfoPanel.add (statusLabel);
		
		String mainStyle = taskPanel.getMainStyle();
		statusLabel.setStyleName(mainStyle + "-statusLabel");
		idLabel.setStyleName(mainStyle + "-idLabel");
		typeLabel.setStyleName(mainStyle + "-typeLabel");
		return commonInfoPanel;
	}

}
