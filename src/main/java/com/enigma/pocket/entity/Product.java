package com.enigma.pocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "m_products")
public class Product {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String idProduct;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_image")
    private String productImage;

    @Column(name = "product_price_buy")
    private BigDecimal productPriceBuy;

    @Column(name = "product_price_sell")
    private BigDecimal productPriceSell;

    @Column(name = "product_status")
    private Integer productStatus;

    @OneToMany(mappedBy = "product")
    //@JsonIgnore
    private List<HistoryProduct> historyProducts = new ArrayList<>();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date created_at;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updated_at;

    public Product() {

    }

    public String getIdProduct() {
        return idProduct;
    }

    public Product(Date created_at, Date updated_at) {
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public BigDecimal getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(BigDecimal productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public List<HistoryProduct> getHistoryProducts() {
        return historyProducts;
    }

    public void setHistoryProducts(List<HistoryProduct> historyProducts) {
        this.historyProducts = historyProducts;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", productPriceBuy=" + productPriceBuy +
                ", productPriceSell=" + productPriceSell +
                ", productStatus=" + productStatus +
                ", created_at=" + created_at +
                ", update_at=" + updated_at +
                '}';
    }
}
