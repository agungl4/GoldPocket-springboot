package com.enigma.pocket.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "data not found on the server")
public class NotFoundException extends RuntimeException{

    Integer status;
    String message;

    public NotFoundException(Integer status, String message){
        super(message);
        this.status = status;
        this.message = message;
    }
}
