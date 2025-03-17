package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.Flyer;
import com.group5.clients.Best3Deals.repositories.FlyerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FlyerServiceTest {

    @Mock
    private FlyerRepository flyerRepository;

    @InjectMocks
    private FlyerService flyerService;
//
//    @Test
//    public void testAddFlyer() {
//        // Arrange
//        Flyer flyer = new Flyer(1L, "Summer Sale", "https://flyer.com/summer-sale","");
//        when(flyerRepository.save(flyer)).thenReturn(flyer);
//
//        // Act
//        Flyer savedFlyer = flyerService.addFlyer(flyer);
//
//        // Assert
//        assertNotNull(savedFlyer, "Saved flyer should not be null");
//        assertEquals("Summer Sale", savedFlyer.getName(), "Flyer name should match");
//        verify(flyerRepository, times(1)).save(flyer);
//    }
//
//    @Test
//    public void testFindFlyerById() {
//        // Arrange
//        Flyer flyer = new Flyer(1L, "Summer Sale", "https://flyer.com/summer-sale", "");
//        when(flyerRepository.findById(1L)).thenReturn(Optional.of(flyer));
//
//        // Act
//        Flyer foundFlyer = flyerService.findFlyerById(1L);
//
//        // Assert
//        assertNotNull(foundFlyer, "Found flyer should not be null");
//        assertEquals(1L, foundFlyer.getId(), "Flyer ID should match");
//        verify(flyerRepository, times(1)).findById(1L);
//    }
//
//    @Test
//    public void testDeleteFlyer() {
//        // Arrange
//        doNothing().when(flyerRepository).deleteById(1L);
//
//        // Act
//        flyerService.deleteFlyer(1L);
//
//        // Assert
//        verify(flyerRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testUpdateFlyer() {
//        // Arrange
//        Flyer existingFlyer = new Flyer(1L, "Summer Sale", "https://flyer.com/summer-sale","");
//        Flyer updatedFlyer = new Flyer(1L, "Winter Sale", "https://flyer.com/winter-sale","");
//        when(flyerRepository.findById(1L)).thenReturn(Optional.of(existingFlyer));
//        when(flyerRepository.save(existingFlyer)).thenReturn(updatedFlyer);
//
//        Flyer result = flyerService.updateFlyer(1L, updatedFlyer);
//
//        assertNotNull(result, "Updated flyer should not be null");
//        assertEquals("Winter Sale", result.getName(), "Flyer title should be updated");
//        verify(flyerRepository, times(1)).findById(1L);
//        verify(flyerRepository, times(1)).save(existingFlyer);
//    }

}