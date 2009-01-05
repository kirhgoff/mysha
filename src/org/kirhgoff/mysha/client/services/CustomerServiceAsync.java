package org.kirhgoff.mysha.client.services;

import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CustomerServiceAsync {
	void getCustomers (AsyncCallback<Customer[]> callback);
}
