package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.*;
import com.group5.clients.Best3Deals.product.response.SearchProductResponse;
import com.group5.clients.Best3Deals.repositories.StoreProductRepository;
import com.group5.clients.Best3Deals.repositories.StoreRepository;
import com.group5.clients.Best3Deals.response.ApiListResponse;
import com.group5.clients.Best3Deals.response.ApiResponse;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoreProductService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private StoreProductRepository storeProductsRepository;

    public SearchProductResponse getStoreProductsWithinDistance(
            String productName, Double latitude, Double longitude, Double distanceInKm) {

        // Step 1: Find stores within the specified distance
        List<Store> storesWithinDistance = storeRepository.findStoresWithinDistance(latitude, longitude, distanceInKm);

        // Step 2: Fetch all StoreProducts for the given product name
        List<StoreProduct> storeProducts = storeProductsRepository.findByProductName(productName);

        // Step 3: Filter StoreProducts to include only those from stores within the distance
        List<StoreProduct> filteredProducts = storeProducts.stream()
                .filter(sp -> storesWithinDistance.contains(sp.getStore()))
                .collect(Collectors.toList());

        // Sort products by price in ascending order
        filteredProducts.sort(Comparator.comparingDouble(p -> p.getPrice()));

        // Get the three cheapest products (or all if there are three or fewer)
        List<StoreProduct> leastPriceProducts = filteredProducts.size() <= 3 ? filteredProducts : filteredProducts.subList(0, 3);
        return new SearchProductResponse(leastPriceProducts.size(), leastPriceProducts);
       // return new SearchProductResponse(filteredProducts.size(), filteredProducts);//Collections.unmodifiableList(filteredProducts); // Return an immutable list

    }

        public ApiListResponse<StoreProduct> getBestDeals() {
                List<StoreProduct> productDeals = Arrays.asList(
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now()),
                        // Add other product deals similarly
                        new StoreProduct(2L, new Product(2L, new Category(1L, "Electronics"), "Apple iPhone 13", "Latest iPhone with A15 Bionic chip"),
                                new Store(1L, "Best Buy Halifax", "123 Main St, Halifax, NS", new Location(1L, 44.6488, -63.5752, null)),
                                new Brand(3L, "Apple", "https://www.apple.com/logo.png"), new Flyer(), 1099.99, 1199.99, 30,
                                "https://www.bestbuy.com/iphone-13", LocalDateTime.now(), LocalDateTime.now())
                );

                return new ApiListResponse<>(productDeals);
            }

    public StoreProduct addStoreProduct(StoreProduct storeProduct) {
        return null;
    }

    public SearchProductResponse getStoreProductsWithinDistance3Deals(String productName, Double latitude, Double longitude, Double distanceInKm) {
            // Step 1: Find stores within the specified distance
            List<Store> storesWithinDistance = storeRepository.findStoresWithinDistance(latitude, longitude, distanceInKm);

            // Step 2: Fetch all StoreProducts for the given product name
            List<StoreProduct> storeProducts = storeProductsRepository.findByProductName(productName);

            // Step 3: Filter StoreProducts to include only those from stores within the distance
            List<StoreProduct> filteredProducts = storeProducts.stream()
                    .filter(sp -> storesWithinDistance.contains(sp.getStore()))
                    .collect(Collectors.toList());

            return new SearchProductResponse(filteredProducts.size(), filteredProducts);
            // return new SearchProductResponse(filteredProducts.size(), filteredProducts);//Collections.unmodifiableList(filteredProducts); // Return an immutable list

        }
}

