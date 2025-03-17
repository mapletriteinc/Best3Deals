package com.group5.clients.Best3Deals.flyer.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlyerResponse {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private Long storeId;
}
