package test.org.kirhgoff.mysha.domain;

import java.util.List;

import junit.framework.TestCase;

import org.kirhgoff.mysha.client.gui.task.TaskListPanel;
import org.kirhgoff.mysha.domain.Task;

public class TaskTest extends TestCase {

	public void testTask() throws Exception {
		List<Task> tasks = TaskListPanel.sampleTasks();

		tasks.toString();
	}
}
