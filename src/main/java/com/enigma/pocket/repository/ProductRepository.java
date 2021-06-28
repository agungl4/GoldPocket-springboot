package com.enigma.pocket.repository;

import com.enigma.pocket.dto.Prices;
import com.enigma.pocket.entity.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>, JpaSpecificationExecutor<Product> {
    public List<Product> findAllByProductName(String productName, Pageable pageable);

//    @Query(value = "select * from m_products p where p.product_price_sell > :maxPrice and p.product_status", nativeQuery = true)
//    List<Product> findAllProductWithPriceGreaterThan(@Param("maxPrice")BigDecimal maxPrice, @Param("product_status")Integer apaaja);

    @Query(value = "select * from m_products", nativeQuery = true)
    List<Product> findAllProduct();

    @Query(value = "select count(0) from m_products", nativeQuery = true)
    Long countProducts();

    @Query(value = "select new com.enigma.pocket.dto.Prices(p.productPriceSell, p.productPriceBuy) from Product p")
    List<Prices> prices();

}
