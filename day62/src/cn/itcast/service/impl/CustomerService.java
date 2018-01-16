package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.dao.impl.CustomerDao;
import cn.itcast.entity.Customer;
import cn.itcast.service.ICustomerService;
import cn.itcast.utils.HibernateUtil;

public class CustomerService implements ICustomerService {
	private ICustomerDao dao = new CustomerDao();

	@Override
	public List<Customer> findAllCustomer() {

		Session session = HibernateUtil.getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			List<Customer> list = dao.findAllCustomer();

			tx.commit();

			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		return null;

	}

	@Override
	public void addCustomer(Customer customer) {
		Session session = HibernateUtil.getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			dao.addCustomer(customer);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
