package org.kirhgoff.mysha.server;

import java.util.ArrayList;
import java.util.List;

import org.kirhgoff.mysha.client.services.CustomerService;
import org.kirhgoff.mysha.domain.Customer;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class CustomerServiceImpl extends RemoteServiceServlet implements CustomerService {

	public Customer[] getCustomers() {
		String [][] data = new String [][] {
				new String [] {"Kirill", "Lastovirya"},
				new String [] {"Vasily", "Pupochkin"},
				new String [] {"Natasha", "Devochkina"},
				new String [] {"Alexander", "Pokrovsky"},
				new String [] {"Semen", "Neznamov"},
		};
		
		List<Customer> customers = new ArrayList<Customer>();
		for (int i = 0; i < data.length; i++) {
			Customer customer = new Customer ();
			customer.setFirstName(data[i][0]);
			customer.setSurName(data[i][1]);
			customers.add(customer);
			
		}
		return customers.toArray(new Customer[]{});
	}

}
