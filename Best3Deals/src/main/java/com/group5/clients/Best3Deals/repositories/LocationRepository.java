package com.group5.clients.Best3Deals.repositories;

import com.group5.clients.Best3Deals.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    // Custom query methods can be added here if needed
}
