package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TaskPanel extends Composite {
	
	protected Task task = null;

	public TaskPanel() {}
	
	public TaskPanel(Task task) {
		this.task = task;
		HorizontalPanel taskPanel = new HorizontalPanel();
		
		VerticalPanel infoPanel = new VerticalPanel ();
		infoPanel.add(createStatusPanel());
		infoPanel.add (createTaskBodyPanel(task));
		
		taskPanel.add(createCommonInfoPanel());
		taskPanel.add(infoPanel);
		

		taskPanel.setStyleName(getMainStyle());
		
		initWidget (taskPanel);
	}

	protected VerticalPanel createTaskBodyPanel(Task task) {
		VerticalPanel taskBodyPanel = new VerticalPanel ();
		Label titleLabel = new Label(task.getTitle());
		titleLabel.setStyleName(getMainStyle() + "-titleLabel");
		taskBodyPanel.add (titleLabel);
		return taskBodyPanel;
	}

	protected HorizontalPanel createStatusPanel() {
		HorizontalPanel statusPanel = new HorizontalPanel ();
		Label statusLabel = new Label (task.getStatus ());
		statusLabel.setStyleName(getMainStyle() + "-statusLabel");
		statusPanel.add(statusLabel);
		return statusPanel;
	}

	protected Widget createCommonInfoPanel() {
		VerticalPanel commonInfoPanel = new VerticalPanel ();
		Label idLabel = new Label(task.getID());
		Label typeLabel = new Label ("Type: " + task.getType());
		commonInfoPanel.add(idLabel);
		commonInfoPanel.add(typeLabel);
		idLabel.setStyleName(getMainStyle() + "-idLabel");
		typeLabel.setStyleName(getMainStyle() + "-typeLabel");
		return commonInfoPanel;
	}

	protected String getMainStyle() {
		return "taskPanel-" + task.getType();
	}

}
