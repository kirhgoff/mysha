package org.kirhgoff.mysha.client.interfaces;

import java.util.List;

import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/CustomerService")
public interface CustomerServiceAsync {
	
	void getCustomersForInbox (AsyncCallback<List<Customer>> callback);

	void addNewCustomer(String firstName, String secondName, AsyncCallback<Boolean> asyncCallback);
}
