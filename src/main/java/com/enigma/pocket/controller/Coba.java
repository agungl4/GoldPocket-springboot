package com.enigma.pocket.controller;

import com.enigma.pocket.dto.Car;
import com.enigma.pocket.dto.Engine;
import com.enigma.pocket.format.WrapperMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coba {
    @GetMapping("/coba")
    public ResponseEntity<WrapperMessage> getCar(){
        Engine engine = new Engine("tyota");
        Car car = new Car("apa",engine);
        return ResponseEntity.accepted().body(WrapperMessage.commonResponse(11, car));
    }
//    @GetMapping("/coba")
//    public void print(@RequestBody Car car){
//        System.out.println(car);
//    }
}
