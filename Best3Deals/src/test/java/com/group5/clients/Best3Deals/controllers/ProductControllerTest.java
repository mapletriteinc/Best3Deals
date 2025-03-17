package com.group5.clients.Best3Deals.controllers;

import com.group5.clients.Best3Deals.entities.*;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.services.StoreProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
    public class ProductControllerTest {

        @Mock
        private StoreProductService storeService;

        @InjectMocks
        private StoreProductController storeController;

    @Test
    public void testGetBestDeals() {
        List<StoreProduct> productDeals = List.of(
                new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                        new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                        new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                        "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now())
        );
        ApiListResponse<StoreProduct> expectedResponse = new ApiListResponse<>(productDeals);

        when(storeService.getBestDeals()).thenReturn(expectedResponse);

        ResponseEntity<ApiListResponse<StoreProduct>> response = storeController.getBestDeals(true);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        verify(storeService, times(1)).getBestDeals();
    }



    }