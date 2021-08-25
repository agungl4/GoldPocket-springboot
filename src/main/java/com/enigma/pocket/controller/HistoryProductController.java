package com.enigma.pocket.controller;

import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.service.HistoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HistoryProductController {

    @Autowired
    HistoryProductService historyProductService;

    @GetMapping(path = "/history/{id}", produces = "application/json")
    public List<HistoryProduct> getHistoryId(@PathVariable(name = "id") String id){
        return historyProductService.findProductById(id);
    }

    @GetMapping(path = "/history", produces = "application/json")
    public List<HistoryProduct> getAllHistory(){
        return historyProductService.findProductAll();
    }

    @PostMapping(path = "/history/insert", produces = "application/json")
    public void createNewHistory(@RequestBody HistoryProduct historyProduct){
        historyProductService.logPrice(historyProduct);
    }

    @PutMapping(path = "/history/update", produces = "application/json")
    public void updateProductId(@RequestBody HistoryProduct historyProduct){
        historyProductService.updateProduct(historyProduct);
    }

    @DeleteMapping(path = "/history/delete/{id}", produces = "application/json")
    public void deleteId(@PathVariable(name = "id") String id){
        historyProductService.deleteProduct(id);
    }
}
