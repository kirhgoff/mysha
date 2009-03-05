package org.kirhgoff.mysha.domain;

import java.util.ArrayList;
import java.util.List;


public class WorkflowStep {
	private String status;
	private List<Transition> transitions = new ArrayList<Transition> ();
	
	public static WorkflowStep fromStatus(String string) {
		WorkflowStep step = new WorkflowStep ();
		step.setStatus(string);
		return step;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void add(Transition transition) {
		transitions.add(transition);
	}
	
}
