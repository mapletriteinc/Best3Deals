package com.group5.clients.Best3Deals.controllers;

import com.group5.clients.Best3Deals.entities.StoreProduct;
import com.group5.clients.Best3Deals.product.response.SearchProductResponse;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.response.ApiResponse;
import com.group5.clients.Best3Deals.services.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoreProductController {

    @Autowired
    private StoreProductService storeProductService;
    @GetMapping("/store-products/nearby")
    public ResponseEntity<SearchProductResponse> getBest3DealsNearbyStoreProducts(
            @RequestParam String productName,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double distanceInKm) {
        // Return the result as a ResponseEntity with HTTP status 200 (OK)
        SearchProductResponse spr = storeProductService.getStoreProductsWithinDistance3Deals(productName, latitude, longitude, distanceInKm);
     //   return ResponseEntity.ok(new ApiResponse<>(spr.getSize() > 0, spr));
        return ResponseEntity.ok(spr);
    }

    @GetMapping("/store-products/nearby/best3deals")
    public ResponseEntity<SearchProductResponse> getNearbyStoreProducts(
            @RequestParam String productName,
            @RequestParam Double latitude,
            @RequestParam Double longitude,
            @RequestParam Double distanceInKm) {
        // Return the result as a ResponseEntity with HTTP status 200 (OK)
        SearchProductResponse spr = storeProductService.getStoreProductsWithinDistance(productName, latitude, longitude, distanceInKm);
        //   return ResponseEntity.ok(new ApiResponse<>(spr.getSize() > 0, spr));
        return ResponseEntity.ok(spr);
    }
//@Autowired
//private StoreProductService storeProductService;

    @GetMapping("/best")
    public ResponseEntity<ApiListResponse<StoreProduct>> getBestDeals(@RequestParam(required = false) boolean includeDeals) {
        if (includeDeals) {
            return ResponseEntity.ok(storeProductService.getBestDeals());
        } else {
            return ResponseEntity.ok(new ApiListResponse<>(List.of()));
        }
    }
}
