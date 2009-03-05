package test.org.kirhgoff.mysha.domain;

import org.junit.Test;
import org.kirhgoff.mysha.client.gui.workflow.WorkflowOperations;
import org.kirhgoff.mysha.domain.Workflow;

public class WorkflowTest {

	@Test
	public void testWorkflowCreation() throws Exception {
		Workflow workflow = WorkflowOperations.createSampleWorkflow();
		
		System.out.println ("WorkflowTest.enclosing_method " + workflow);

	}
}
