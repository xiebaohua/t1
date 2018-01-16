package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Customer;

public interface ICustomerDao {

	List<Customer> findAllCustomer();

	void addCustomer(Customer customer);
	
}
