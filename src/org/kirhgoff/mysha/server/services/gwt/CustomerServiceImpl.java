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

	public List<Customer> getCustomersForInbox() {
		setBeanManager((PersistentBeanManager)MyshaServerApplication.getInstance().getBean("beanManager"));
		CustomerDAO bean = (CustomerDAO) MyshaServerApplication.getInstance().getBean(CustomerDAO.NAME);
		return bean.getAllCustomers();
		
	}

}
