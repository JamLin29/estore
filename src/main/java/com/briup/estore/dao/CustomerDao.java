package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.CustomerExample;
import com.briup.estore.mapper.CustomerMapper;
import com.briup.estore.util.SqlSessionUtil;

public class CustomerDao {
	public List<Customer> customerLogin(Customer customer) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		CustomerExample customerExample = new CustomerExample();

		customerExample.createCriteria()
			.andUsernameEqualTo(customer.getUsername())
			.andPasswordEqualTo(customer.getPassword());
		customerExample.or(
				new CustomerExample().createCriteria()
					.andEmailEqualTo(customer.getUsername())
					.andPasswordEqualTo(customer.getPassword()));
		customerExample.or(
				new CustomerExample().createCriteria()
					.andPhoneEqualTo(customer.getUsername())
					.andPasswordEqualTo(customer.getPassword()));
		List<Customer> customers = mapper.selectByExample(customerExample);
		session.close();
		return customers;
	}
	
	public List<Customer> customerFind(Customer customer) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		CustomerExample customerExample = new CustomerExample();

		customerExample.createCriteria().andUsernameEqualTo(customer.getUsername());
		List<Customer> customers = mapper.selectByExample(customerExample);
		session.close();
		return customers;
	}

	public void register(Customer customer) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		mapper.insertSelective(customer);
		session.commit();
		session.close();
	}
	
	public Customer selectCustomerById(Integer id) {
		SqlSession session = SqlSessionUtil.getSqlSession();
		CustomerMapper mapper = session.getMapper(CustomerMapper.class);
		Customer customer = mapper.selectByPrimaryKey(id);
		session.close();
		return customer;
	}
}
