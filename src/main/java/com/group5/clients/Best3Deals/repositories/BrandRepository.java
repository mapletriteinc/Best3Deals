package com.group5.clients.Best3Deals.repositories;

import com.group5.clients.Best3Deals.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    Object findByName(String apple);
}
