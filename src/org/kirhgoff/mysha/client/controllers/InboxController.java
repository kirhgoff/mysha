package org.kirhgoff.mysha.client.controllers;

import java.util.List;

import org.kirhgoff.mysha.client.MyshaClientApplication;
import org.kirhgoff.mysha.client.interfaces.AuthService;
import org.kirhgoff.mysha.client.interfaces.AuthServiceAsync;
import org.kirhgoff.mysha.client.interfaces.CustomerService;
import org.kirhgoff.mysha.client.interfaces.CustomerServiceAsync;
import org.kirhgoff.mysha.domain.Customer;
import org.kirhgoff.mysha.domain.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;

public class InboxController {

	public void loadCustomerListToTable(final FlexTable panel) {
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
				MyshaClientApplication.setStatus("Cannot access customers service:" + caught.getMessage());
			}
		});
	}
	
	public static void addUserNameToHeader(final Label label) {
		AuthServiceAsync authService = GWT.create(AuthService.class);
		authService.getUser(new AsyncCallback<User>() {
			public void onSuccess(User result) {
				label.setText("Hello, " + result.getLogin());
			}
	
			public void onFailure(Throwable caught) {
				label.setText("Cannot access customers service:" + caught.getMessage());
			}			
		});
		
	}	

}
