package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	
	//need to inject session factory here using autowired
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get current Hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		//create query 
		
		List<Customer> customers=session.createQuery("from Customer order by lastName").getResultList();
		
		//return the results
		
		return customers;
		
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		
		Session session=sessionFactory.getCurrentSession();
		
		
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Customer customer=session.get(Customer.class, theId);
		System.out.println(theId);
		
		return customer;
	}
	
public void deleteCustomer(int theId) {
		
		Session session=sessionFactory.getCurrentSession();
		
		Customer customer=session.get(Customer.class, theId);
		session.delete(customer);
		
	}
	
	
	
	

	

}
