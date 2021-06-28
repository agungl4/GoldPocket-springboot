package com.enigma.pocket.format;

import java.time.LocalDateTime;

public class ResponseMessage<T> {
    private Integer responseCode;
    private String descriptio;
    private LocalDateTime timestamp;
    private T data;

    public ResponseMessage(Integer responseCode, String descriptio, T data) {
        this.responseCode = responseCode;
        this.descriptio = descriptio;
        this.data = data;
    }

    public static <T> ResponseMessage<T> commonResponse(Integer code, T data){
        return new ResponseMessage<>(code,"Succes",data);
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescriptio() {
        return descriptio;
    }

    public void setDescriptio(String descriptio) {
        this.descriptio = descriptio;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
