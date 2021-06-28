package com.enigma.pocket.service;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Product findProductById(String id);
    public List<Product> findProduct();
    public Page<Product> findProductAll(ProductSearchDto productSearchDto, Pageable pageable);
    public Product createdProduct(Product product);
    public Product updateProduct(Product product);
    public void deleteProduct(String id);
}
