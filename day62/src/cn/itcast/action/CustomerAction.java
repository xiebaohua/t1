package cn.itcast.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;

import cn.itcast.entity.Customer;
import cn.itcast.service.ICustomerService;
import cn.itcast.service.impl.CustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * <package name="customer" extends="struts-default" namespace="/customer">
		
		<action name="findAllCustomer" class="cn.itcast.action.CustomerAction" method="findAllCustomer">
			<result name="success" type="dispatcher">/jsp/customer/list.jsp</result>
		</action>
		<action name="addCustomerUI" >
			<result>/jsp/customer/add.jsp</result>
		</action>
		
		<action name="addCustomer" class="cn.itcast.action.CustomerAction" method="addCustomer">
			<result>/jsp/success.jsp</result>
		</action>
	</package>
 *
 */

@ParentPackage("struts-default")
@Namespace("/customer")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private Customer customer = new Customer();
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	private List<Customer> customers;

	
	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	ICustomerService service = new CustomerService();
	
	
	/**
	 * <action name="findAllCustomer" class="cn.itcast.action.CustomerAction" method="findAllCustomer">
			<result name="success" type="dispatcher">/jsp/customer/list.jsp</result>
		</action>
	 */
	@Action(value="findAllCustomer",results={@Result(name="success",type="dispatcher",location="/jsp/customer/list.jsp")
	})
	public String findAllCustomer(){
		
		customers = service.findAllCustomer();
		
		return SUCCESS;
	}
	
	
	/**
	 * <action name="addCustomer" class="cn.itcast.action.CustomerAction" method="addCustomer">
			<result>/jsp/success.jsp</result>
		</action>
	 */
	@Action(value="addCustomer",results={
			@Result(location="/jsp/success.jsp",name="success")
	})
	public String addCustomer(){
		service.addCustomer(customer);
		return SUCCESS;
	}
	
	/**
	 * <action name="addCustomerUI" >
			<result>/jsp/customer/add.jsp</result>
		</action>
	 */
	@Action(value="addCustomerUI",results={
			@Result(location="/jsp/customer/add.jsp",name="success",type="dispatcher")
	})
	public String addCustomerUI(){
		return SUCCESS;
	}
	
	
}
