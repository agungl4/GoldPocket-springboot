package com.enigma.pocket.controller;

import com.enigma.pocket.dto.Car;
import com.enigma.pocket.dto.Engine;
import com.enigma.pocket.dto.WalletDto;
import com.enigma.pocket.format.WrapperMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

@RestController
public class Coba {
//    @GetMapping("/coba")
//    public ResponseEntity<WrapperMessage> getCar(){
//        Engine engine = new Engine("tyota");
//        Car car = new Car("apa",engine);
//        return ResponseEntity.accepted().body(WrapperMessage.commonResponse(11, car));
//    }
//    @GetMapping("/coba")
//    public void print(@RequestBody Car car){
//        System.out.println(car);
//    }

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/coba")
    public ResponseEntity<WalletDto> getCar(){
        WalletDto walletDto = new WalletDto("08986451451", BigDecimal.ZERO);
        ResponseEntity<WalletDto> response = restTemplate.postForEntity(URI.create("http://localhost:8090/wallet"),walletDto,WalletDto.class);
        System.out.println(response.getBody());
        return response;
    }
}
