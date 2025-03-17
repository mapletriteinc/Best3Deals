package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.Category;
import com.group5.clients.Best3Deals.entities.CategoryRepository;
import com.group5.clients.Best3Deals.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category findCategoryById(long categoryId) throws ResourceNotFoundException{
       return categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("No category with input: "+ categoryId));
    }

    public Category findCategoryByName(String categoryName) throws ResourceNotFoundException{
        return categoryRepository.findByName(categoryName).orElseThrow(() -> new ResourceNotFoundException("No category with input: "+ categoryName));
    }

    public void deleteCategory(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(long categoryId, Category updatedCategory) throws ResourceNotFoundException {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("No category with input: "+ categoryId));
        Category category = Category.builder().name(updatedCategory.getName()).build();
        categoryRepository.save(category);
        return category;
    }
}
