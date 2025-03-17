package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.*;
import com.group5.clients.Best3Deals.repositories.StoreProductRepository;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class StoreProductServiceTests {
    @InjectMocks
    private  StoreProductService storeProductService;
    @Autowired
    private StoreProductRepository storeProductRepository;
    @Test
    public void testGetBestDeals() {

        StoreProductService storeProductService = new StoreProductService();
        ApiListResponse<StoreProduct> response = storeProductService.getBestDeals();
        assertNotNull(response, "Response should not be null");
        List<StoreProduct> productDeals = response.getData();
        assertNotNull(productDeals, "Product deals list should not be null");
        assertFalse(productDeals.isEmpty(), "Product deals list should not be empty");
        StoreProduct firstProductDeal = productDeals.get(0);
        assertNotNull(firstProductDeal, "First product deal should not be null");
        assertEquals(2L, firstProductDeal.getId(), "Product ID should match");
        assertEquals("Apple iPhone 13", firstProductDeal.getProduct().getName(), "Product name should match");
        assertEquals("Best Buy Halifax", firstProductDeal.getStore().getName(), "Store name should match");
        assertEquals("Apple", firstProductDeal.getBrand().getName(), "Brand name should match");
        assertEquals(1099.99, firstProductDeal.getPrice(), "Bonus Sale price should match");
        assertEquals(1199.99, firstProductDeal.getPreviousPrice(), "Regular price should match");
        assertEquals(30, firstProductDeal.getQuantityInStock(), "The quantity must match");
        assertEquals("https://www.bestbuy.com/iphone-13", firstProductDeal.getProductUrl(), "Product URL should match");
    }
//    @Test
//    public void testAddStoreProductWithParentEntities() {
//        // Arrange
//        Product product = new Product(1L, new Category(1L, "Electronics"), "iPhone 13", "Latest iPhone");
//        Store store = new Store(1L, "Best Buy", "123 Main St", new Location(1L, 44.6488, -63.5752, null));
//        Brand brand = new Brand(1L, "Apple", "https://apple.com/logo.png");
//        StoreProduct storeProduct = new StoreProduct(1L, product, store, brand, new Flyer(), 1099.99, 1199.99, 30,
//                "https://bestbuy.com/iphone13", LocalDateTime.now(), LocalDateTime.now());
//
//        when(storeProductRepository.save(storeProduct)).thenReturn(storeProduct);
//
//        // Act
//        StoreProduct savedStoreProduct = storeProductService.addStoreProduct(storeProduct);
//
//        // Assert
//        assertNotNull(savedStoreProduct, "Saved StoreProduct should not be null");
//        assertEquals("iPhone 13", savedStoreProduct.getProduct().getName(), "Product name should match");
//        assertEquals("Best Buy", savedStoreProduct.getStore().getName(), "Store name should match");
//        assertEquals("Apple", savedStoreProduct.getBrand().getName(), "Brand name should match");
//        verify(storeProductRepository, times(1)).save(storeProduct);
//    }
}

