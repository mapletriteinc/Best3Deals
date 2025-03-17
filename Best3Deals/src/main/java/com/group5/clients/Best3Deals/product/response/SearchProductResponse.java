package com.group5.clients.Best3Deals.product.response;

import com.group5.clients.Best3Deals.entities.StoreProduct;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchProductResponse {
    private int size;
    private List<StoreProduct> productList;

}
