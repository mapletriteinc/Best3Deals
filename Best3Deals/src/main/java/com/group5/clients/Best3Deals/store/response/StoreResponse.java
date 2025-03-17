package com.group5.clients.Best3Deals.store.response;


import com.group5.clients.Best3Deals.entities.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StoreResponse {
    private Long id;
    private String name;
    private String address;
    private Location location;
    private Long brandId;
}
