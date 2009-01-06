package org.kirhgoff.mysha.client.pages;

import java.util.List;

import org.kirhgoff.mysha.client.services.CustomerService;
import org.kirhgoff.mysha.client.services.CustomerServiceAsync;
import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class CustomerList extends Composite {
	public CustomerList() {
		final FlexTable panel = new FlexTable ();
		panel.setTitle("Customer list");
		panel.setText(0, 0, "First name");
		panel.setText(0, 1, "Surname");
		
		CustomerServiceAsync customerService = GWT.create(CustomerService.class);
		customerService.getCustomers(new AsyncCallback<List<Customer>>() {
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
