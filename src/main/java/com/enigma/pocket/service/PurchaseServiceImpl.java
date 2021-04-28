package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.entity.PurchaseDetail;
import com.enigma.pocket.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpMethod;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;

    @Autowired
    RestTemplate restTemplate;

    @Value("spring-mail-username")
    String sender;


    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public Purchase findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public Page<Purchase> findPurchases(PageRequest pageRequest) {
        return purchaseRepository.findAll(pageRequest);
    }

    @Override
    public Purchase purchase(Purchase purchase, String customerId) {
        Customer customer = customerService.findCustomerById(customerId);
        purchase.setCustomer(customer);
        purchase.setPurchaseDate(new Date());

        BigDecimal total = BigDecimal.ZERO;

        for (PurchaseDetail purchaseDetail: purchase.getPurchaseDetails()) {
            Pocket pocket = pocketService.findPocketById(purchaseDetail.getPocket().getId());
            pocketService.topUp(pocket, purchaseDetail.getQuantityInGram());
            purchaseDetail.setProduct(pocket.getProduct());
            purchaseDetail.setPrice(pocket.getProduct().getProductPriceSell());
            purchaseDetail.setPurchase(purchase);
            BigDecimal quantity = new BigDecimal(purchaseDetail.getQuantityInGram());
            total = total.add(purchaseDetail.getPrice().multiply(quantity));
        }

        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8090/debet")
                .queryParam("phoneNumber", customer.getPhoneNumber())
                .queryParam("amount",total);
        System.out.println(componentsBuilder.toUriString());
        restTemplate.exchange(componentsBuilder.toUriString(),HttpMethod.POST,null, String.class);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(customer.getEmail());
        message.setSubject("INVOICE GOLD POCKET");
        message.setText("Pembelian Berhasil!");

        javaMailSender.send(message);
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase updatePurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
