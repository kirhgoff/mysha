package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class EditTaskPanel extends TaskPanel {

	public EditTaskPanel(Task task) {
		super (task);
		
	}

	@Override
	protected Widget createControlPanel() {
		VerticalPanel panel = new VerticalPanel ();
		panel.add(createButton ("Save"));
		panel.add(createButton ("Cancel"));
		return panel;
	}
	
	@Override
	protected Widget createTaskBodyPanel(Task task) {
		Grid taskBodyPanel = new Grid (2, 2);
		taskBodyPanel.setStyleName (getMainStyle() + "-taskBodyPanel");
		
		//summary
		Label titleLabel = new Label("Title");
		titleLabel.setStyleName(getMainStyle() + "-titleLabel");

		TextBox titleTextBox = new TextBox ();
		titleTextBox.setText(task.getTitle());
		titleTextBox.setStyleName(getMainStyle() + "-titleTextBox");
		
		Label summaryLabel = new Label ("Summary");
		titleLabel.setStyleName(getMainStyle() + "-summaryLabel");
		
		TextArea summaryTextArea = new TextArea ();
		summaryTextArea.setText(task.getSummary());
		summaryTextArea.setStyleName(getMainStyle() + "-summaryTextArea");
		
		taskBodyPanel.setWidget (0, 0, titleLabel);
		taskBodyPanel.setWidget (0, 1, titleTextBox);
		taskBodyPanel.setWidget (1, 0, summaryLabel);
		taskBodyPanel.setWidget (1, 1, summaryTextArea);
		
		taskBodyPanel.setWidth("100%");
		return taskBodyPanel;
	}
}
