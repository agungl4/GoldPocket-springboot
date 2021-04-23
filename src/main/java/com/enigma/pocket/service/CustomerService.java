package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.domain.Pageable;

import java.time.OffsetDateTime;
import java.util.List;

public interface CustomerService {
    public Customer findCustomerById(String id);
    public List<Customer> findCustomers(String firstName, String email, Pageable pageable);
    public void createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void removeCustomer(Integer id);
}
