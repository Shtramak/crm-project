package com.shtramak.crm.service;

import java.util.List;

import com.shtramak.crm.dao.CustomerDao;
import com.shtramak.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }
}
