package org.kirhgoff.mysha.server.services.backend;

import org.kirhgoff.mysha.domain.Customer;
import org.kirhgoff.mysha.server.interfaces.CustomerDAO;
import org.kirhgoff.mysha.server.interfaces.StartupService;

public class StartupServiceImpl implements StartupService {
	
	private CustomerDAO customerDAO;
	
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public CustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	public boolean isInitialized() {
		return customerDAO.countAll() > 0;
	}

	public void initialize() {
		//Create sample customers
		String [][] data = new String [][] {
				new String [] {"Kirill", "Lastovirya"},
				new String [] {"Vasily", "Pupochkin"},
				new String [] {"Natasha", "Devochkina"},
				new String [] {"Alexander", "Pokrovsky"},
				new String [] {"Semen", "Neznamov"},
		};
		
		for (int i = 0; i < data.length; i++) {
			Customer customer = new Customer ();
			customer.setFirstName(data[i][0]);
			customer.setSurName(data[i][1]);
			customerDAO.saveCustomer (customer);
		}

	}
}
