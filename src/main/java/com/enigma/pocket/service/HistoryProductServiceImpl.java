package com.enigma.pocket.service;

import com.enigma.pocket.entity.HistoryProduct;
import com.enigma.pocket.repository.HistoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryProductServiceImpl implements com.enigma.pocket.service.HistoryProductService {

    @Autowired
    HistoryProductRepository historyProductRepository;


    @Override
    public List<HistoryProduct> findProductById(String id) {
        List<HistoryProduct> historyProduct = historyProductRepository.findHistoryProductById(id);
        return historyProduct;
    }

    @Override
    public List<HistoryProduct> findProductAll() {
        return historyProductRepository.findAll();
    }

    @Override
    public void logPrice(HistoryProduct historyProduct) {
        historyProductRepository.save(historyProduct);
    }

    @Override
    public void updateProduct(HistoryProduct historyProduct) {
        historyProductRepository.save(historyProduct);
    }

    @Override
    public void deleteProduct(String id) {
        historyProductRepository.deleteById(id);
    }
}
