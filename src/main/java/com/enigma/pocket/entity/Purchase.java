package com.enigma.pocket.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_purchases")
public class Purchase {
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private Date purchaseDate;
    @ManyToOne // custmer
    private Customer customer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.PERSIST)
    @JsonIgnoreProperties({"purchase"})
    private Set<PurchaseDetail> purchaseDetails = new HashSet<>();


    public Set<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(Set<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}