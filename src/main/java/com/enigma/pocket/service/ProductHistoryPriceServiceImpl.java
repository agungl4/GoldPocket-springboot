package com.enigma.pocket.service;

import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.repository.ProductHistoryPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductHistoryPriceServiceImpl implements ProductHistoryPriceService {
    @Autowired
    ProductHistoryPriceRepository productHistoryPriceRepository;

    @Autowired
    ProductService productService;

    @Override
    public ProductHistoryPrice createHistory(ProductHistoryPrice productHistoryPrice) {
        return productHistoryPriceRepository.save(productHistoryPrice);
    }

    @Override
    public List<ProductHistoryPrice> findAllByProduct(String id) {
        Product product = productService.getProductById(id);
        return product.getProductHistories();
    }

    @Override
    public Page<ProductHistoryPrice> findHistory(Pageable pageable) {
        return productHistoryPriceRepository.findAll(pageable);
    }

}
