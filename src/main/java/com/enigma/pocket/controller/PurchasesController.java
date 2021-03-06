package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Purchases;
import com.enigma.pocket.repository.PurchaseRepository;
import com.enigma.pocket.service.PurchasesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PurchasesController {

    @Autowired
    PurchasesService purchasesService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @PostMapping(path = "/purchase", produces = "application/json")
    public Purchases purchases(@RequestParam(name = "customerId") String customerId,
                               @RequestBody Purchases purchases) throws JsonProcessingException {
        return purchasesService.purchase(purchases, customerId);
    }

    @GetMapping(path = "/purchase", produces = "application/json")
    public List<Purchases> getAllPurchase(){
        return purchasesService.findAllPurchase();
    }

    @GetMapping(path = "/purchase/{id}", produces = "application/json")
    public List<Purchases> getPurchaseByCustomerId(@PathVariable(name = "id") String id) {
        return purchaseRepository.findPurchaseHistoryByCustomerId(id);
    }
}
