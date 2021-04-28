package com.enigma.pocket.controller;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.entity.ProductHistoryPrice;
import com.enigma.pocket.service.ProductHistoryPriceService;
import com.enigma.pocket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    ProductHistoryPriceService productHistoryPriceService;

    @PostMapping("/product")
    public Product createNew(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/products")
    public Page<Product> getProducts(@RequestBody ProductSearchDto productSearchForm,
                                     @RequestParam(name = "page", defaultValue = "0") Integer page,
                                     @RequestParam(name = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return productService.searchProduct(productSearchForm,pageable);
    }
    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable(name = "id") String id){
        return productService.getProductById(id);
    }
    @GetMapping("/product/{id}/history")
    public List<ProductHistoryPrice> getHistoriesByProduct(@PathVariable(name = "id") String id){
        return productHistoryPriceService.findAllByProduct(id);
    }
}
