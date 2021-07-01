package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchases, String> {

    @Query(value = "select * from t_purchases where customer_id = :customer_id", nativeQuery = true)
    List<Purchases> findPurchaseHistoryByCustomerId(@Param("customer_id") String customerId);
}
