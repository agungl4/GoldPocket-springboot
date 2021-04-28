package com.enigma.pocket.service;

import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductHistoryPriceService {
    public ProductHistoryPrice createHistory(ProductHistoryPrice productHistoryPrice);
    public List<ProductHistoryPrice> findAllByProduct(String id);
    public Page<ProductHistoryPrice> findHistory(Pageable pageable);
}
