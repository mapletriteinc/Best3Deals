package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.Location;
import com.group5.clients.Best3Deals.entities.Store;
import com.group5.clients.Best3Deals.exception.ResourceNotFoundException;
import com.group5.clients.Best3Deals.repositories.StoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private StoreService storeService;

    @Test
    public void testAddStore() {
        // Arrange
        Store store = new Store(1L, "Best Buy", "123 Main St", new Location(1L, 44.6488, -63.5752, null));
        when(storeRepository.save(store)).thenReturn(store);

        // Act
        Store savedStore = storeService.addStore(store);

        // Assert
        assertNotNull(savedStore, "Saved store should not be null");
        assertEquals("Best Buy", savedStore.getName(), "Store name should match");
        verify(storeRepository, times(1)).save(store);
    }

    @Test
    public void testFindStoreById() throws ResourceNotFoundException {
        // Arrange
        Store store = new Store(1L, "Best Buy", "123 Main St", new Location(1L, 44.6488, -63.5752, null));
        when(storeRepository.findById(1L)).thenReturn(Optional.of(store));

        // Act
        Store foundStore = storeService.findStoreById(1L);

        // Assert
        assertNotNull(foundStore, "Found store should not be null");
        assertEquals(1L, foundStore.getId(), "Store ID should match");
        verify(storeRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindStoreByName() throws ResourceNotFoundException {
        // Arrange
        Store store = new Store(1L, "Best Buy", "123 Main St", new Location(1L, 44.6488, -63.5752, null));
        when(storeRepository.findByName("Best Buy")).thenReturn(Optional.of(store));

        // Act
        Store foundStore = storeService.findStoreByName("Best Buy");

        // Assert
        assertNotNull(foundStore, "Found store should not be null");
        assertEquals("Best Buy", foundStore.getName(), "Store name should match");
        verify(storeRepository, times(1)).findByName("Best Buy");
    }

//    @Test
//    public void testDeleteStore() {
//        // Arrange
//        doNothing().when(storeRepository).deleteById(1L);
//
//        // Act
//        storeService.deleteStore(1L);
//
//        // Assert
//        verify(storeRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testUpdateStore() {
//        // Arrange
//        Store existingStore = new Store(1L, "Best Buy", "123 Main St", new Location(1L, 44.6488, -63.5752, null));
//        Store updatedStore = new Store(1L, "Best Buy Halifax", "456 New St", new Location(1L, 44.6488, -63.5752, null));
//        when(storeRepository.findById(1L)).thenReturn(Optional.of(existingStore));
//        when(storeRepository.save(existingStore)).thenReturn(updatedStore);
//
//        // Act
//        Store result = storeService.updateStore(1L, updatedStore);
//
//        // Assert
//        assertNotNull(result, "Updated store should not be null");
//        assertEquals("Best Buy Halifax", result.getName(), "Store name should be updated");
//        verify(storeRepository, times(1)).findById(1L);
//        verify(storeRepository, times(1)).save(existingStore);
//    }
}