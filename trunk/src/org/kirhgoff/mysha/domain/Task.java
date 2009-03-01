package org.kirhgoff.mysha.domain;

import java.util.ArrayList;
import java.util.List;

public class Task {
	private List<Task> children;
	private String id;
	private String title;
	private String type;
	private String summary;
	private String status = "New";
	
	public Task() {
		children = new ArrayList<Task>();
	}
	
	public static Task from(String id, String type, String title) {
		Task task = new Task ();
		task.setID(id);
		task.setTitle(title);
		task.setType(type);
		return task;
	}
	public void addChild (Task child) {
		children.add(child);
	}

	public void setID(String string) {
		this.id = string;
		
	}

	public void setTitle(String string) {
		this.title = string;
	}

	public void setType(String string) {
		this.type = string;
	}

	public boolean hasChildren() {
		return !children.isEmpty();
	}

	public List<Task> getChilren() {
		return children;
	}

	public String getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getType() {
		return type;
	}

	public String getStatus() {
		return status;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}

	public Task copy() {
		Task copy = Task.from (id, type, title);
		copy.setStatus (getStatus ());
		
		//TODO copy children
		return copy;
	}

	private void setStatus(String status) {
		this.status = status;
	}
}
