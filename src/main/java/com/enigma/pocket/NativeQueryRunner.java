package com.enigma.pocket;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.repository.CustomerRepository;
import com.enigma.pocket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class NativeQueryRunner implements CommandLineRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Customer> customers = customerRepository.findActiveCustomer();

        customers.stream().forEach(customer -> System.out.println(customer));

//        List<Product> products = productRepository.findAllProductWithPriceGreaterThan(new BigDecimal(10000), 1);
//        products.forEach(product -> System.out.println(product));

        List<Product> products = productRepository.findAllProduct();
        System.out.println(productRepository.countProducts());
        productRepository.prices().forEach(prices -> System.out.println(prices.getProductPriceBuy()+"||"+prices.getProductPriceSell()));
    }
}
