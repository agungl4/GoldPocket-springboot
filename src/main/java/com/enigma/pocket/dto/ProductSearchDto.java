package com.enigma.pocket.dto;

import java.sql.Date;

public class ProductSearchDto {
    private String id;
    private String product_name;
    private Integer product_price_buy;
    private Integer product_price_sell;
    private String product_image;
    private Integer product_status;
    private Date created_at;
    private Date update_at;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Integer getProduct_price_buy() {
        return product_price_buy;
    }

    public void setProduct_price_buy(Integer product_price_buy) {
        this.product_price_buy = product_price_buy;
    }

    public Integer getProduct_price_sell() {
        return product_price_sell;
    }

    public void setProduct_price_sell(Integer product_price_sell) {
        this.product_price_sell = product_price_sell;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Integer getProduct_status() {
        return product_status;
    }

    public void setProduct_status(Integer product_status) {
        this.product_status = product_status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
}
