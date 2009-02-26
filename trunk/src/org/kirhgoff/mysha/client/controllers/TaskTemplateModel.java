package org.kirhgoff.mysha.client.controllers;

import java.util.List;

import org.kirhgoff.mysha.domain.Task;

public class TaskTemplateModel {

	private String customer;
	private String template;
	private String taskName;
	private List<Task> taskList;

	public void setCustomer(String customer) {
		this.customer = customer;
		updateLabelName ();
	}

	public void setTemplate(String template) {
		this.template = template;
		updateLabelName ();
	}
	
	private void updateLabelName() {
		this.taskName = "["  + customer + "] " + template;
	}
	
	public String getTaskName () {
		return this.taskName;
	}
	
	public String getCustomer () {
		return this.customer;
	}
	
	public void setTaskList(List<Task> loadTaskList) {
		this.taskList = loadTaskList;
	}
	
	public List<Task> getTaskList () {
		return taskList;
	}

}
