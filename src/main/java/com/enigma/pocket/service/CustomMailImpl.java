package com.enigma.pocket.service;

import com.enigma.pocket.entity.Purchases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomMailImpl implements CustomMail{
    @Autowired
    JavaMailSender javaMailSender;

    @Value("agung.arifnur@gmail.com")
    private String sender;

    @Override
    public void sendMail(Purchases purchases) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(purchases.getCustomer().getEmail());
        message.setSubject("INVOICE GOLD POCKET");
        message.setText("Berhasil melakukan Pembelian");

        javaMailSender.send(message);
    }
}
