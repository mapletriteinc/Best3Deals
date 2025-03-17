package com.group5.clients.Best3Deals.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SearchController.class)
public class SearchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchWithBlankQuery() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", ""))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSearchWithInvalidLongitude() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", "macbook")
                        .param("longitude", "200"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSearchWithInvalidLatitude() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", "macbook")
                        .param("latitude", "100"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testSearchWithNegativeRadius() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", "macbook")
                        .param("radius", "-5"))
                .andExpect(status().isBadRequest());
    }
    @Test
    public void testSearch_ValidParameters() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", "macbook")
                        .param("longitude", "10")
                        .param("latitude", "10")
                        .param("radius", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("Searching for: macbook with radius: 10.0"));
    }
    @Test
    public void testSearch_DefaultRadius() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", "macbook")
                        .param("longitude", "10")
                        .param("latitude", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("Searching for: macbook with radius: 10.0"));
    }
    @Test
    public void testSearch_BoundaryCoordinates() throws Exception {
        mockMvc.perform(get("/api/search")
                        .param("query", "macbook")
                        .param("longitude", "-180")
                        .param("latitude", "-90")
                        .param("radius", "10"))
                .andExpect(status().isOk())
                .andExpect(content().string("Searching for: macbook with radius: 10.0"));
    }
}


