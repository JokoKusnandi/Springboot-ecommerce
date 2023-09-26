package com.joko.service;

import java.util.List;

import com.joko.dao.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

    Customer getCustomerById(Long customerId);

    Customer createCustomer(Customer customer);

    Customer updateCustomer(Long customerId, Customer customer);

    void deleteCustomer(Long customerId);
}
