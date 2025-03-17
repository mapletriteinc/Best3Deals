package com.group5.clients.Best3Deals.controllers;

import com.group5.clients.Best3Deals.entities.StoreProduct;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.services.StoreProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private StoreProductService productService;

    @GetMapping("/best-deals")
    public ApiListResponse<StoreProduct> getBestDeals() {
        return productService.getBestDeals();
    }
}
