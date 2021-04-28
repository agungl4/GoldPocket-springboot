package com.enigma.pocket.service;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    public Product getProductById(String id);
    public Page<Product> searchProduct(ProductSearchDto productSearchForm,Pageable page);
    //public void saveProduct(Product product, ProductHistoryPrice productHistoryPrice);
    public Product saveProduct(Product product);
    public Product updateProduct(Product product);


}
