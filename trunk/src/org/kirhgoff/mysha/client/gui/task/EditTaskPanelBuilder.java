package org.kirhgoff.mysha.client.gui.task;

import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class EditTaskPanelBuilder extends TaskPanelBuilder {

	protected Widget createControlPanel(TaskPanel taskPanel) {
		System.out.println ("EditTaskPanelBuilder.createControlPanel ");
		VerticalPanel panel = new VerticalPanel ();
		panel.add(TaskPanelBuilder.createButton (taskPanel, "Save"));
		panel.add(TaskPanelBuilder.createButton (taskPanel, "Cancel"));
		return panel;
	}
	
	protected Widget createTaskBodyPanel(TaskPanel taskPanel) {
		System.out.println ("EditTaskPanelBuilder.createTaskBodyPanel ");
		Grid taskBodyPanel = new Grid (2, 2);
		String mainStyle = taskPanel.getMainStyle();
		TaskPanelController controller = taskPanel.getController ();
		Task task = controller.getTask();
		taskBodyPanel.setStyleName (mainStyle + "-taskBodyPanel");
		
		//summary
		Label titleLabel = new Label("Title");
		titleLabel.setStyleName(mainStyle + "-titleLabel");

		TextBox titleTextBox = new TextBox ();
		titleTextBox.setText(task.getTitle());
		titleTextBox.setStyleName(mainStyle + "-titleTextBox");
		controller.registerTitleEditor (titleTextBox);
		
		Label summaryLabel = new Label ("Summary");
		titleLabel.setStyleName(mainStyle + "-summaryLabel");
		
		TextArea summaryTextArea = new TextArea ();
		summaryTextArea.setText(task.getSummary());
		summaryTextArea.setStyleName(mainStyle + "-summaryTextArea");
		controller.registerSummaryEditor (summaryTextArea);
		
		taskBodyPanel.setWidget (0, 0, titleLabel);
		taskBodyPanel.setWidget (0, 1, titleTextBox);
		taskBodyPanel.setWidget (1, 0, summaryLabel);
		taskBodyPanel.setWidget (1, 1, summaryTextArea);
		
		taskBodyPanel.setWidth("100%");
		return taskBodyPanel;
	}
}
