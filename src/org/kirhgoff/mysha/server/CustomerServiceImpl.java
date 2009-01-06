package org.kirhgoff.mysha.server;

import java.util.List;

import net.sf.gilead.core.PersistentBeanManager;
import net.sf.gilead.gwt.PersistentRemoteService;

import org.kirhgoff.mysha.client.services.CustomerService;
import org.kirhgoff.mysha.domain.Customer;
import org.kirhgoff.mysha.server.dao.CustomerDAO;

@SuppressWarnings("serial")
public class CustomerServiceImpl extends PersistentRemoteService implements CustomerService {

	public List<Customer> getCustomers() {
		setBeanManager((PersistentBeanManager)ApplicationContext.getInstance().getBean("beanManager"));
		CustomerDAO bean = (CustomerDAO) ApplicationContext.getInstance().getBean(CustomerDAO.NAME);
		return bean.getAllCustomers();
		
	}

}
