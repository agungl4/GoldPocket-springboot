package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, String> {

    @Query(value = "select * from m_pockets where customer_id = :customer_id", nativeQuery = true)
    List<Pocket> findPocketByCustomerId(@Param("customer_id") String customerId);
}
