package com.enigma.pocket.controller;

import com.enigma.pocket.dto.ProductSearchDto;
import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.service.HistoryProductService;
import com.enigma.pocket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    HistoryProductService historyProductService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/product/{id}")
    public Product getProductId(@PathVariable(name = "id") String id){
//        Product product = productService.findProductById(id);
//        product.setHistoryProducts(product);
        return productService.findProductById(id);
    }

    @GetMapping("/products")
    public Page<Product> getAllCustomer(@RequestBody ProductSearchDto productSearchDto,
                                        @RequestParam(name = "page",defaultValue = "0") Integer page,
                                        @RequestParam(name = "size",defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return productService.findProductAll(productSearchDto, pageable);
    }

    @GetMapping("/product")
    public List<Product> getAllProduct(){
        return productService.findProduct();
    }

    @PostMapping("/product/insert")
    public Product createNewProduct(@RequestBody Product product,HistoryProduct historyProduct){
        return productService.createdProduct(product);
    }

    @PutMapping("/product/update")
    public Product updateProductId(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public void deleteId(@PathVariable(name = "id") String id){
        productService.deleteProduct(id);
    }

    @GetMapping("/product/{id}/history")
    public List<HistoryProduct> getHistory(@PathVariable(name = "id") String id){
        return historyProductService.findProductAll();
    }
}
