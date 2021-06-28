package com.enigma.pocket.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Prices {

    private BigDecimal productPriceSell;
    private BigDecimal productPriceBuy;

    public Prices() {

    }

    public Prices(BigDecimal productPriceSell, BigDecimal getProductPriceBuy) {
        this.productPriceSell = productPriceSell;
        this.productPriceBuy = getProductPriceBuy;
    }

    public BigDecimal getProductPriceSell() {
        return productPriceSell;
    }

    public void setProductPriceSell(BigDecimal productPriceSell) {
        this.productPriceSell = productPriceSell;
    }

    public BigDecimal getProductPriceBuy() {
        return productPriceBuy;
    }

    public void setProductPriceBuy(BigDecimal productPriceBuy) {
        this.productPriceBuy = productPriceBuy;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Prices prices = (Prices) o;
        return Objects.equals(productPriceSell, prices.productPriceSell);
//                Objects.equals(productPriceBuy, prices.productPriceBuy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productPriceSell, productPriceBuy);
    }
}
