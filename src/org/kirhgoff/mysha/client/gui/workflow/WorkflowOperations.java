package org.kirhgoff.mysha.client.gui.workflow;

import java.util.HashMap;
import java.util.Map;

import org.kirhgoff.mysha.client.controllers.Action;
import org.kirhgoff.mysha.domain.Task;
import org.kirhgoff.mysha.domain.Transition;
import org.kirhgoff.mysha.domain.Workflow;
import org.kirhgoff.mysha.domain.WorkflowStep;

public class WorkflowOperations {

	public static Map<String, Action> getTransitionsForTask(Task task) {
		HashMap<String, Action> transitions = new HashMap<String, Action> ();
		
		transitions.put ("Title:Cocal", new TransitionAction ("Coca"));
		transitions.put ("Title:Colac", new TransitionAction ("Cola"));
		return transitions;
	}

	static class TransitionAction implements Action {
		private final String transitionName;

		public TransitionAction (String transitionName) {
			this.transitionName = transitionName;
			
		}
		
		public void invoke() {
			System.out.println ("TransitionAction.invoke " + transitionName);
		}
		
	}

	public static Workflow createSampleWorkflow() {
		WorkflowStep workflowStep1 = WorkflowStep.fromStatus ("�� �������");
		WorkflowStep workflowStep2 = WorkflowStep.fromStatus ("����� ��������");
		WorkflowStep workflowStep3 = WorkflowStep.fromStatus ("� ��������");
		WorkflowStep workflowStep4 = WorkflowStep.fromStatus ("�������");
		WorkflowStep workflowStep5 = WorkflowStep.fromStatus ("� ��������");
		WorkflowStep workflowStep6 = WorkflowStep.fromStatus ("���������");
		WorkflowStep workflowStep7 = WorkflowStep.fromStatus ("��������");
		WorkflowStep workflowStep8 = WorkflowStep.fromStatus ("�����");
		
		workflowStep1.add (Transition.from ("����� ��������", workflowStep1, workflowStep2));
		workflowStep2.add (Transition.from ("������", workflowStep2, workflowStep3));
		workflowStep3.add (Transition.from ("�������", workflowStep3, workflowStep4));
		workflowStep4.add (Transition.from ("������ �������", workflowStep4, workflowStep5));
		workflowStep5.add (Transition.from ("��������� �������", workflowStep5, workflowStep6));
		workflowStep6.add (Transition.from ("���������", workflowStep6, workflowStep7));
		workflowStep7.add (Transition.from ("��� ������", workflowStep7, workflowStep8));
		
		workflowStep1.add (Transition.from ("�������", workflowStep1, workflowStep8));
		workflowStep2.add (Transition.from ("�������", workflowStep1, workflowStep8));
		workflowStep3.add (Transition.from ("�������", workflowStep1, workflowStep8));
		workflowStep4.add (Transition.from ("�������", workflowStep1, workflowStep8));
		workflowStep5.add (Transition.from ("�������", workflowStep1, workflowStep8));
		workflowStep6.add (Transition.from ("�������", workflowStep1, workflowStep8));
		workflowStep7.add (Transition.from ("�������", workflowStep1, workflowStep8));
	
		Workflow workflow = new Workflow ();
		workflow.add (workflowStep1);
		workflow.add (workflowStep2);
		workflow.add (workflowStep3);
		workflow.add (workflowStep4);
		workflow.add (workflowStep5);
		workflow.add (workflowStep6);
		workflow.add (workflowStep7);
		workflow.add (workflowStep8);
		return workflow;
	}
}
