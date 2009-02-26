package org.kirhgoff.mysha.client.controllers;

import java.util.ArrayList;
import java.util.List;

import org.kirhgoff.mysha.client.TaskPanel;
import org.kirhgoff.mysha.domain.Task;

import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class TemplateController {

	private VerticalPanel templatePanel;
	private TaskTemplateModel model = new TaskTemplateModel();

	public void registerCustomerChooser(final ListBox customerChooser) {
		customerChooser.addItem("Sergey Ivanov");
		customerChooser.addItem("Alexey Sergeev");
		customerChooser.addItem("Eugene Valentinov");
		customerChooser.addItem("Anna Pakhmutova");

		customerChooser.addChangeListener(new ChangeListener() {
			public void onChange(Widget sender) {
				System.out.println("Customer changed " + getSelectedItem(customerChooser));
				model.setCustomer(getSelectedItem(customerChooser));
			}
		});
	}

	public void registerTemplateChooser(final ListBox templateChooser) {
		templateChooser.addItem("KPG client: student boarding");
		templateChooser.addItem("KPG client: student university");
		templateChooser.addItem("KPG client: student short term (ex. EFL) older than 18 y.o.");
		templateChooser.addItem("KPG client: student short term (ex. EFL) younger than 18 y.o.");
		templateChooser.addItem("KPG client: visitor (relatives visiting children)");
		templateChooser.addItem("KPG client: visitor (tourist)");
		templateChooser.addItem("KPG client: visitor business");
		templateChooser.addItem("KPG client: work permit");
		templateChooser.addItem("KPG client: marriage");
		templateChooser.addItem("KPG client: group of short term students students");
		templateChooser.addItem("KPG client: groups of visitors");
		templateChooser.addItem("BRIT clients");
		templateChooser.addItem("Anglia Education clients");
		
		templateChooser.addChangeListener(new ChangeListener () {
			public void onChange(Widget sender) {
				String template = getSelectedItem(templateChooser);
				System.out.println("Template changed " + getSelectedItem(templateChooser));
				model.setTemplate(template);
				model.setTaskList (loadTaskList (template));
				
				fillTemplatePanel ();
			}
		});
	}

	protected void fillTemplatePanel() {
		while (templatePanel.getWidgetCount() > 0) {
			templatePanel.remove(0);
		} 
		
		List<Task> taskList = model.getTaskList();
		for (Task task : taskList) {
			TaskPanel taskPanel = new TaskPanel (task);
			templatePanel.add(taskPanel);
		}
	}

	protected List<Task> loadTaskList(String template) {
		//TODO MOCK
		List<Task> result = new ArrayList<Task> ();
		if (template.equals("BRIT clients")) {
		result.add(Task.from("MYSH-51", "Document", model.getCustomer() + ": partners invitation letter"));
		result.add(Task.from("MYSH-52", "Document", model.getCustomer() + ": reference from school in Russia"));
		result.add(Task.from("MYSH-53", "Document", model.getCustomer() + ": birth certificate"));
		}
		else {
			result.add(Task.from("MYSH-54", "Document", model.getCustomer() + ": tenancy agreement"));
			result.add(Task.from("MYSH-55", "Document", model.getCustomer() + ": divorce certificate"));
			result.add(Task.from("MYSH-56", "Document", model.getCustomer() + ": birth certificate"));
			result.add(Task.from("MYSH-57", "Document", model.getCustomer() + ": work permit"));
			result.add(Task.from("MYSH-58", "Document", model.getCustomer() + ": hotel booking"));
			result.add(Task.from("MYSH-59", "Document", model.getCustomer() + ": invitation"));

		}
		return result;
	}

	private String getSelectedItem(final ListBox customerChooser) {
		int index = customerChooser.getSelectedIndex();
		String item = customerChooser.getItemText(index);
		return item;
	}

	public void setPanel(VerticalPanel panel) {
		this.templatePanel = panel;
	}
}
