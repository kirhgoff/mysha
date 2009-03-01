package org.kirhgoff.mysha.client;

import org.kirhgoff.mysha.client.gui.task.TaskPanel;
import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class SandboxPanel extends Composite {

	public SandboxPanel() {
		VerticalPanel panel = new VerticalPanel ();
		Label header = new Label ("Sandbox: play here");
		panel.add(header);
		
		TaskPanel theTaskPanel = new TaskPanel (createDocumentTask ());
		panel.add(theTaskPanel);
		
		TaskPanel theTaskPanel2 = new TaskPanel (createProjectTask ());
		panel.add(theTaskPanel2);
		
		initWidget(panel);
	}

	private Task createDocumentTask() {
		return Task.from("MYSH-0", "Document", "Masha Ivanova");
	}

	private Task createProjectTask() {
		Task task1 = Task.from("MYSH-1", "Project", "Ivanov/just visa 2009.01.02");
		task1.addChild(Task.from ("MYSH-2", "Document", "bank statement"));
		task1.addChild(Task.from ("MYSH-3", "Document", "real estate documents"));
		task1.addChild(Task.from ("MYSH-4", "Document", "car documents"));
		return task1;
	}

}
