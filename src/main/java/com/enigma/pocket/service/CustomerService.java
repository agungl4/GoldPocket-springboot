package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface CustomerService {
    public Customer findCustomerById(Integer id);
    public List<Customer> findCustomers();
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Integer id);
}
