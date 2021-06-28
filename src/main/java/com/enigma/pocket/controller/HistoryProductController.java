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

    @GetMapping("/history/{id}")
    public List<HistoryProduct> getHistoryId(@PathVariable(name = "id") String id){
        System.out.println(id);
        return historyProductService.findProductById(id);
    }

    @GetMapping("/history")
    public List<HistoryProduct> getAllHistory(){
        return historyProductService.findProductAll();
    }

    @PostMapping("/history/insert")
    public void createNewHistory(@RequestBody HistoryProduct historyProduct){
        historyProductService.logPrice(historyProduct);
    }

    @PutMapping("/history/update")
    public void updateProductId(@RequestBody HistoryProduct historyProduct){
        historyProductService.updateProduct(historyProduct);
    }

    @DeleteMapping("/history/delete/{id}")
    public void deleteId(@PathVariable(name = "id") String id){
        historyProductService.deleteProduct(id);
    }
}
