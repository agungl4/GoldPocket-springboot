package com.enigma.pocket.service;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.repository.ProductRepository;
import com.enigma.pocket.specification.ProductSpesification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final String notFoundMessage = "Product with id:%s Not FOund";

    @Autowired
    ProductRepository productRepository;

    @Autowired
    HistoryProductService historyProductService;

    @Override
    public Product findProductById(String id) {
        validatePresent(id);
        Product product = productRepository.findById(id).get();
        return product;
    }

    @Override
    public List<Product> findProduct() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findProductAll(ProductSearchDto productSearchDto, Pageable pageable) {

        return productRepository.findAll(ProductSpesification.findProduct(productSearchDto),pageable);
    }

    @Override
    public Product createdProduct(Product product) {
        product.setCreated_at(new Date());
        product.setUpdated_at(new Date());
        Product saveProduct = productRepository.save(product);
        HistoryProduct historyProduct= new HistoryProduct(saveProduct);
        historyProductService.logPrice(historyProduct);
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        validatePresent(product.getIdProduct());
        product.setUpdated_at(new Date());
        Product saveProduct = productRepository.save(product);
        HistoryProduct historyProduct= new HistoryProduct(saveProduct);
        historyProductService.logPrice(historyProduct);
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    private void validatePresent(String id) {
        if (!productRepository.findById(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(notFoundMessage, id));
        }
    }

}
