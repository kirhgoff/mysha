package org.kirhgoff.mysha.client;

import java.util.List;

import org.kirhgoff.mysha.client.interfaces.CustomerService;
import org.kirhgoff.mysha.client.interfaces.CustomerServiceAsync;
import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class InboxPanel extends Composite {
	public InboxPanel() {
		final FlexTable panel = new FlexTable ();
		panel.setTitle("Customer list");
		panel.setText(0, 0, "First name");
		panel.setText(0, 1, "Surname");
		
		//TODO model assignment to view should be separated from GWT
		//Create common widgets?
		CustomerServiceAsync customerService = GWT.create(CustomerService.class);
		customerService.getCustomersForInbox(new AsyncCallback<List<Customer>>() {
			public void onSuccess(List<Customer> result) {
				int row = 1;
				for (Customer customer : result) {
					//panel.add(new Label (customer.getFirstName() + " " + customer.getSurName()));
					panel.setText (row, 0, customer.getFirstName());
					panel.setText (row, 1, customer.getSurName());
					row ++;
				}
			}
		
			public void onFailure(Throwable caught) {
				Label errorMessage = new Label ("Cannot access customers service:" + caught.getMessage());
				errorMessage.setStyleName("error-message");
				panel.add(errorMessage);
			}
		});
		
		initWidget(panel);
	}
}
