package org.kirhgoff.mysha.client.gui.task;

import org.kirhgoff.mysha.client.StatefulPanel;
import org.kirhgoff.mysha.client.controllers.StatefulPanelController;
import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class TaskPanelController extends StatefulPanelController {

	protected Task task = null;
	protected Task dirtyTask = null;
	private Label titleLabel;

	public TaskPanelController(StatefulPanel panel, Task task) {
		super(panel);
		this.task = task;
	}

	public Task getTask() {
		return task;
	}

	public void setState(String state) {
		System.out.println("TaskPanel.setState " + state);

		String panelState = state.equals("Edit") ? "Edit" : "View";
		if (state.equals("Save")) {
			task = dirtyTask.copy();
			
			//set model to view
			titleLabel.setText(task.getTitle());
			
			// TODO save to database
		} else if (state.equals("Edit")) {
			if (dirtyTask == null) dirtyTask = task.copy();
		}

		super.setState(panelState);
	}

	public void registerTitleEditor(final TextBox titleTextBox) {
		titleTextBox.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				dirtyTask.setTitle(titleTextBox.getText());
			}
		});
	}

	public void registerSummaryEditor(final TextArea summaryTextArea) {
		summaryTextArea.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				dirtyTask.setSummary(summaryTextArea.getText());
			}
		});
	}

	public void registerTitleLabel(Label titleLabel) {
		this.titleLabel = titleLabel;
		titleLabel.setText(task.getTitle());		
	}

}
