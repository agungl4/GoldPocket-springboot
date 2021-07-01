package com.enigma.pocket.service;

import com.enigma.pocket.dto.PurchaseDto;
import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.PurchaseDetail;
import com.enigma.pocket.entity.Purchases;
import com.enigma.pocket.repository.PurchaseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchasesServiceImpl implements PurchasesService{

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    PocketService pocketService;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    CustomMail customMail;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Override
    public Purchases purchase(Purchases purchases,String customerId) throws JsonProcessingException {
        Customer customer = customerService.findCustomerById(customerId);
        purchases.setCustomer(customer);
        purchases.setPurchasesDate(new Date());

        BigDecimal total = BigDecimal.ZERO;


        for (PurchaseDetail purchaseDetail: purchases.getPurchaseDetails()) {
            if (purchases.getPurchaseType().equals(1)){
                Pocket pocket = pocketService.getPocketById(purchaseDetail.getPocket().getId());
                pocketService.topUp(pocket.getId(), purchaseDetail.getQuantityInGram());
                purchaseDetail.setProduct(pocket.getProduct());
                purchaseDetail.setPrice(pocket.getProduct().getProductPriceBuy());
                purchaseDetail.setPurchases(purchases);
            }
            else {
                Pocket pocket = pocketService.getPocketById(purchaseDetail.getPocket().getId());
                pocketService.sellPocket(pocket.getId(), purchaseDetail.getQuantityInGram());
                purchaseDetail.setProduct(pocket.getProduct());
                purchaseDetail.setPrice(pocket.getProduct().getProductPriceSell());
                purchaseDetail.setPurchases(purchases);
            }
            total = total.add(purchaseDetail.getPrice().multiply(new BigDecimal(purchaseDetail.getQuantityInGram())));
        }

//        PurchaseDto purchaseDto = new PurchaseDto();
//        purchaseDto.setEmailTo(customer.getEmail());
//        purchaseDto.setCustomerName(customer.getFirstName()+customer.getLastName());
//        purchaseDto.setTotal(total);
//
//        postDebit(customer, total);
//        String jsonPurchase = objectMapper.writeValueAsString(purchaseDto);
//        kafkaTemplate.send("simple-notification", jsonPurchase);

  //      customMail.sendMail(purchases);


//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(customer.getEmail());
//        message.setSubject("INVOICE GOLD POCKET");
//        message.setText("Berhasil melakukan Pembelian");
//
//        javaMailSender.send(message);

        return purchaseRepository.save(purchases);
    }

//    private void postDebit(Customer customer, BigDecimal total) {
//        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
//                .fromHttpUrl("http://localhost:8095/debit")
//                .queryParam("phoneNumber", customer.getPhoneNumber())
//                .queryParam("amount", total);
//        System.out.println(componentsBuilder.toUriString());
//        restTemplate.exchange(componentsBuilder.toUriString(), HttpMethod.POST,null, Pocket.class);
//    }

    @Override
    public Purchases findPurchaseById(String id) {
        return purchaseRepository.findById(id).get();
    }

    @Override
    public List<Purchases> findAllPurchase() {
        return purchaseRepository.findAll();
    }
}
