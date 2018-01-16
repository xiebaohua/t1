package cn.itcast.service;

import java.util.List;

import cn.itcast.entity.Customer;

public interface ICustomerService {
	
	
	public List<Customer> findAllCustomer();

	public void addCustomer(Customer customer);
	
}
