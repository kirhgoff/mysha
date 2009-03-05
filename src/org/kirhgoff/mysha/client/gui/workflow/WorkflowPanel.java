package org.kirhgoff.mysha.client.gui.workflow;

import org.kirhgoff.mysha.domain.Workflow;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class WorkflowPanel extends Composite {
	
	private Workflow workflow;

	public WorkflowPanel() {
		VerticalPanel panel = new VerticalPanel ();
		workflow = WorkflowOperations.createSampleWorkflow();

		
		initWidget (panel);
	}
}
