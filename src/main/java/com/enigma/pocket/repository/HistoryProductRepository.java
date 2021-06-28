package com.enigma.pocket.repository;

import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryProductRepository extends JpaRepository<HistoryProduct, String>{

    @Query(value = "select * from m_history_prices where product_id = :product_id", nativeQuery = true)
    List<HistoryProduct> findHistoryProductById(@Param("product_id") String id );
}
