package com.group5.clients.Best3Deals.controllers;
import com.group5.clients.Best3Deals.entities.Brand;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.services.BrandService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class
BrandControllerTest {

    @Mock
    private BrandService brandService;

    @InjectMocks
    private BrandController brandController;

    @Test
    public void testGetAllBrands() {
        // Mock data
        Brand brand1 = new Brand(1L, "Brand1", "http://example.com/brand1.jpg");
        Brand brand2 = new Brand(2L, "Brand2", "http://example.com/brand2.jpg");
        List<Brand> brands = Arrays.asList(brand1, brand2);
        ApiListResponse<Brand> mockResponse = new ApiListResponse<>(brands);

        // Mock service behavior
        when(brandService.getAllBrands()).thenReturn(mockResponse);

        // Call controller method
        ApiListResponse<Brand> response = brandController.getAllBrands();

        // Assertions
        assertEquals(true, response.isSuccess());
        assertEquals("Success", response.getMessage());
        assertEquals(2, response.getData().size());
    }
}