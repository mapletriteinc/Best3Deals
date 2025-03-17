package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.Brand;
import com.group5.clients.Best3Deals.exception.ResourceNotFoundException;
import com.group5.clients.Best3Deals.repositories.BrandRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

    @Mock
    private BrandRepository brandRepository;

    @InjectMocks
    private BrandService brandService;

    @Test
    public void testAddBrand() {
        // Arrange
        Brand brand = new Brand(1L, "Apple", "https://apple.com/logo.png");
        when(brandRepository.save(brand)).thenReturn(brand);

        // Act
        Brand savedBrand = brandService.addBrand(brand);

        // Assert
        assertNotNull(savedBrand, "Saved brand should not be null");
        assertEquals("Apple", savedBrand.getName(), "Brand name should match");
        verify(brandRepository, times(1)).save(brand);
    }

    @Test
    public void testFindBrandById() throws ResourceNotFoundException {
        // Arrange
        Brand brand = new Brand(1L, "Apple", "https://apple.com/logo.png");
        when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));

        // Act
        Brand foundBrand = brandService.findBrandById(1L);

        // Assert
        assertNotNull(foundBrand, "Found brand should not be null");
        assertEquals(1L, foundBrand.getId(), "Brand ID should match");
        verify(brandRepository, times(1)).findById(1L);
    }

//    @Test
//    public void testFindBrandByName() {
//        // Arrange
//        Brand brand = new Brand(1L, "Apple", "https://apple.com/logo.png");
//        when(brandRepository.findByName("Apple")).thenReturn(Optional.of(brand));
//
//        // Act
//        Brand foundBrand = brandService.findBrandByName("Apple");
//
//        // Assert
//        assertNotNull(foundBrand, "Found brand should not be null");
//        assertEquals("Apple", foundBrand.getName(), "Brand name should match");
//        verify(brandRepository, times(1)).findByName("Apple");
//    }
//
//    @Test
//    public void testDeleteBrand() {
//        // Arrange
//        doNothing().when(brandRepository).deleteById(1L);
//
//        // Act
//        brandService.deleteBrand(1L);
//
//        // Assert
//        verify(brandRepository, times(1)).deleteById(1L);
//    }

//    @Test
//    public void testUpdateBrand() {
//        // Arrange
////        Brand existingBrand = new Brand(1L, "Apple", "https://apple.com/logo.png");
////        Brand updatedBrand = new Brand(1L, "Apple Inc.", "https://apple.com/new-logo.png");
////        when(brandRepository.findById(1L)).thenReturn(Optional.of(existingBrand));
////        when(brandRepository.save(existingBrand)).thenReturn(updatedBrand);
////
////        // Act
////        Brand result = brandService.updateBrand(1L, updatedBrand);
////
////        // Assert
////        assertNotNull(result, "Updated brand should not be null");
////        assertEquals("Apple Inc.", result.getName(), "Brand name should be updated");
////        verify(brandRepository, times(1)).findById(1L);
////        verify(brandRepository, times(1)).save(existingBrand);
////    }
}