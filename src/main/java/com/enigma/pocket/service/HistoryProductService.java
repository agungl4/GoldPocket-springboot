package com.enigma.pocket.service;

import com.enigma.pocket.entity.HistoryProduct;

import java.util.List;

public interface HistoryProductService {
    public List<HistoryProduct> findProductById(String id);
    public List<HistoryProduct> findProductAll();
    public void logPrice(HistoryProduct historyProduct);
    public void updateProduct(HistoryProduct historyProduct);
    public void deleteProduct(String id);
}
