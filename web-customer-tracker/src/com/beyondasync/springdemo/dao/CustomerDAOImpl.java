package com.beyondasync.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beyondasync.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
		// get the current hibernate session

		// create a query

		// execute query and get result list

		// return the results

		Session currentSession = sessionFactory.getCurrentSession();

		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);

		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

}
