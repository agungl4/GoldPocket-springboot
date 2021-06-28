package com.enigma.pocket.repository;

import com.enigma.pocket.entity.Purchases;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchases, String> {

}
