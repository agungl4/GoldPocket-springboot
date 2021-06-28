package com.enigma.pocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_purchases")
public class Purchases {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "purchase_id")
    private String idPurchases;
    private Date purchaseDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "purchases",cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties("purchases")
    private Set<PurchaseDetail> purchaseDetails = new HashSet<>();

    private Integer purchaseType;

    public String getIdPurchases() {
        return idPurchases;
    }

    public void setIdPurchases(String idPurchases) {
        this.idPurchases = idPurchases;
    }

    public Date getPurchasesDate() {
        return purchaseDate;
    }

    public void setPurchasesDate(Date purchasesDate) {
        this.purchaseDate = purchasesDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(Set<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }



    public Integer getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(Integer purchaseType) {
        this.purchaseType = purchaseType;
    }
}
