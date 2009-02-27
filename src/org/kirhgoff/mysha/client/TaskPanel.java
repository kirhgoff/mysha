package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.controllers.TaskActionsController;
import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TaskPanel extends Composite {
	
	protected Task task = null;
	protected TaskActionsController controller = new TaskActionsController ();
	
	public TaskPanel() {}
	
	public TaskPanel(Task task) {
		this.task = task;
		DockPanel taskPanel = new DockPanel();
		
		taskPanel.add(createTaskBodyPanel(task), DockPanel.CENTER);
		taskPanel.add(createCommonInfoPanel(), DockPanel.WEST);
		taskPanel.add(createControlPanel (), DockPanel.EAST);
		taskPanel.setStyleName(getMainStyle());
		
		initWidget (taskPanel);
	}

	protected Widget createControlPanel() {
		VerticalPanel panel = new VerticalPanel ();
		panel.add(createButton ("Edit"));
		return panel;
	}

	protected Widget createButton(final String string) {
		Label label = new Label(string);
		label.setStyleName(getMainStyle() + "-button");
		//move out to controller
		label.addClickListener(new ClickListener () {
			public void onClick(Widget sender) {
				System.out.println(string + " pressed");
			}
		});
		
		return label;
	}

	protected Widget createTaskBodyPanel(Task task) {
		VerticalPanel taskBodyPanel = new VerticalPanel ();
		Label titleLabel = new Label(task.getTitle());
		titleLabel.setStyleName(getMainStyle() + "-titleLabel");
		taskBodyPanel.add (titleLabel);
		taskBodyPanel.setWidth("100%");
		return taskBodyPanel;
	}

	protected Widget createCommonInfoPanel() {
		VerticalPanel commonInfoPanel = new VerticalPanel ();
		Label idLabel = new Label(task.getID());
		Label typeLabel = new Label ("Type: " + task.getType());
		Label statusLabel = new Label ("Status: " + task.getStatus ());
		
		commonInfoPanel.add(idLabel);
		commonInfoPanel.add(typeLabel);
		commonInfoPanel.add (statusLabel);
		
		statusLabel.setStyleName(getMainStyle() + "-statusLabel");
		idLabel.setStyleName(getMainStyle() + "-idLabel");
		typeLabel.setStyleName(getMainStyle() + "-typeLabel");
		return commonInfoPanel;
	}

	protected String getMainStyle() {
		return "taskPanel-" + task.getType();
	}

}
