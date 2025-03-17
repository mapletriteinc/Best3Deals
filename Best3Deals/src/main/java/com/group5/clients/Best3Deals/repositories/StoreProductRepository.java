package com.group5.clients.Best3Deals.repositories;

import com.group5.clients.Best3Deals.entities.StoreProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreProductRepository extends JpaRepository<StoreProduct, Long> {
    @Query("SELECT sp FROM StoreProduct sp WHERE sp.product.name = :productName")
    List<StoreProduct> findByProductName(@Param("productName") String productName);
}