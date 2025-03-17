package com.group5.clients.Best3Deals.controllers;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class SearchController {
    @GetMapping("/search")
    public ResponseEntity<String> search(
            @RequestParam @NotBlank String query,
            @RequestParam(defaultValue = "10") @Min(-180) @Max(180) double longitude,
            @RequestParam(defaultValue = "10") @Min(-90) @Max(90) double latitude,
            @RequestParam(defaultValue = "10") @Positive double radius
    ) {
        // Handle the GET request with query parameters here
        return ResponseEntity.ok("Searching for: " + query + " with radius: " + radius);
    }
    @GetMapping("/search-by-flyer")
    public ResponseEntity<String> searchByFlyer(@RequestParam String query, @RequestParam(defaultValue = "10") double longitude,@RequestParam(defaultValue = "10") double latitude,
                                         @RequestParam(defaultValue = "10") double radius) {
        // Handle the GET request with query parameters here
        return ResponseEntity.ok("Searching for: " + query + " with limit: " + radius);
    }
}
