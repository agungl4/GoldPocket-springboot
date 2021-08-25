package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;
import com.enigma.pocket.entity.Pocket;
import com.enigma.pocket.entity.Product;
import com.enigma.pocket.repository.PocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PocketServicelmpl implements PocketService{
    @Autowired
    PocketRepository pocketRepository;

    @Autowired
    CustomerService customerService;

    @Autowired
    ProductService productService;

    @Override
    public Pocket getPocketById(String id) {
        Pocket pocket = pocketRepository.findById(id).get();
        return pocket;
    }

    @Override
    public List<Pocket> findAllPocket() {
        return pocketRepository.findAll();
    }

    @Override
    public Pocket createNewPocket(Pocket pocket) {
        pocket.setCustomer(customerService.findCustomerById(pocket.getCustomer().getId()));
        pocket.setProduct(productService.findProductById(pocket.getProduct().getIdProduct()));
        return pocketRepository.save(pocket);
    }

    @Override
    public void topUp(String id, Double qty) {
        Pocket pocket = getPocketById(id);
        pocket.setPocketQty(pocket.getPocketQty()+qty);
        pocketRepository.save(pocket);
    }

    @Override
    public void sellPocket(String id, Double qty) {
        Pocket pocket = getPocketById(id);
        pocket.setPocketQty(pocket.getPocketQty() - qty);
        pocketRepository.save(pocket);
    }

    @Override
    public Pocket updatePocket(Pocket pocket) {
        pocket.setCustomer(customerService.findCustomerById(pocket.getCustomer().getId()));
        pocket.setProduct(productService.findProductById(pocket.getProduct().getIdProduct()));
        pocket.setPocketQty(pocket.getPocketQty());
//        pocket.setTotalPrice(pocket.getPocketQty() * product.getProductPriceBuy());
        return pocketRepository.save(pocket);
    }

    @Override
    public void deletePocket(String pocketId) {
        pocketRepository.deleteById(pocketId);
    }

}
