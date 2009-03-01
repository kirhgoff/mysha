package org.kirhgoff.mysha.client.gui.task;

import org.kirhgoff.mysha.client.StatefulPanel;
import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.DockPanel;

public class TaskPanel extends StatefulPanel {

	private TaskPanelController controller;

	public TaskPanel(Task task) {
		super();

		controller = new TaskPanelController(this, task);
		controller.registerWidget("View", createPanelWithBuilder(new TaskPanelBuilder()));
		controller.registerWidget("Edit", createPanelWithBuilder(new EditTaskPanelBuilder()));

		controller.setState("View");
	}

	private DockPanel createPanelWithBuilder(TaskPanelBuilder builder) {
		DockPanel taskPanel = new DockPanel();

		taskPanel.add(builder.createTaskBodyPanel(this), DockPanel.CENTER);
		taskPanel.add(builder.createCommonInfoPanel(this), DockPanel.WEST);
		taskPanel.add(builder.createControlPanel(this), DockPanel.EAST);
		taskPanel.setStyleName(getMainStyle());
		return taskPanel;
	}

	protected String getMainStyle() {
		return "taskPanel-" + controller.getTask ().getType();
	}

	public TaskPanelController getController() {
		return controller;
	}
}
