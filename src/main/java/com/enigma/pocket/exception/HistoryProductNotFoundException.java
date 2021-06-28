package com.enigma.pocket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HistoryProductNotFoundException extends RuntimeException{
    public HistoryProductNotFoundException(String message){
        super(message);
    }
}
