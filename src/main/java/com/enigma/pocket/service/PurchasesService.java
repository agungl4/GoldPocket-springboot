package com.enigma.pocket.service;

import com.enigma.pocket.entity.Purchases;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PurchasesService {
    public Purchases purchase(Purchases purchases,String customerId) throws JsonProcessingException;
    public Purchases findPurchaseById(String id);
    public List<Purchases> findAllPurchase();
}
