package com.enigma.pocket.service;

import com.enigma.pocket.constant.AppConfigConstant;
import com.enigma.pocket.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;

@Service
public class WalletServiceImpl implements WalletService{
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppConfigService appConfigService;

    @Override
    public void sendWallet(Customer customer, BigDecimal total) {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromHttpUrl(appConfigService.getValue(AppConfigConstant.OPO_WALLET_ENDPOINT_URL))
                .queryParam("phoneNumber", customer.getPhoneNumber())
                .queryParam("amount", total);
        System.out.println(componentsBuilder.toUriString());
        restTemplate.exchange(componentsBuilder.toUriString(), HttpMethod.POST, null, String.class);
    }
}
