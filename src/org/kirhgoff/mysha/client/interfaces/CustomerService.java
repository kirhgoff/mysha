package org.kirhgoff.mysha.client.interfaces;

import java.util.List;

import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/CustomerService")
public interface CustomerService extends RemoteService {
	
	List<Customer> getCustomersForInbox ();
	boolean addNewCustomer (String firstName, String secondName);
}
