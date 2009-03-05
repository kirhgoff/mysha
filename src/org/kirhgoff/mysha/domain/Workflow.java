package org.kirhgoff.mysha.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Workflow {
	private Collection<WorkflowStep> steps = new ArrayList<WorkflowStep> ();

	public void add(WorkflowStep workflowStep) {
		steps.add(workflowStep);	
	}
}
