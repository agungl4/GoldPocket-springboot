package com.enigma.pocket.service;

import com.enigma.pocket.entity.Customer;

import java.math.BigDecimal;

public interface WalletService {
    public void sendWallet(Customer customer, BigDecimal total);
}
