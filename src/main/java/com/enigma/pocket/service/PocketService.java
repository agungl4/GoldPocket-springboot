package com.enigma.pocket.service;

import com.enigma.pocket.dto.CustomerSearchDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PocketService {
    public Pocket findPocketById(String id);
    //public Page<Customer> findCustomers(CustomerSearchDto customerSearchForm, Pageable pageable);
    public Pocket createNewPocket(Pocket pocket);
    public Pocket updatePocket(Pocket pocket);
    public void topUp(Pocket pocket, Double qty);
    //public void removeCustomer(String id);
}
