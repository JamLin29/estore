package com.briup.estore.server;

import java.util.List;
import java.util.Objects;

import com.briup.estore.bean.Customer;
import com.briup.estore.util.EstoreException;
import com.briup.estore.util.ExceptionEnum;
import com.briup.estore.util.GetInstance;

public class CostomerServer {
	public void register(Customer customer) throws Exception {
		if(Objects.isNull(customer)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		if (!checkUsername(customer.getUsername())) {
			GetInstance.COSTOMER_DAO.register(customer);
		} else {
			throw new EstoreException(ExceptionEnum.USERNAME_IS_EXIST);
		}
	}
	
	public boolean checkUsername(String username) throws Exception {
		if (Objects.isNull(username)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		Customer customer = new Customer();
		customer.setUsername(username);
		List<Customer> customers = GetInstance.COSTOMER_DAO.customerFind(customer);
		if (Objects.isNull(customers) || customers.size() == 0) {
			return true;
		}
		return false;
	}

	public Integer login(Customer customer) throws Exception {
		if(Objects.isNull(customer)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		List<Customer> customers = GetInstance.COSTOMER_DAO.customerLogin(customer);
		if (Objects.nonNull(customers) && customers.size() > 0) {
			return customers.get(0).getId();
		}
		return null;
	}
	
	public Customer selectCustomerById(Integer id) {
		if(Objects.isNull(id)) {
			throw new EstoreException(ExceptionEnum.PARAM_IS_NULL);
		}
		return GetInstance.COSTOMER_DAO.selectCustomerById(id);
	}
}
