package com.shtramak.crm.dao;

import java.util.List;

import com.shtramak.crm.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY lastName", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, customerId);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
        query.setParameter("customerId",customerId);
        query.executeUpdate();
    }
}
