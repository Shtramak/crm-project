package com.shtramak.crm.dao;

import java.util.List;

import com.shtramak.crm.entity.Customer;

public interface CustomerDao {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(Long customerId);
}
