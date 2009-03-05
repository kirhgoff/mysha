package org.kirhgoff.mysha.domain;

public class Transition {
	private String label;
	private WorkflowStep startStep;
	private WorkflowStep endStep;
	
	public static Transition from(String label, WorkflowStep startStep, WorkflowStep endStep) {
		Transition transition = new Transition ();
		transition.startStep = startStep;
		transition.endStep = endStep;
		transition.label = label;
		return transition;
	}

	public WorkflowStep getStartStep() {
		return startStep;
	}

	public WorkflowStep getEndStep() {
		return endStep;
	}

	public String getLabel() {
		return label;
	}
	
	
}
