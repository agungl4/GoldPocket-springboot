package com.enigma.pocket.dto;

import java.time.LocalDateTime;

public class HistoryProductSearchDto {
    private String id;
    private LocalDateTime history_date;
    private Integer price_buy;
    private Integer price_sell;
    private String  product_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getHistory_date() {
        return history_date;
    }

    public void setHistory_date(LocalDateTime history_date) {
        this.history_date = history_date;
    }

    public Integer getPrice_buy() {
        return price_buy;
    }

    public void setPrice_buy(Integer price_buy) {
        this.price_buy = price_buy;
    }

    public Integer getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(Integer price_sell) {
        this.price_sell = price_sell;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
