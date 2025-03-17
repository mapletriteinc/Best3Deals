package com.group5.clients.Best3Deals.services;
import com.group5.clients.Best3Deals.exception.ResourceNotFoundException;
import com.group5.clients.Best3Deals.entities.Brand;
import com.group5.clients.Best3Deals.repositories.BrandRepository;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BrandService {
    @Autowired
BrandRepository brandRepository;
    public ApiListResponse<Brand> getAllBrands() {
        // Simulate fetching data from a database or external service
        List<Brand> brands = Arrays.asList(
                new Brand(1L, "hp", "http://example.com/hp.jpg"),
                new Brand(2L, "apple", "http://example.com/apple.jpg")
        );

        return new ApiListResponse<>(brands);
    }

    public Brand addBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    public Brand findBrandById(long id) throws ResourceNotFoundException {
        return brandRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("No category with input: "+ id));
    }

    public Brand findBrandByName(String apple) {
        return null;
    }

    public void deleteBrand(long l) {
    }

    public Brand updateBrand(long l, Brand updatedBrand) {
        return null;
    }
}
