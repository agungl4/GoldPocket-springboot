package com.enigma.pocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "m_history_prices")
public class HistoryProduct {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;


    private Date history_date;

    private BigDecimal price_buy;
    private BigDecimal price_sell;


    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties({"historyProducts"})
    private Product product;

//    @Transient
//    private String product_id;

    public HistoryProduct(){

    }

    public HistoryProduct(Product product) {
        this.history_date = product.getUpdated_at();
        this.price_buy = product.getProductPriceBuy();
        this.price_sell = product.getProductPriceSell();
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getHistory_date() {
        return history_date;
    }

    public void setHistory_date(Date history_date) {
        this.history_date = history_date;
    }

    public BigDecimal getPrice_buy() {
        return price_buy;
    }

    public void setPrice_buy(BigDecimal price_buy) {
        this.price_buy = price_buy;
    }

    public BigDecimal getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(BigDecimal price_sell) {
        this.price_sell = price_sell;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
