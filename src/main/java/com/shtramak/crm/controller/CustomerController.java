package com.shtramak.crm.controller;

import java.util.List;

import com.shtramak.crm.dao.CustomerDao;
import com.shtramak.crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model) {
        List<Customer> customers = customerDao.getCustomers();
        model.addAttribute("customers", customers);
        return "list-customers";
    }
}
