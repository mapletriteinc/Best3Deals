package com.group5.clients.Best3Deals.controllers;

import com.group5.clients.Best3Deals.entities.Brand;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.response.ApiResponse;
import com.group5.clients.Best3Deals.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ApiListResponse<Brand> getAllBrands() {
        return brandService.getAllBrands();
    }
}