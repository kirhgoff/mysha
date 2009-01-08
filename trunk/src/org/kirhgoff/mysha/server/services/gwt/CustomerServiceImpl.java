package org.kirhgoff.mysha.server.services.gwt;

import java.util.List;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.gwt.PersistentRemoteService;

import org.kirhgoff.mysha.client.interfaces.CustomerService;
import org.kirhgoff.mysha.domain.Customer;
import org.kirhgoff.mysha.server.interfaces.CustomerDAO;
import org.kirhgoff.mysha.server.services.MyshaServerApplication;

@SuppressWarnings("serial")
public class CustomerServiceImpl extends PersistentRemoteService implements CustomerService {

	private CustomerDAO bean;

	public CustomerServiceImpl() {
		setBeanManager((PersistentBeanManager)MyshaServerApplication.getInstance().getBean("beanManager"));
		bean = (CustomerDAO) MyshaServerApplication.getInstance().getBean(CustomerDAO.NAME);
	}
	
	public List<Customer> getCustomersForInbox() {
		return bean.getAllCustomers();
		
	}

	public boolean addNewCustomer(String firstName, String secondName) {
		if (firstName == null || secondName == null) throw new NullPointerException ();
		//TODO check for uniqness
		Customer customer = new Customer ();
		customer.setFirstName(firstName);
		customer.setSurName(secondName);
		
		bean.saveCustomer(customer);
		return true;
	}

}
