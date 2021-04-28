package com.enigma.pocket.controller;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Purchase;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class PocketRestController {
    @Autowired
    PocketService pocketService;

    @PostMapping("/pocket")
    public Pocket addNewPocket(@RequestBody Pocket pocket){
       return pocketService.createNewPocket(pocket);
    }

    @GetMapping("/pocket/{id}")
    public Pocket getCustomerById(@PathVariable(name = "id") String id){
        return pocketService.findPocketById(id);
    }

//    @GetMapping("/purchases")
//    public Page<Pocket> getCustomers(@RequestParam(name = "page", defaultValue = "0") Integer page,
//                                       @RequestParam(name = "size", defaultValue = "5") Integer size){
//        PageRequest pageRequest = PageRequest.of(page,size);
//        return pocketService.f(pageRequest);
//    }
    //@PostMapping("/pockets")
//    public void addNewPocket(@RequestBody Pocket pocket){
//        pocketService.createNewPocket(pocket);
//    }
}
