package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    //nama method ini mewakilkan dari query yang akan dijalankan, springboot otomatis mendeteksi
//    public List<Customer> findAllByFirstNameStartingWithAndEmailContainingANDBirthDateBetween(String firstName, String email, Date startDate, Date birthDate, Pageable pageable);
    public List<Customer> findAllByFirstNameStartingWithAndEmailContaining(String firstName, String email, Pageable pageable);

    @Query("SELECT c FROM Customer c WHERE c.status=1")
    List<Customer> findActiveCustomer();

}
