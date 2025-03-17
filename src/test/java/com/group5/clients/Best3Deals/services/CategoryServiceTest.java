package com.group5.clients.Best3Deals.services;

import com.group5.clients.Best3Deals.entities.Category;
import com.group5.clients.Best3Deals.entities.CategoryRepository;
import com.group5.clients.Best3Deals.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void testAddCategory() {
        // Arrange
        Category category = new Category(1L, "Electronics");
        when(categoryRepository.save(category)).thenReturn(category);

        // Act
        Category savedCategory = categoryService.addCategory(category);

        // Assert
        assertNotNull(savedCategory, "Saved category should not be null");
        assertEquals("Electronics", savedCategory.getName(), "Category name should match");
        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    public void testFindCategoryById() throws ResourceNotFoundException {
        // Arrange
        Category category = new Category(1L, "Electronics");
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        // Act
        Category foundCategory = categoryService.findCategoryById(1L);

        // Assert
        assertNotNull(foundCategory, "Found category should not be null");
        assertEquals(1L, foundCategory.getId(), "Category ID should match");
        verify(categoryRepository, times(1)).findById(1L);
    }

    @Test
    public void testFindCategoryByName() throws ResourceNotFoundException {
        // Arrange
        Category category = new Category(1L, "Electronics");
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(category));

        // Act
        Category foundCategory = categoryService.findCategoryByName("Electronics");

        // Assert
        assertNotNull(foundCategory, "Found category should not be null");
        assertEquals("Electronics", foundCategory.getName(), "Category name should match");
        verify(categoryRepository, times(1)).findByName("Electronics");
    }

    @Test
    public void testDeleteCategory() {
        // Arrange
        doNothing().when(categoryRepository).deleteById(1L);

        // Act
        categoryService.deleteCategory(1L);

        // Assert
        verify(categoryRepository, times(1)).deleteById(1L);
    }

//    @Test
//    public void testUpdateCategory() throws ResourceNotFoundException {
//        // Correct stubbing to match the actual invocation
//        Category expectedCategory = Category.builder().name("").id(1L).build();
//        when(categoryRepository.save(Category.builder().name("Gadgets").build()))
//                .thenReturn(expectedCategory);
//
//        // Code under test
//        Category updatedCategory = categoryService.updateCategory(1L, Category.builder().name("Gadgets").build());
//
//        // Assertions
//        assertNotNull(updatedCategory);
//        assertEquals("Gadgets", updatedCategory.getName());
//    }
}