package com.shtramak.crm.service;

import java.util.List;

import com.shtramak.crm.entity.Customer;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(Long customerId);

    void deleteCustomerById(Long customerId);
}
