package org.kirhgoff.mysha.client.services;

import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("/service/customer")
public interface CustomerService extends RemoteService {
	Customer [] getCustomers ();
}
