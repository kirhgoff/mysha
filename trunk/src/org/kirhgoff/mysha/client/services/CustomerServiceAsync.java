package org.kirhgoff.mysha.client.services;

import java.util.List;

import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CustomerServiceAsync {
	void getCustomers (AsyncCallback<List<Customer>> callback);
}
