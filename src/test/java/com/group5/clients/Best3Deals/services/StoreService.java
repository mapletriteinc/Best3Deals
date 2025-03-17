package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.Store;
import com.group5.clients.Best3Deals.exception.ResourceNotFoundException;
import com.group5.clients.Best3Deals.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreService {
    @Autowired
    StoreRepository storeRepository;
    public Store addStore(Store store) {
        return storeRepository.save(store);
    }

    public Store findStoreById(long storeId) throws ResourceNotFoundException {
        return storeRepository.findById(storeId)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + storeId));
    }

    public Store findStoreByName(String bestBuy) throws ResourceNotFoundException {
        return storeRepository.findByName(bestBuy)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with name: " + bestBuy));
    }

    public void deleteStore(long l) {

    }

    public Store updateStore(long l, Store updatedStore) {
        return null;
    }
}
