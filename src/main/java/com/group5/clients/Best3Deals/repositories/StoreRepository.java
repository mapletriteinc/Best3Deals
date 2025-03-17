package com.group5.clients.Best3Deals.repositories;

import com.group5.clients.Best3Deals.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query(value = "SELECT s FROM Store s WHERE " +
            "6371 * acos(cos(radians(:latitude)) * cos(radians(s.location.latitude)) * " +
            "cos(radians(s.location.longitude) - radians(:longitude)) + " +
            "sin(radians(:latitude)) * sin(radians(s.location.latitude))) <= :distance")
    List<Store> findStoresWithinDistance(
            @Param("latitude") Double latitude,
            @Param("longitude") Double longitude,
            @Param("distance") Double distance
    );

    Optional<Store> findByName(String bestBuy);
}