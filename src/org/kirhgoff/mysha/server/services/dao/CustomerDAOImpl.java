package org.kirhgoff.mysha.server.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.kirhgoff.mysha.domain.Customer;
import org.kirhgoff.mysha.server.interfaces.CustomerDAO;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CustomerDAOImpl implements CustomerDAO {
	//private static Logger log = Logger.getLogger(CustomerDAOImpl.class);
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<Customer> getAllCustomers() {
		Query query = entityManager.createQuery("from Customer");
		// query.setFirstResult(startIndex);
		// query.setMaxResults(maxResult);
		return (List<Customer>) query.getResultList();
	}

	@Transactional (propagation = Propagation.REQUIRED)
	public int countAll() {
		Query query = entityManager.createQuery("select count(*) from Customer customer");
		return ((Long) query.getSingleResult()).intValue();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Customer saveCustomer(Customer customer) {
		return entityManager.merge(customer);
	}
}