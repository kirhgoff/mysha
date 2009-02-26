package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class EditTaskPanel extends TaskPanel {

	public EditTaskPanel(Task task) {
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
}
