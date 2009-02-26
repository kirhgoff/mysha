package org.kirhgoff.mysha.client;

import java.util.ArrayList;
import java.util.List;

import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TaskListPanel extends Composite {
	private List<Task> tasks = sampleTasks();
	
	public TaskListPanel() {
		VerticalPanel panel = new VerticalPanel();
		for (Task task : tasks) {
			addTask(panel, task);
		}

		initWidget(panel);
	}

	private static void addTask(VerticalPanel panel, Task task) {
		System.out.println("Adding task: " + task);
		TaskPanel taskPanel = new TaskPanel (task);
		panel.add (taskPanel);

		if (task.hasChildren()) {
			for (Task child : task.getChilren()) {
				addTask(panel, child);
			}
		}
	}

	public static List<Task> sampleTasks() {
		//TODO check for current user and add assignee field to Task
		//TODO MOCK
		Task task1 = Task.from("MYSH-1", "Project", "Ivanov/just visa 2009.01.02");
		task1.addChild(Task.from ("MYSH-2", "Document", "bank statement"));
		task1.addChild(Task.from ("MYSH-3", "Document", "real estate documents"));
		task1.addChild(Task.from ("MYSH-4", "Document", "car documents"));
	
		Task task2 = Task.from ("MYSH-5", "Project", "Sergeev/visa 2009.01.27");
		task2.addChild(Task.from ("MYSH-2", "Document", "course confirmation from school"));
		task2.addChild(Task.from ("MYSH-3", "Document", "confirmation of the accommodation"));
		task2.addChild(Task.from ("MYSH-4", "Document", "reference from work"));
		
		List<Task> tasks = new ArrayList<Task> ();
		tasks.add(task1);
		tasks.add(task2);
		return tasks;
	}
	
}
