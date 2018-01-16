package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.utils.HibernateUtil;

public class CustomerDao implements ICustomerDao {

	@Override
	public List<Customer> findAllCustomer() {
		Session session = HibernateUtil.getCurrentSession();
		
		Query query = session.createQuery("from Customer");
		
		List list = query.list();
		
		
		
		return list;
		
	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
	}
}
