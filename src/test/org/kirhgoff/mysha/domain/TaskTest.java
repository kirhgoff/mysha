package test.org.kirhgoff.mysha.domain;

import java.util.List;

import junit.framework.TestCase;

import org.kirhgoff.mysha.client.TaskListPanel;
import org.kirhgoff.mysha.domain.Task;

public class TaskTest extends TestCase {

	public void testTask() throws Exception {
		List<Task> tasks = TaskListPanel.sampleTasks();

		tasks.toString();
	}
}
