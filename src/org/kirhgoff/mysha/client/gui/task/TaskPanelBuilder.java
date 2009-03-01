package org.kirhgoff.mysha.client.gui.task;

import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TaskPanelBuilder {

	protected Widget createControlPanel(TaskPanel taskPanel) {
		VerticalPanel panel = new VerticalPanel ();
		panel.add(createButton (taskPanel, "Edit"));
		return panel;
	}

	protected static Widget createButton(final TaskPanel taskPanel, final String string) {
		Label label = new Label(string);
		label.setStyleName(taskPanel.getMainStyle() + "-button");
		//move out to controller
		label.addClickListener(new ClickListener () {
			public void onClick(Widget sender) {
				taskPanel.getController ().setState(string);
			}
		});
		
		return label;
	}

	protected Widget createTaskBodyPanel(TaskPanel taskPanel) {
		VerticalPanel taskBodyPanel = new VerticalPanel ();
		Label titleLabel = new Label();
		taskPanel.getController ().registerTitleLabel (titleLabel);
		titleLabel.setStyleName(taskPanel.getMainStyle() + "-titleLabel");
		taskBodyPanel.add (titleLabel);
		taskBodyPanel.setWidth("100%");
		return taskBodyPanel;
	}

	protected Widget createCommonInfoPanel(TaskPanel taskPanel) {
		VerticalPanel commonInfoPanel = new VerticalPanel ();
		Task task = taskPanel.getController ().getTask ();
		
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
