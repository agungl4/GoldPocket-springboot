package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Purchases;
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

    @PostMapping("/purchase")
    public Purchases purchases(@RequestParam(name = "customerId") String customerId,
                               @RequestBody Purchases purchases) throws JsonProcessingException {
        return purchasesService.purchase(purchases, customerId);
    }

    @GetMapping("/purchase")
    public List<Purchases> getAllPurchase(){
        return purchasesService.findAllPurchase();
    }
}
