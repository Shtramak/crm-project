package com.shtramak.crm.dao;

import java.util.List;

import com.shtramak.crm.entity.Customer;

public interface CustomerDao {
    List<Customer> getCustomers();
}
