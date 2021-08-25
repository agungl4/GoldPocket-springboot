package com.enigma.pocket.controller;

import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.repository.PocketRepository;
import com.enigma.pocket.service.PocketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PocketController {
    @Autowired
    PocketService pocketService;

    @Autowired
    PocketRepository pocketRepository;

    @GetMapping("/pocket/{id}")
    public Pocket getPocketId(@PathVariable(name = "id") String id){
        return pocketService.getPocketById(id);
    }

    @PostMapping("/pocket")
    public Pocket createPocket(@RequestBody Pocket pocket) {
        return pocketService.createNewPocket(pocket);
    }

    @GetMapping("/customer/{id}/pockets")
    public List<Pocket> getCustomerPocket(@PathVariable(name = "id") String id){
        return pocketRepository.findPocketByCustomerId(id);
    }

    @DeleteMapping("/pocket/{id}")
    public String deletePocketById(@PathVariable(name = "id") String id) {
        pocketService.deletePocket(id);
        return "pocket " + id + " berhasil dihapus";
    }

    @PutMapping("/pocket")
    public Pocket updatePocket(@RequestBody Pocket pocket) { return pocketService.updatePocket(pocket); }


}