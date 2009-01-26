package org.kirhgoff.mysha.client.controllers;

import org.kirhgoff.mysha.client.interfaces.CustomerService;
import org.kirhgoff.mysha.client.interfaces.CustomerServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CustomerCreationController {

	public void registerCreationForm(final TextBox firstNameBox, final TextBox secondNameBox, Button addNewButton) {
		addNewButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				CustomerServiceAsync customerService = GWT.create(CustomerService.class);
				customerService.addNewCustomer(firstNameBox.getText(), secondNameBox.getText(),
						new AsyncCallback<Boolean>() {
							public void onSuccess(Boolean result) {
								History.newItem("Inbox");
							}

							public void onFailure(Throwable caught) {
							}
						});
			}
		});
	}

}
