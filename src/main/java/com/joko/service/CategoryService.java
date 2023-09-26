package com.joko.service;
import java.util.List;

import com.joko.dao.Category;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long categoryId);

    Category createCategory(Category category);

    Category updateCategory(Long categoryId, Category category);

    void deleteCategory(Long categoryId);
}
