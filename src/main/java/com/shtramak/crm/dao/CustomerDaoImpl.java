package com.shtramak.crm.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import com.shtramak.crm.entity.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> getCustomers() {
        return entityManager.createQuery("FROM Customer ORDER BY lastName", Customer.class).getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        if (customer.getId() != null) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return entityManager.find(Customer.class, customerId);
    }

    @Override
    public void deleteCustomerById(Long customerId) {
        entityManager.createQuery("delete from Customer where id=:customerId")
                .setParameter("customerId", customerId)
                .executeUpdate();
    }
}
